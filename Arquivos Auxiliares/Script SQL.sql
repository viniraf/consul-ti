drop database if exists ConsulTI;
create database ConsulTI;
use ConsulTI;

create table provider (
id				int				auto_increment			primary key,
name			varchar(50)		not null,
cpf				varchar(20)		not null				unique,
email			varchar(50)		not null				unique,
registration	int				not null				unique,
login			varchar(30)		not null				unique,
password		varchar(40)		not null,
category		varchar(30)		not null
);

create table employee (
id				int				auto_increment			primary key,
name			varchar(50)		not null,
cpf				varchar(20)		not null				unique,
email			varchar(50)		not null				unique,
registration	int				not null				unique,
login			varchar(30)		not null				unique,
password		varchar(40)		not null,
area			varchar(30)		not null
);

create table company (
id				int				auto_increment		primary key,
name			varchar(50)		not null			unique,
cnpj			varchar(14)		not null			unique,				
category		varchar(50)		not null,
monthsContractTime	int			not null,
dateCreation	date			default(SYSDATE()) 
);

create table services (
id				int				auto_increment		primary key,
description		varchar(150)	not null,
category		varchar(30)		not null,
requester		varchar(40)		not null,
finished		char			not null			default 'N',
idProvider		int				not null			references provider(id),
idCompany		int				not null			references company(id),
dateCreation	date			default(SYSDATE())
);
