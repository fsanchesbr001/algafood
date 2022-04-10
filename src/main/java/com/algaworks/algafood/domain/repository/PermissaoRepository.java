package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Permissao;

public interface PermissaoRepository {
	
	Permissao salvar(Permissao permissao);
	List<Permissao> listar();
	Permissao buscarPorId(Long id);
	void remover(Permissao permissao);


}
