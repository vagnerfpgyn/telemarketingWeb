CREATE TABLE cadastros (
	id_cadastro  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	empresa	 VARCHAR(30),
	responsavel VARCHAR (20),
	email1 VARCHAR(30),
	email2 VARCHAR(30),
	id_celular1 VARCHAR(30),
	id_celular2 VARCHAR(30),
	id_telefone1 INT NOT NULL,
	id_telefone2 INT,
	id_telefone3 INT,
	id_telefone4 INT,
	observacao VARCHAR (200)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO cadastros (empresa, responsavel, email1, email2, id_celular1, id_celular2,id_telefone1, id_telefone2, id_telefone3, id_telefone4, observacao) VALUES ("Escola os Sabidões", "Zé Sabichão", "zesabichao@ossabichoes.com.br", null, null, null,1,null,null,null,null);
