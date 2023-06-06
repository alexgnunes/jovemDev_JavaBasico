
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
select nome from candidato  order by nome;

--8. Selecionar o nome dos candidatos a vereador que possuem "maria" no nome
--ordenados pelo nome.
select nome from candidato  where nome like '%MARIA%' order by nome;

--9. Selecionar o nome dos candidatos a vereador que iniciam com 'Y' - ordenado pelo nome.
select candidato.nome from candidato  inner join cargo on cargo.id = candidato.cargo where candidato.nome like 'Y%' order by candidato .nome  ;  

--10. Selecionar o nome dos candidatos a prefeito de cada cidade, ordenado pelo nome da
--cidade e em seguida pelo nome do candidato.
select candidato.nome, candidato.cargo, cidade.nome from candidato inner join cargo on cargo.id = candidato.cargo inner join cidade on cidade.id = candidato.cidade where cargo.id = 1
order by  cidade.nome, candidato.nome;