
--1. Selecionar todos os registros e atributos da entidade cargo.
select * from cargo c ;

--2. Selecionar  a quantidade de vereadores da entidade cidade, ordenado pelo nome da cidade.
select c.nome, c.qt_vereadores  from cidade c order by c.nome ;

--3. Selecionar  a quantidade de vereadores da entidade cidade, somente das cidades
--que possuem mais de 9 vereadores.
select c.nome, c.qt_vereadores  from cidade c  where  c.qt_vereadores >9 order by c.nome;

--4. Selecionar quantas cidades possuem mais de 9 vereadores.
select  count(*)  from cidade c  where  c.qt_vereadores >9 ;

--5. Selecionar a quantidade máxima de vereadores que uma cidade possui.
select  max(c.qt_vereadores)  from cidade c  ;

--6. Selecionar o nome da cidade que possui mais vereadores.
select  c.nome  from cidade c  where qt_vereadores = (select  max(c2.qt_vereadores)  from cidade c2);

--7. Selecionar o nome dos candidatos a prefeito ordenados pelo nome
select c.nome from candidato c inner join cargo on cargo.id = c.cargo  where cargo.nome = 'Prefeito' order by c.nome;

--8. Selecionar o nome dos candidatos a vereador que possuem "maria" no nome
--ordenados pelo nome.
select nome from candidato  where nome like '%MARIA%' order by nome;

--9. Selecionar o nome dos candidatos a vereador que iniciam com 'Y' - ordenado pelo nome.
select candidato.nome from candidato  inner join cargo on cargo.id = candidato.cargo where candidato.nome like 'Y%' order by candidato .nome  ;  

--10. Selecionar o nome dos candidatos a prefeito de cada cidade, ordenado pelo nome da
--cidade e em seguida pelo nome do candidato.
select candidato.nome,cargo.nome, candidato.cargo, cidade.nome from candidato 
inner join cargo on cargo.id = candidato.cargo 
inner join cidade on cidade.id = candidato.cidade where cargo.nome = 'Prefeito'
order by  cidade.nome, candidato.nome;

--11. Selecionar o nome dos candidatos a prefeito da cidade de 'TUBARÃO', ordenado
--pelo nome do candidato
select candidato.nome, candidato.cargo, cidade.nome from candidato 
inner join cargo on cargo.id = candidato.cargo 
inner join cidade on cidade.id = candidato.cidade
where cargo.id = 1 and cidade.nome = 'TUBARÃO';

--12. Selecionar o nome dos candidatos a prefeito da cidade que tem o maior número de eleitores.
select candidato.nome, candidato.cargo, cidade.nome from candidato 
inner join cargo on cargo.id = candidato.cargo 
inner join cidade on cidade.id = candidato.cidade
where cargo.nome = 'Prefeito' and cidade.qt_eleitores =(select  max(cidade.qt_eleitores)  from cidade cidade);

--13. Selecionar a quantidade de candidatos a vereador da cidade de 'TUBARÃO’.
select  count(*)  from candidato  
inner join cidade c on c.id  = candidato.cidade 
inner join cargo car  on car.id = candidato.cargo 
where  c.nome = 'TUBARÃO'  and car.nome  = 'Vereador';

--14. Selecionar a quantidade de candidatos a vereador de cada cidade, ordenado pelo nome da cidade.
select c.nome , COUNT(*)
from candidato cand
inner join cidade c on c.id = cand.cidade
inner join cargo car on car.id = cand.cargo
where  car.nome = 'Vereador'
group  by c.nome
order by c.nome;


--15. Selecionar a quantidade de votos nulos e brancos para prefeito e para vereador da cidade de Tubarão.
select sum(vi.brancos + vi.nulos) 
from voto_invalido vi 
inner join cidade c on c.id = vi.cidade 
where c.nome = 'TUBARÃO';

--16. Selecionar a quantidade de votos INVÁLIDOS (BRANCOS + NULOS) para prefeito da cidade de Tubarão.
select sum(vi.brancos + vi.nulos) 
from voto_invalido vi 
inner join cidade c on c.id = vi.cidade 
inner join cargo car on car.id = vi.cargo 
where c.nome = 'TUBARÃO' and car.nome = 'Prefeito';

--17. Selecionar a quantidade de votos válidos para cada candidato a prefeito da cidade de Tubarão, ordenados pela maior quantidade de votos























