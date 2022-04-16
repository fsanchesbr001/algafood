insert into cozinha (id,nome) values (1,'Tailandesa');
insert into cozinha (id,nome) values (2,'Indiana');
insert into cozinha (id,nome) values (3,'Japonesa');
insert into cozinha (id,nome) values (4,'Coreana');

INSERT INTO estado(id,nome) VALUES (1,"Sao Paulo");
INSERT INTO estado(id,nome) VALUES (2,"Goias");

INSERT INTO cidade(id,nome,estado_id) VALUES (1,"Sao Paulo",1);
INSERT INTO cidade(id,nome,estado_id) VALUES (2,"Sao Carlos",1);
INSERT INTO cidade(id,nome,estado_id) VALUES (3,"Guaruja",1);
INSERT INTO cidade(id,nome,estado_id) VALUES (4,"Goiania",2);
INSERT INTO cidade(id,nome,estado_id) VALUES (5,"Caldas Novas",2);
INSERT INTO cidade(id,nome,estado_id) VALUES (6,"Anapolis",2);

INSERT INTO forma_pagamento(id,descricao) VALUES (1,"Cartao de Credito");
INSERT INTO forma_pagamento(id,descricao) VALUES (2,"Cartao de Debito");
INSERT INTO forma_pagamento(id,descricao) VALUES (3,"Vale Refeicao");

INSERT INTO permissao(id,nome,descricao) VALUES (1,"Consultar", "Permite apenas Consultas");
INSERT INTO permissao(id,nome,descricao) VALUES (2,"Gerenciar", "Permite Manipular Dados e Consultar");
INSERT INTO permissao(id,nome,descricao) VALUES (3,"Administrar", "Permite acesso a todas as funcionalidades");

INSERT INTO restaurante (data_cadastro,data_ultima_atualizacao,endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES(utc_timestamp,utc_timestamp,'Jd Sta Paula', '13564-030', 'Apto 15', 'Rua Jose Duarte de Sousa', '372', 'Restaurante 01', 2, 1, 2);
INSERT INTO restaurante (data_cadastro,data_ultima_atualizacao,endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES(utc_timestamp,utc_timestamp,'Jd Sta Paula', '13564-030', 'Apto 15', 'Rua Jose Duarte de Sousa', '375', 'Restaurante 02', 1, 2, 2);
INSERT INTO restaurante (data_cadastro,data_ultima_atualizacao,endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES(utc_timestamp,utc_timestamp,'Jd Sta Paula', '13564-030', 'Apto 15', 'Rua Jose Duarte de Sousa', '400', 'Restaurante 03', 5, 3, 2);
INSERT INTO restaurante (data_cadastro,data_ultima_atualizacao,endereco_bairro, endereco_cep, endereco_complemento, endereco_logradouro, endereco_numero, nome, taxa_frete, cozinha_id, endereco_cidade_id) VALUES(utc_timestamp,utc_timestamp,'Jd Sta Paula', '13564-030', 'Apto 15', 'Rua Jose Duarte de Sousa', '550', 'Restaurante 04', 8, 4, 2);

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
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Alcoolico', 'Cerveja', 7.98, 3);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Prato', 'Prato 03', 12, 3);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Sobremesa', 'Torta', 7, 3);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Agua', 'Agua Mineral', 4.5, 4);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Prato', 'Prato 04', 19, 4);
INSERT INTO produto (ativo, descricao, nome, preco, restaurante_id) VALUES(1, 'Sobremesa', 'Sorvete', 6, 4);