-- Crie um banco de dados para um serviço de um Games Online. O nome do Banco de dados deverá ter o seguinte nome db_generation_game_online. 
CREATE DATABASE db_generation_game_online;
USE db_generation_game_online;

-- Crie a tabela tb_classes e determine pelo menos 2 atributos, além da Chave Primária, relevantes para classificar os personagens do Game Online.
CREATE TABLE tb_classes(
	id BIGINT AUTO_INCREMENT,
    nome_classe VARCHAR (255),
	cor VARCHAR(255),
    
    PRIMARY KEY (id)
);


-- Crie a tabela tb_personagens e determine 4 atributos, além da Chave Primária, relevantes aos personagens do Game Online.
-- Não esqueça de criar a Foreign Key da tabela tb_classes na tabela tb_personagens.
CREATE TABLE tb_personagens(
	id BIGINT AUTO_INCREMENT,
	nome VARCHAR (255),
	nivel INT,
    tool VARCHAR (255),
    tipo_id BIGINT,
    
    FOREIGN KEY (tipo_id) REFERENCES tb_classes(id),
    PRIMARY KEY (id)
);

-- Insira 5 registros na tabela tb_classes.
 
INSERT INTO tb_classes(
	nome_classe,cor
    ) values ("mago","roxo");

INSERT INTO tb_classes(
	nome_classe,cor
    ) values ("anão","prata");
    
INSERT INTO tb_classes(
	nome_classe,cor
    ) values ("elfo","verde");

INSERT INTO tb_classes(
	nome_classe,cor
    ) values ("humano","marrom");
    
INSERT INTO tb_classes(
	nome_classe,cor
    ) values ("hobbit","marrom");
 



-- Insira 8 registros na tabela tb_personagens, preenchendo a Chave Estrangeira para criar a relação com a tabela tb_classes.
INSERT INTO tb_personagens(
	nome,nivel, tool, tipo_id
    ) values ("Bilbo",2,null,5);

INSERT INTO tb_personagens(
	nome,nivel, tool, tipo_id
    ) values ("Aragorna",4,"espada",4);
    
INSERT INTO tb_personagens(
	nome,nivel, tool, tipo_id
    ) values ("Galadriel",5,"arco e flecha",3);
    
INSERT INTO tb_personagens(
	nome,nivel, tool, tipo_id
    ) values ("Gimli",4,"machado",2);

INSERT INTO tb_personagens(
	nome,nivel, tool, tipo_id
    ) values ("Thorin",4,"machado",2);
    
INSERT INTO tb_personagens(
	nome,nivel, tool, tipo_id
    ) values ("Legolas",4,"arco e flecha",3);
    
INSERT INTO tb_personagens(
	nome,nivel, tool, tipo_id
    ) values ("Frodo",2,"evil_ring",5);
    
INSERT INTO tb_personagens(
	nome,nivel, tool, tipo_id
    ) values ("Arwen",2,null,3);

-- Faça um SELECT que retorne todes os personagens cujo poder de nivel seja maior do que 2.
SELECT * FROM tb_personagens WHERE nivel > 2;

-- Faça um SELECT que retorne todes os personagens cujo poder de defesa esteja no intervalo 1000 e 2000.
SELECT * FROM tb_personagens WHERE nivel BETWEEN 1 AND 2;

-- Faça um SELECT utilizando o operador LIKE, buscando todes os personagens que possuam a letra C no atributo nome.
SELECT *	FROM tb_personagens WHERE nome LIKE "%e%";

-- Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_personagens com os dados da tabela tb_classes.
SELECT * 
FROM tb_personagens a
INNER JOIN tb_classes b
ON a.tipo_id = b.id;

-- Faça um SELECT utilizando a cláusula INNER JOIN, unindo os dados da tabela tb_personagens com os dados da tabela tb_classes, onde traga apenas os personagens que pertençam a uma classe específica (Exemplo: Todes os personagens da classe dos arqueiros).
SELECT *
FROM tb_personagens a 
INNER JOIN tb_classes b
ON a.tipo_id = b.id WHERE nome_classe = 'elfo';


