CREATE TABLE algafood.forma_pagamento (
	id BIGINT auto_increment NOT NULL,
	descricao varchar(100) NOT NULL,
	CONSTRAINT forma_pagamento_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela das formas de pagamento aceitas';

CREATE TABLE algafood.restaurante (
	id BIGINT auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
	taxa_frete DECIMAL(15,2) NOT NULL,
	cozinha_id BIGINT NOT NULL,
	data_cadastro DATETIME NOT NULL,
	data_ultima_atualizacao DATETIME NOT null,
	CONSTRAINT restaurante_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela de restaurante';

CREATE TABLE algafood.restaurante_forma_pagamento (
	restaurante_id BIGINT NOT NULL,
	forma_pagamento_id BIGINT NOT NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela MTM restaurante e forma pagamento';

ALTER TABLE `restaurante`  ADD CONSTRAINT `fk_cozinha` FOREIGN KEY ( `cozinha_id` ) REFERENCES `cozinha` ( `id` );

ALTER TABLE `restaurante_forma_pagamento`  ADD CONSTRAINT `fk_restaurante_fp` FOREIGN KEY ( `restaurante_id` ) REFERENCES `restaurante` ( `id` );

ALTER TABLE `restaurante_forma_pagamento`  ADD CONSTRAINT `fk_forma_pagamento_fp` FOREIGN KEY ( `forma_pagamento_id` ) REFERENCES `forma_pagamento` ( `id` );