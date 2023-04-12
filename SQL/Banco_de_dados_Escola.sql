CREATE DATABASE db_escola;
USE db_escola;
CREATE TABLE tb_estudantes(
	id BIGINT AUTO_INCREMENT,
		nome VARCHAR (255),
        idade INT,
        aniversario VARCHAR (255),
        classe VARCHAR (255),
        ano INT,
        necessidadesespeciais BOOLEAN,
	PRIMARY KEY (id) 
    );
	
INSERT INTO tb_estudantes (nome, idade, aniversario, classe, ano, necessidadesespeciais)
	values ("Harry Potter", 11, "31/07/1980", "B", 1, false);
INSERT INTO tb_estudantes (nome, idade, aniversario, classe, ano, necessidadesespeciais)
	values ("Hermione Granger", 12, "19/09/1979", "B", 1, false);
INSERT INTO tb_estudantes (nome, idade, aniversario, classe, ano, necessidadesespeciais)
	values ("Ronald Weasley", 12, "01/03/1980", "B", 1, false);
INSERT INTO tb_estudantes (nome, idade, aniversario, classe, ano, necessidadesespeciais)
	values ("Luna Lovegood", 11, "13/02/1981", "C", 1, false);
INSERT INTO tb_estudantes (nome, idade, aniversario, classe, ano, necessidadesespeciais)
	values ("Neville Longbotton", 11, "31/07/1980", "B", 1, false);
INSERT INTO tb_estudantes (nome, idade, aniversario, classe, ano, necessidadesespeciais)
	values ("Fred Weasley", 13, "01/05/1978", "B", 3, false);
INSERT INTO tb_estudantes (nome, idade, aniversario, classe, ano, necessidadesespeciais)
	values ("Jorge Weasley", 13, "01/05/1978", "B", 3, true);
INSERT INTO tb_estudantes (nome, idade, aniversario, classe, ano, necessidadesespeciais)
	values ("Dino Thomas", 11, "05/12/1979", "A", 3, false);
    
SET SQL_SAFE_UPDATES = 0;
DELETE FROM tb_estudantes;

SET SQL_SAFE_UPDATES = 1;
SELECT * FROM tb_estudantes;

UPDATE tb_estudantes SET classe = "A" WHERE id = "14";

SELECT * FROM tb_estudantes;