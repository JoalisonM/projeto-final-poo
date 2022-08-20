create table empresa (
	CNPJ varchar(14) not null,
	nome varchar(120) UNIQUE not null,
	
	constraint pk_empresa primary key(CNPJ)
);

create sequence filial_codigo_seq;

create table filial (
	codigo integer,
	nome varchar(120) not null,
	tipo varchar(50) not null,
	rua text not null,
	bairro text not null,
	cidade text not null,
	CNPJEmpresa varchar(14) not null,
	
	constraint pk_filial primary key(codigo),
	constraint fk_filial_empresa foreign key(CNPJEmpresa) references empresa(CNPJ)
);

create sequence departamento_codigo_seq;

create table departamento (
	codigo integer,
	nome varchar(80) not null,
	email varchar(256) not null,
	codigoFilial integer not null,
	
	constraint pk_departamento primary key(codigo),
	constraint fk_departamento_filial foreign key(codigoFilial) references filial(codigo)
);

create table funcionario (
	CPF varchar(11) unique not null,
	nome varchar(120) not null,
	telefone varchar(14) not null,
	email varchar(256) not null,
	idade integer not null,
	funcao varchar(250) not null,
	codigoDepartamento integer not null,
	
	constraint pk_funcionario primary key(CPF),
	constraint fk_funcionario_departamento foreign key(codigoDepartamento) references departamento(codigo)
);

create sequence categoria_codigo_seq;

create table categoria (
	codigo integer,
	nome varchar(80) not null,
	
	constraint pk_categoria primary key(codigo)
);

create sequence produto_codigo_seq;

create table produto (
	codigo integer ,
	nome varchar(150) not null,
	quantidade integer not null,
	valor float not null,
	descricao text not null,
	codigoCategoria integer not null,
	codigoFilial integer not null,
	
	constraint pk_produto primary key(codigo),
	constraint fk_produto_filial foreign key(codigoFilial) references filial(codigo),
	constraint fk_produto_categoria foreign key(codigoCategoria) references categoria(codigo)
);