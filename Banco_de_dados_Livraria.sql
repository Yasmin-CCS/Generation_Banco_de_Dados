CREATE DATABASE db_ecommerce;
USE db_ecommerce;

CREATE TABLE tb_produtos(
	id BIGINT AUTO_INCREMENT,
		nome VARCHAR (255),
		preco DECIMAL (6,2),
		categoria VARCHAR (255),
		cor VARCHAR (255),
		tamanho VARCHAR (255),
    PRIMARY KEY(id)
);

SELECT * FROM tb_produtos;

INSERT INTO tb_produtos (nome, preco, categoria, cor, tamanho)
	values("Don't Panic", 51.00, "ficcao cientifica", "azul", "normal");
INSERT INTO tb_produtos (nome, preco, categoria, cor, tamanho)
	values("Restaurante no Fim do Universo", 52.00, "ficcao cientifica", "azul", "pocket");
INSERT INTO tb_produtos (nome, preco, categoria, cor, tamanho)
	values("A Vida, o Universo e tudo o mais", 53.00, "ficcao cientifica", "preto", "Ilustrado");
INSERT INTO tb_produtos (nome, preco, categoria, cor, tamanho)
	values("Até mais e obrigado pelos peixes!!", 54.00, "ficcao cientifica", "prateado", "normal");
INSERT INTO tb_produtos (nome, preco, categoria, cor, tamanho)
	values("Praticamente Inofensiva", 55.00, "ficcao cientifica", "azul", "pocket");
INSERT INTO tb_produtos (nome, preco, categoria, cor, tamanho)
	values("A Sociedade do Anel", 51.00, "fantasia", "verde", "normal");
INSERT INTO tb_produtos (nome, preco, categoria, cor, tamanho)
	values("Duas Torres", 52.00, "fantasia", "azul", "pocket");
INSERT INTO tb_produtos (nome, preco, categoria, cor, tamanho)
	values("O Retorno do Rei", 53.00, "fantasia", "vermelho", "pocket");


SELECT * FROM tb_produtos;

SELECT * FROM tb_produtos WHERE preco > 500;

SELECT * FROM tb_produtos WHERE preco < 500;

UPDATE tb_produtos SET tamanho = "normal" WHERE id = 8;

SELECT nome, tamanho FROM tb_produtos WHERE id = 8;

