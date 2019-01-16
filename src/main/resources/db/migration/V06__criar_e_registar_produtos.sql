CREATE TABLE produtos (
	id_produto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome_produto VARCHAR(20) NOT NULL,
	id_status INT 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO produtos (nome_produto) values ("Serasa");
INSERT INTO produtos (nome_produto) values ("Direct Gyn");
INSERT INTO produtos (nome_produto) values ("Certificado Digital");


