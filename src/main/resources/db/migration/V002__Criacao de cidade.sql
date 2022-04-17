CREATE TABLE algafood.cidade (
	id BIGINT auto_increment NOT NULL,
	cidade_nome varchar(100) NOT null,
	estado_nome varchar(100) NOT null,
	primary key (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COMMENT='Tabela de Cidades';