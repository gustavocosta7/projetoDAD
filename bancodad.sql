create database dad;
use dad;

create table produto(
	proid int auto_increment not null primary key,
    pronome varchar(80) not null,
    provalor double
);

insert into produto(pronome,provalor) values 
('Leite',8.5),
('Arroz',2.5),
('Refrigerante',3.5),
('Biscoito',1.5);

select * from produto;