package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;

public interface CidadeRepository {
	
	Cidade salvar(Cidade cidade);
	List<Cidade> listar();
	Cidade buscarPorId(Long id);
	void remover(Cidade cidade);


}
