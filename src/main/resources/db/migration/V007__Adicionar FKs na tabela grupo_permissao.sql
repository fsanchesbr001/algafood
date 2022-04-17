ALTER TABLE `grupo_permissao`  ADD CONSTRAINT `fk_grupo` FOREIGN KEY ( `grupo_id` ) REFERENCES `grupo` ( `id` );

ALTER TABLE `grupo_permissao`  ADD CONSTRAINT `fk_permissao` FOREIGN KEY ( `permissao_id` ) REFERENCES `permissao` ( `id` );