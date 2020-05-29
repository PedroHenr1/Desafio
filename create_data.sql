CREATE TABLE categoria
(
	id_categoria INTEGER AUTO_INCREMENT,
	CATEGORIA VARCHAR(255),
	PRIMARY KEY(id_categoria)
);

CREATE TABLE produto
(
	id_produto INTEGER AUTO_INCREMENT,
	descricao VARCHAR(255),
	id_cat INTEGER,
	PRIMARY KEY(id_produto),
	CONSTRAINT cat_prod_fk FOREIGN KEY (id_cat) REFERENCES categoria(id_categoria) ON DELETE CASCADE
);

INSERT INTO CATEGORIA VALUES (1, 'Categoria 1');

INSERT INTO PRODUTO (descricao,id_cat) VALUES ('produto 1', 1);