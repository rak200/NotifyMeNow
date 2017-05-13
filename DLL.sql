CREATE TABLE Assunto
(
	idAssunto INTEGER NOT NULL,
	descricao TEXT,
	CONSTRAINT PK_Assunto PRIMARY KEY (idAssunto)
)
;

CREATE TABLE Horario
(
	mes INTEGER,
	dia INTEGER,
	ano INTEGER
)
;

CREATE TABLE Noticia
(
	idNoticia INTEGER NOT NULL,
	titulo TEXT,
	dataHora TEXT,
	descricao TEXT,
	CONSTRAINT PK_Noticia PRIMARY KEY (idNoticia)
)
;

CREATE TABLE Site
(
	link TEXT,
	idSite INTEGER NOT NULL,
	nome TEXT,
	idNoticia INTEGER,
	CONSTRAINT PK_Site PRIMARY KEY (idSite),
	CONSTRAINT FK_Site_Noticia FOREIGN KEY (idNoticia)
		REFERENCES Noticia(idNoticia) 
)
;

CREATE TABLE Site_Asunto
(
	idAssunto INTEGER,
	idSite INTEGER,
	CONSTRAINT FK_Tem_Site FOREIGN KEY (idAssunto)
		REFERENCES Assunto(idAssunto) ,
	CONSTRAINT FK_Tem_Assunto FOREIGN KEY (idSite)
		REFERENCES Site(idSite) 
)
;
