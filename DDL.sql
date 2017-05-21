CREATE TABLE Assunto
(
	idAssunto  NOT NULL PRIMARY KEY,
	nome ,
	CONSTRAINT PK_Assunto PRIMARY KEY (idAssunto)
)
;

CREATE TABLE Feed
(
	idNoticia INTEGER NOT NULL PRIMARY KEY,
	titulo TEXT,
	conteudo TEXT,
	data TEXT,
	link TEXT,
	CONSTRAINT PK_Noticia PRIMARY KEY (idNoticia)
)
;

CREATE TABLE Horario
(
	idHorario INTEGER NOT NULL PRIMARY KEY,
	hora INTEGER NOT NULL,
	minuto INTEGER NOT NULL,
	segundo INTEGER NOT NULL,
	CONSTRAINT PK_Horario PRIMARY KEY (idHorario)
)
;

CREATE TABLE Site
(
	idSite INTEGER NOT NULL PRIMARY KEY,
	link TEXT,
	nome TEXT,
	idNoticia INTEGER,
	CONSTRAINT PK_Site PRIMARY KEY (idSite),
	CONSTRAINT FK_Site_Noticia FOREIGN KEY (idNoticia)
		REFERENCES Feed(idNoticia) 
)
;
