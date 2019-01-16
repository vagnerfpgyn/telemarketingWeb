CREATE TABLE cidades (
	id_cidade INT PRIMARY KEY AUTO_INCREMENT,
	nome_cidade varchar(30) NOT NULL,
	ddd int not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO cidades (nome_cidade, ddd) values ("Goiânia", 062);	
INSERT INTO cidades (nome_cidade, ddd) values  ("Senador Canedo", 062);
	
