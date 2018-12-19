CREATE TABLE status (
    id_status int PRIMARY KEY AUTO_INCREMENT,
    nome_status VARCHAR (20) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO status (nome_status) values ('Retornar');
INSERT INTO status (nome_status) values ('Visita Agendada');