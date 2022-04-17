CREATE TABLE algafood.estado (
	id BIGINT auto_increment NOT NULL,
	nome varchar(100) NOT null,
	primary key(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci
COMMENT='Tabela de Estados da Federacao';

ALTER TABLE algafood.cidade CHANGE cidade_nome nome varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL;
ALTER TABLE algafood.cidade ADD estado_id BIGINT NOT NULL;
ALTER TABLE algafood.cidade DROP COLUMN estado_nome;
ALTER TABLE algafood.cidade ADD CONSTRAINT cidade_FK FOREIGN KEY (id) REFERENCES algafood.estado(id);