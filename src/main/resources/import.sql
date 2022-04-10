insert into cozinha (id,nome) values (1,'Tailandesa');
insert into cozinha (id,nome) values (2,'Indiana');
insert into cozinha (id,nome) values (3,'Japonesa');
insert into cozinha (id,nome) values (4,'Coreana');

insert into restaurante (nome, taxa_frete,cozinha_id) values ('Thai Gourmet', 10,1);
insert into restaurante (nome, taxa_frete,cozinha_id) values ('Thai Delivery', 9.50,1);
insert into restaurante (nome, taxa_frete,cozinha_id) values ('Tuk Tuk Comida Indiana', 15,2);

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