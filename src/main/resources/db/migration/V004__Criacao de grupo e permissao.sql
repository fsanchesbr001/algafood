CREATE TABLE algafood.grupo (
	id BIGINT auto_increment NOT NULL,
	nome varchar(80) NOT NULL,
	CONSTRAINT grupo_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela de grupos de usuarios';

CREATE TABLE algafood.permissao (
	id BIGINT auto_increment NOT NULL,
	nome varchar(100) NOT NULL,
	descricao varchar(100) NOT NULL,
	CONSTRAINT permissao_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela de permissao para grupo de usuario';

CREATE TABLE algafood.grupo_permissao (
	grupo_id BIGINT NOT NULL,
	permissao_id BIGINT NOT NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela MTM';

