CREATE TABLE usuarios(
	id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(30) NOT NULL,
	cpf VARCHAR(11) NOT NULL UNIQUE,
	email VARCHAR(30) NOT NULL,
	senha VARCHAR(10) NOT NULL,
	cargo VARCHAR(20) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO usuarios (nome, cpf,email,senha,cargo) values ("Vagner Ferreira da Paixão", "999999999", "vagner@teste.com.br", "senha", "Administrador");
INSERT INTO usuarios (nome, cpf,email,senha,cargo) values ("João da Silva", "33333333333", "JOAO@teste.com.br", "senha", "badeco");

 


