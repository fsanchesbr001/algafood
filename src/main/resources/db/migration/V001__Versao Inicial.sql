CREATE TABLE algafood.cozinha (
	id BIGINT auto_increment NOT NULL,
	nome varchar(100) NOT null,
	primary key (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COMMENT='Tabela de Cozinhas';