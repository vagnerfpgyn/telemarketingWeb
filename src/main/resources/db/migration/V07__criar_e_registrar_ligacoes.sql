CREATE TABLE ligacoes(
	id_ligacao INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	data_hora VARCHAR(50) NOT NULL,
	resumo VARCHAR (600) NOT NULL,
	id_cadastro INT NOT NULL,
	id_produto INT NOT NULL,
	id_usuario 	INT NOT NULL
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;


	
