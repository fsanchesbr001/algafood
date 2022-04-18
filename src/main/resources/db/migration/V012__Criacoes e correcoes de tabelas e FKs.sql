CREATE TABLE algafood.usuario (
	id BIGINT auto_increment NOT NULL,
	nome VARCHAR(100) not null,
	senha VARCHAR(20) NOT NULL,
	email VARCHAR(150) NOT NULL,
	data_cadastro DATETIME not NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela com os usuarios do sistema';

CREATE TABLE algafood.usuario_grupo (
	id BIGINT auto_increment NOT NULL,
	usuario_id BIGINT NOT NULL,
	grupo_id BIGINT NOT null,
	CONSTRAINT usuario_grupo_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela MTM usuario_grupo';

ALTER TABLE algafood.usuario_grupo ADD CONSTRAINT usuario_grupo_FK FOREIGN KEY (usuario_id) REFERENCES algafood.usuario(id);

ALTER TABLE algafood.usuario_grupo ADD CONSTRAINT usuario_grupo_FK1 FOREIGN KEY (grupo_id) REFERENCES algafood.grupo(id);

drop table algafood.grupo_permissao; 

CREATE TABLE algafood.grupo_permissao (
	id BIGINT auto_increment NOT NULL,
	grupo_id BIGINT NOT null,
	permissao_id BIGINT NOT NULL,
	CONSTRAINT grupo_permissao_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela MTM grupo_permissao';

ALTER TABLE algafood.grupo_permissao ADD CONSTRAINT grupo_permissao_FK FOREIGN KEY (grupo_id) REFERENCES algafood.grupo(id);

ALTER TABLE algafood.grupo_permissao ADD CONSTRAINT grupo_permissao_FK1 FOREIGN KEY (permissao_id) REFERENCES algafood.permissao(id);

drop table algafood.restaurante_forma_pagamento; 

CREATE TABLE algafood.restaurante_forma_pagamento (
	id BIGINT auto_increment NOT NULL,
	restaurante_id BIGINT NOT null,
	forma_pagamento_id BIGINT NOT NULL,
	CONSTRAINT restaurante_forma_pagamento_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela MTM restaurante_forma_pagamento';

ALTER TABLE algafood.restaurante_forma_pagamento ADD CONSTRAINT restaurante_forma_pagamento_FK FOREIGN KEY (restaurante_id) REFERENCES algafood.restaurante(id);

ALTER TABLE algafood.restaurante_forma_pagamento ADD CONSTRAINT restaurante_forma_pagamento_FK1 FOREIGN KEY (forma_pagamento_id) REFERENCES algafood.forma_pagamento(id);

ALTER TABLE algafood.pedido ADD CONSTRAINT pedido_FK FOREIGN KEY (usuario_id) REFERENCES algafood.usuario(id);

ALTER TABLE algafood.pedido ADD CONSTRAINT pedido_FK1 FOREIGN KEY (cidade_id) REFERENCES algafood.cidade(id);

ALTER TABLE algafood.pedido ADD CONSTRAINT pedido_FK2 FOREIGN KEY (forma_pagamento_id) REFERENCES algafood.forma_pagamento(id);

ALTER TABLE algafood.pedido ADD CONSTRAINT pedido_FK3 FOREIGN KEY (restaurante_id) REFERENCES algafood.restaurante(id);

ALTER TABLE algafood.item_pedido ADD CONSTRAINT item_pedido_FK FOREIGN KEY (pedido_id) REFERENCES algafood.pedido(id);