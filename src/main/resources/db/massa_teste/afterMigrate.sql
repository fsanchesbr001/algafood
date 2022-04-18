SET foreign_key_checks = 0;

DELETE FROM cozinha;
DELETE FROM estado;
DELETE FROM cidade;
DELETE FROM forma_pagamento;
DELETE FROM grupo;
DELETE FROM grupo_permissao;
DELETE FROM permissao;
DELETE FROM produto;
DELETE FROM restaurante;
DELETE FROM restaurante_forma_pagamento;

SET foreign_key_checks = 1;

ALTER TABLE cozinha auto_increment = 1;
ALTER TABLE estado auto_increment = 1;
ALTER TABLE cidade auto_increment = 1;
ALTER TABLE forma_pagamento auto_increment = 1;
ALTER TABLE grupo auto_increment = 1;
ALTER TABLE permissao auto_increment = 1;
ALTER TABLE produto auto_increment = 1;
ALTER TABLE restaurante auto_increment = 1;


INSERT INTO estado(id,nome) VALUES (1,"São Paulo");
INSERT INTO estado(id,nome) VALUES (2,"Goiás");

INSERT INTO cidade(id,nome,estado_id) VALUES (1,"São Paulo",1);
INSERT INTO cidade(id,nome,estado_id) VALUES (2,"São Carlos",1);
INSERT INTO cidade(id,nome,estado_id) VALUES (3,"Guarujá",1);
INSERT INTO cidade(id,nome,estado_id) VALUES (4,"Goiânia",2);
INSERT INTO cidade(id,nome,estado_id) VALUES (5,"Caldas Novas",2);
INSERT INTO cidade(id,nome,estado_id) VALUES (6,"Anápolis",2);

INSERT INTO cozinha (id,nome) VALUES (1,'Tailandesa');
INSERT INTO cozinha (id,nome) VALUES (2,'Indiana');
INSERT INTO cozinha (id,nome) VALUES (3,'Japonesa');
INSERT INTO cozinha (id,nome) VALUES (4,'Coreana');

INSERT INTO forma_pagamento(id,descricao) VALUES (1,"Cartão de Crédito");
INSERT INTO forma_pagamento(id,descricao) VALUES (2,"Cartão de Débito");
INSERT INTO forma_pagamento(id,descricao) VALUES (3,"Vale Refeição");

INSERT INTO permissao(id,nome,descricao) VALUES (1,"Consultar", "Permite apenas Consultas");
INSERT INTO permissao(id,nome,descricao) VALUES (2,"Gerenciar", "Permite Manipular Dados e Consultar");
INSERT INTO permissao(id,nome,descricao) VALUES (3,"Administrar", "Permite acesso a todas as funcionalidades");

INSERT INTO restaurante (data_cadastro,data_ultima_atualizacao, nome, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) 
VALUES(utc_timestamp,utc_timestamp, 'Restaurante 01', 2, 1,'13564-002','Avenida Francisco Pereira Lopes','115',null,'Parque Arnold Schimidt');

INSERT INTO restaurante (data_cadastro,data_ultima_atualizacao, nome, taxa_frete, cozinha_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) 
VALUES(utc_timestamp,utc_timestamp, 'Restaurante 02', 1, 2,'13564-030','Rua José Duarte de Sousa','372','apto 15','Jd. Santa Paula');

INSERT INTO restaurante (data_cadastro,data_ultima_atualizacao, nome, taxa_frete, cozinha_id, endereco_cep, 
endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) 
VALUES(utc_timestamp,utc_timestamp, 'Restaurante 03', 5, 3,'75690-000','Rua 15 de Novembro','22','Quadra 09 Lote 22','Bandeirante');

INSERT INTO restaurante (data_cadastro,data_ultima_atualizacao, nome, taxa_frete, cozinha_id, endereco_cep, 
endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) 
VALUES(utc_timestamp,utc_timestamp, 'Restaurante 04', 8, 4,'05625-160','Rua Professor Monjardino','131','apto 54','Vila Sonia');

INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES(1, 1);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES(1, 2);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES(1, 3);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES(2, 1);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES(2, 2);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES(3, 2);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES(3, 3);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES(4, 1);
INSERT INTO restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) VALUES(4, 3);

INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Refrigerante', 'Coca Cola', 5, 1);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Prato', 'Prato 01', 15, 1);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Sobremesa', 'Pudim', 8, 1);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Refrigerante', 'Guarana', 3.5, 2);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Prato', 'Prato 02', 18, 2);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Sobremesa', 'Gelatina', 3, 2);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Alcoólico', 'Cerveja', 7.98, 3);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Prato', 'Prato 03', 12, 3);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Sobremesa', 'Torta', 7, 3);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Água', 'Água Mineral', 4.5, 4);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Prato', 'Prato 04', 19, 4);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Sobremesa', 'Sorvete', 6, 4);