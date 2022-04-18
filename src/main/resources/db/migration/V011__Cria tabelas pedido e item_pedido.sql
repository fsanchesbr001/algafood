CREATE TABLE algafood.pedido (
	id BIGINT auto_increment NOT NULL,
	subtotal DECIMAL(15,2) NOT NULL,
	taxa_frete DECIMAL(15,2) NOT NULL,
	valor_total DECIMAL(15,2) NOT NULL,
	data_criacao DATETIME NOT NULL,
	data_confirmacao DATETIME,
	data_cancelamento DATETIME,
	data_entrega DATETIME,
	status VARCHAR(10) NOT NULL,
	endereco_cep VARCHAR(10) NOT NULL,
	endereco_logradouro VARCHAR(100) NOT NULL,
	endereco_numero VARCHAR(10) NOT NULL,
	endereco_complemento VARCHAR(100),
	endereco_bairro VARCHAR(100) NOT NULL,
	cidade_id BIGINT not null,
	forma_pagamento_id BIGINT not null,
	restaurante_id BIGINT not null,
	usuario_id BIGINT not null,
	CONSTRAINT pedido_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela com os pedidos realizados';


CREATE TABLE algafood.item_pedido (
	id BIGINT auto_increment NOT NULL,
	quantidade INTEGER not null,
	preco_unitario DECIMAL(15,2) NOT NULL,
	preco_total DECIMAL(15,2) NOT NULL,
	observacao VARCHAR(150),
	pedido_id BIGINT not null,
	CONSTRAINT item_pedido_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela com os itens de pedidos realizados';