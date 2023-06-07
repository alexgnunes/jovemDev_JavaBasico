--1. Selecionar todos os registros e atributos da entidade cargo.
select
	*
from
	cargo c ;
--2. Selecionar  a quantidade de vereadores da entidade cidade, ordenado pelo nome da cidade.
select
	c.nome,
	c.qt_vereadores
from
	cidade c
order by
	c.nome ;
--3. Selecionar  a quantidade de vereadores da entidade cidade, somente das cidades
--que possuem mais de 9 vereadores.
select
	c.nome,
	c.qt_vereadores
from
	cidade c
where
	c.qt_vereadores >9
order by
	c.nome;
--4. Selecionar quantas cidades possuem mais de 9 vereadores.
select
	count(*)
from
	cidade c
where
	c.qt_vereadores >9 ;
--5. Selecionar a quantidade máxima de vereadores que uma cidade possui.
select
	max(c.qt_vereadores)
from
	cidade c ;
--6. Selecionar o nome da cidade que possui mais vereadores.
select
	c.nome
from
	cidade c
where
	qt_vereadores = (
	select
		max(c2.qt_vereadores)
	from
		cidade c2);
--7. Selecionar o nome dos candidatos a prefeito ordenados pelo nome
select
	c.nome
from
	candidato c
inner join cargo on
	cargo.id = c.cargo
where
	cargo.nome = 'Prefeito'
order by
	c.nome;
--8. Selecionar o nome dos candidatos a vereador que possuem "maria" no nome
--ordenados pelo nome.
select
	nome
from
	candidato
where
	nome like '%MARIA%'
order by
	nome;
--9. Selecionar o nome dos candidatos a vereador que iniciam com 'Y' - ordenado pelo nome.
select
	candidato.nome
from
	candidato
inner join cargo on
	cargo.id = candidato.cargo
where
	candidato.nome like 'Y%'
order by
	candidato .nome ;
--10. Selecionar o nome dos candidatos a prefeito de cada cidade, ordenado pelo nome da
--cidade e em seguida pelo nome do candidato.
select
	candidato.nome,
	cargo.nome,
	candidato.cargo,
	cidade.nome
from
	candidato
inner join cargo on
	cargo.id = candidato.cargo
inner join cidade on
	cidade.id = candidato.cidade
where
	cargo.nome = 'Prefeito'
order by
	cidade.nome,
	candidato.nome;
--11. Selecionar o nome dos candidatos a prefeito da cidade de 'TUBARÃO', ordenado
--pelo nome do candidato
select
	candidato.nome,
	candidato.cargo,
	cidade.nome
from
	candidato
inner join cargo on
	cargo.id = candidato.cargo
	and cargo.nome = 'Prefeito'
inner join cidade on
	cidade.id = candidato.cidade
	and cidade.nome = 'TUBARÃO';
--12. Selecionar o nome dos candidatos a prefeito da cidade que tem o maior número de eleitores.
select
	candidato.nome,
	candidato.cargo,
	cidade.nome
from
	candidato
inner join cargo on
	cargo.id = candidato.cargo
	and cargo.nome = 'Prefeito'
inner join cidade on
	cidade.id = candidato.cidade
	and cidade.qt_eleitores =(
	select
		max(cidade.qt_eleitores)
	from
		cidade );
--13. Selecionar a quantidade de candidatos a vereador da cidade de 'TUBARÃO’.
select
	count(*)
from
	candidato
inner join cidade c on
	c.id = candidato.cidade
	and c.nome = 'TUBARÃO'
inner join cargo car on
	car.id = candidato.cargo
	and car.nome = 'Vereador';
--14. Selecionar a quantidade de candidatos a vereador de cada cidade, ordenado pelo nome da cidade.
select
	c.nome ,
	COUNT(*)
from
	candidato cand
inner join cidade c on
	c.id = cand.cidade
inner join cargo car on
	car.id = cand.cargo
	and car.nome = 'Vereador'
group by
	c.nome
order by
	c.nome;
--15. Selecionar a quantidade de votos nulos e brancos para prefeito e para vereador da cidade de Tubarão.
select
	cargo.nome,
	vi.brancos,
	vi.nulos
from
	cargo
inner join voto_invalido vi on
	vi.cargo = cargo.id
inner join cidade c on
	c.id = vi.cidade
	and c.nome = 'TUBARÃO';
--16. Selecionar a quantidade de votos INVÁLIDOS (BRANCOS + NULOS) para prefeito da cidade de Tubarão.
select
	vi.brancos + vi.nulos as total
from
	voto_invalido vi
inner join cidade c on
	c.id = vi.cidade
	and c.nome = 'TUBARÃO'
inner join cargo car on
	car.id = vi.cargo
	and car.nome = 'Prefeito';
--17. Selecionar a quantidade de votos válidos para cada candidato a prefeito da cidade de Tubarão,
-- ordenados pela maior quantidade de votos
select cand.nome ,v.voto
from candidato cand
inner join cidade c on c.id = cand.cidade and c.nome ='TUBARÃO'
inner join cargo on cargo.id = cand.cargo and cargo.nome = 'Prefeito'
inner join voto v on v.candidato  = cand.id  
order by v.voto desc  ;

