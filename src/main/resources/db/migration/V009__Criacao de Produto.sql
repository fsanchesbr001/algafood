CREATE TABLE algafood.produto (
	id BIGINT auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
	descricao varchar(100) NOT NULL,
	preco DECIMAL(15,2) NOT NULL,
	ativo INT(1) NOT NULL,
	restaurante_id BIGINT NOT NULL,
	CONSTRAINT produto_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela de produtos vendidos no restaurante';

ALTER TABLE `produto`  ADD CONSTRAINT `fk_restaurante_prod` FOREIGN KEY ( `restaurante_id` ) REFERENCES `restaurante` ( `id` );