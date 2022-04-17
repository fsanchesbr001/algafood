ALTER TABLE algafood.restaurante ADD endereco_cep varchar(15) NOT NULL;

ALTER TABLE algafood.restaurante ADD endereco_logradouro varchar(100) NOT NULL;

ALTER TABLE algafood.restaurante ADD endereco_numero varchar(6) NOT NULL;

ALTER TABLE algafood.restaurante ADD endereco_complemento varchar(100);

ALTER TABLE algafood.restaurante ADD endereco_bairro varchar(100) NOT NULL;