--18. Selecionar a quantidade de votos válidos para CADA candidato a vereador da cidade de Tubarão 
--ordenados pela maior quantidade de votos.
select cand.nome, v.voto
from candidato cand
inner join cidade c on c.id = cand.cidade and c.nome ='TUBARÃO'
inner join cargo on cargo.id = cand.cargo  and cargo.nome = 'Vereador'
inner join voto v on v.candidato = cand.id 
order by v.voto desc;

--19. Selecionar a maior quantidade de votos para prefeito de cada cidade.
select c.nome, max(v.voto) 
from cidade c 
inner join candidato cand on cand.cidade = c.id 
inner join voto v on v.candidato = cand.id
inner join cargo on cargo.id = cand.cargo and cargo.nome = 'Prefeito'
group by c.nome;

-- 20. Selecionar os partidos e a quantidade de votos de cada um na cidade de Tubarão
-- ordenados pela maior quantidade de votos.
select p.sigla, sum(v.voto)
from partido p 
inner join candidato cand on cand.partido = p.id 
inner join cidade c on c.id  = cand.cidade and c.nome = 'TUBARÃO'
inner join voto v on v.candidato = cand.id 
group by p.sigla
order by sum(v.voto) desc;


--21. Selecionar a quantidade de votos registrados para prefeito na cidade de tubarão.
-- Os votos registrados são considerados os votos para os candidatos, mais os votos brancos e nulos.
select (select sum (v.voto)
from voto v
inner join candidato cand on cand.id = v.candidato 
inner join cidade c on c.id = cand.cidade  and c.nome = 'TUBARÃO'
inner join cargo on cargo.id = cand.cargo and cargo.id = cand.cargo and cargo.nome ='Prefeito') +
       (select (vi.brancos + vi.nulos)
        FROM voto_invalido vi
        inner join cargo on cargo.id = vi.cargo and cargo.nome = 'Prefeito'
        inner join cidade c on c.id = vi.cidade and c.nome = 'TUBARÃO') as total_votos;


 --22. Selecionar a quantidade de eleitores que deixaram de votar na cidade de tubarão.
       
select (select c.qt_eleitores 
from cidade c 
where c.nome = 'TUBARÃO') -
		((select sum (v.voto)
		from voto v
		inner join candidato cand on cand.id = v.candidato 
		inner join cidade c on c.id = cand.cidade  and c.nome = 'TUBARÃO'
		inner join cargo on cargo.id = cand.cargo and cargo.id = cand.cargo and cargo.nome ='Prefeito') +
		        (select (vi.brancos + vi.nulos)
		        FROM voto_invalido vi
		        inner join cargo on cargo.id = vi.cargo and cargo.nome = 'Prefeito'
		        inner join cidade c on c.id = vi.cidade and c.nome = 'TUBARÃO'))  as abstencoes;
		        
        
--23. Selecionar a quantidade de eleitores que deixaram de votar em cada cidade,
--ordenado pela maior quantidade de faltantes.
		       
select c.nome,  c.qt_eleitores - 
  (
    (select sum(v.voto)
    from voto v
    inner join candidato cand on cand.id = v.candidato 
    inner join cidade ci on ci.id = cand.cidade
    inner join cargo on cargo.id = cand.cargo and cargo.nome = 'Prefeito'
    where ci.id = c.id)
    +
    (select sum(vi.brancos + vi.nulos)
    from voto_invalido vi
    inner join cargo on cargo.id = vi.cargo and cargo.nome = 'Prefeito'
    where vi.cidade = c.id)
  ) as abstencoes
from cidade c
order by abstencoes desc;		


--24. Selecionar o percentual de faltantes em cada cidade, ordenado pelo maior percentual.
 select c.nome, round((( c.qt_eleitores - 
  (
    (select sum(v.voto)
    from voto v
    inner join candidato cand on cand.id = v.candidato 
    inner join cidade ci on ci.id = cand.cidade
    inner join cargo on cargo.id = cand.cargo and cargo.nome = 'Prefeito'
    where ci.id = c.id)
    +
    (select sum(vi.brancos + vi.nulos)
    from voto_invalido vi
    inner join cargo on cargo.id = vi.cargo and cargo.nome = 'Prefeito'
    where vi.cidade = c.id)
  )) * 100 / c.qt_eleitores),2) as percentual_faltantes
from cidade c
order by percentual_faltantes desc;	

--25. Selecionar o candidato a prefeito eleito de cada cidade, ordenado pelo nome da cidade.
select c.nome, cand.nome, v.max_votos
from cidade c
inner join (
    SELECT cand.cidade, MAX(v.voto) AS max_votos
    FROM candidato cand
    inner join voto v ON v.candidato = cand.id
    inner join cargo ON cargo.id = cand.cargo AND cargo.nome = 'Prefeito'
    group by cand.cidade
) v on v.cidade = c.id
inner join candidato cand ON cand.cidade = c.id
inner join voto v2 ON v2.candidato = cand.id AND v2.voto = v.max_votos
order by c.nome;