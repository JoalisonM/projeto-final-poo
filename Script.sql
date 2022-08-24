create table empresa (
	cnpj varchar(14) not null,
	nome varchar(120) UNIQUE not null,
	
	constraint pk_empresa primary key(cnpj)
);

create sequence filial_codigo_seq;

create table filial (
	codigo integer default nextval('filial_codigo_seq'),
	nome varchar(120) not null,
	tipo varchar(50) not null,
	rua text not null,
	bairro text not null,
	cidade text not null,
	cnpj_empresa varchar(14) not null,
	
	constraint pk_filial primary key(codigo),
	constraint fk_filial_empresa foreign key(cnpj_empresa) references empresa(cnpj)
);

create sequence departamento_codigo_seq;

create table departamento (
	codigo integer default nextval('departamento_codigo_seq'),
	nome varchar(80) not null,
	email varchar(256) not null,
	codigo_filial integer not null,
	
	constraint pk_departamento primary key(codigo),
	constraint fk_departamento_filial foreign key(codigo_filial) references filial(codigo)
);

create table funcionario (
	cpf varchar(11) unique not null,
	nome varchar(120) not null,
	telefone varchar(14) not null,
	email varchar(256) not null,
	idade integer not null,
	funcao varchar(250) not null,
	codigo_departamento integer not null,
	
	constraint pk_funcionario primary key(CPF),
	constraint fk_funcionario_departamento foreign key(codigo_departamento) references departamento(codigo)
);

create sequence categoria_codigo_seq;

create table categoria (
	codigo integer default nextval('categoria_codigo_seq'),
	nome varchar(80) not null,
	
	constraint pk_categoria primary key(codigo)
);

create sequence produto_codigo_seq;

create table produto (
	codigo integer default nextval('produto_codigo_seq'),
	nome varchar(150) not null,
	quantidade integer not null,
	valor float not null,
	descricao text not null,
	codigo_categoria integer not null,
	codigo_filial integer not null,
	
	constraint pk_produto primary key(codigo),
	constraint fk_produto_filial foreign key(codigo_filial) references filial(codigo),
	constraint fk_produto_categoria foreign key(codigo_categoria) references categoria(codigo)
);
