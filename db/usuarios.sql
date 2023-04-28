create table usuarios (
	id int not null auto_increment,
	nome varchar(60),
    usuario varchar(10) unique,
    senha varchar(30),
    primary key (id)
);

insert into usuarios (nome, usuario, senha) values ('Milena Cristina', 'milena', '123');

