CREATE DATABASE db_rh;

USE db_rh;

CREATE TABLE tb_colaboradores(
	id BIGINT AUTO_INCREMENT,
		nome VARCHAR (255) NOT NULL,
        salario DECIMAL (10,2),
        cargo VARCHAR (255),
        departamento VARCHAR (255),
        email VARCHAR (255),
	PRIMARY KEY (id)
);

INSERT INTO tb_colaboradores (nome, salario, cargo, departamento, email)
	VALUES ("Eleanor Shellstrop", 6000.00, "Gerente", "Almoxarifado", "eleanor.shell@thegoodplace.com");
INSERT INTO tb_colaboradores (nome, salario, cargo, departamento, email)
	VALUES ("Chidi Anagonye", 4000.00, "Reitor", "Reitoria", "chidi.anagonye@thegoodplace.com");
INSERT INTO tb_colaboradores (nome, salario, cargo, departamento, email)
	VALUES ("Tahani Al-Jamil", 8000.00, "Gestora de Projetos", "RH", "jameela.aljamil@thegoodplace.com");
INSERT INTO tb_colaboradores (nome, salario, cargo, departamento, email)
	VALUES ("Jason Mendoza", 4000.00, "Professor", "Faculdade de Dança", "jason.mendoza@thegoodplace.com");
INSERT INTO tb_colaboradores (nome, salario, cargo, departamento, email)
	VALUES ("Janet", 6000.00, "Consultant", "Diretoria Geral", "janet@thegoodplace.com");
    
    
SELECT * FROM tb_colaboradores;

SELECT * FROM tb_colaboradores WHERE salario > 2000.00;

SELECT * FROM tb_colaboradores WHERE salario < 2000.00;

UPDATE tb_colaboradores SET salario = 7500.00 WHERE id = 2;

SELECT * FROM tb_colaboradores;
