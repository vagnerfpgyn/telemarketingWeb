CREATE TABLE telefones(
	id_telefone INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	telefone varchar(9) NOT NULL UNIQUE,
	id_cidade INT NOT NULL,
	id_referencia INT,
	tipo CHAR NOT NULL,
	data_cadastro DATE NOT NULL,
	FOREIGN KEY (id_cidade) REFERENCES cidades(id_cidade),
	FOREIGN KEY (id_referencia) REFERENCES referencias(id_referencia)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO telefones (telefone, id_cidade, id_referencia, tipo, data_cadastro) VALUES ("00000000", 1,1, "f", '2018/12/26');
INSERT INTO telefones (telefone, id_cidade, id_referencia, tipo, data_cadastro) VALUES ("11111111", 2,1, "f", '2018/12/26');
INSERT INTO telefones (telefone, id_cidade, id_referencia, tipo, data_cadastro) VALUES ("22222222", 3,2, "f", '2018/12/26');
INSERT INTO telefones (telefone, id_cidade, id_referencia, tipo, data_cadastro) VALUES ("33333333", 4,2, "f", '2018/12/26');
INSERT INTO telefones (telefone, id_cidade, id_referencia, tipo, data_cadastro) VALUES ("44444444", 5,3, "f", '2018/12/26');
INSERT INTO telefones (telefone, id_cidade, id_referencia, tipo, data_cadastro) VALUES ("55555555", 6,3, "f", '2018/12/26');
INSERT INTO telefones (telefone, id_cidade, id_referencia, tipo, data_cadastro) VALUES ("66666666", 7,5, "f", '2018/12/26');
INSERT INTO telefones (telefone, id_cidade, id_referencia, tipo, data_cadastro) VALUES ("77777777", 7,5, "c", '2018/12/26');
INSERT INTO telefones (telefone, id_cidade, id_referencia, tipo, data_cadastro) VALUES ("88888888", 9,5, "c", '2018/12/26');
INSERT INTO telefones (telefone, id_cidade, id_referencia, tipo, data_cadastro) VALUES ("99999999", 8,4, "c", '2018/12/26');

