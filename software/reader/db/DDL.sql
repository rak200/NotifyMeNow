create table assunto
(
	idassunto integer primary key,	
	nome text not null
)
;

create table site
(
	idsite integer primary key,
	link text not null,
	nome text not null
)
;

create table feed
(
	idnoticia integer primary key,
	idsite integer not null,
	titulo text not null,
	conteudo text,
	data datetime not null,
	link text not null,
	constraint fk_noticia_site foreign key (idsite) references feed (idsite) 
)
;

create table horario
(
	idhorario integer primary key,
	hora integer not null,
	minuto integer not null,
	segundo integer not null
)
;