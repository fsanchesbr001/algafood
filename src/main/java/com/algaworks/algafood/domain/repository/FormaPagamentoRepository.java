package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {
	FormaPagamento salvar(FormaPagamento formaPagamento);
	List<FormaPagamento> listar();
	FormaPagamento buscarPorId(Long id);
	void remover(FormaPagamento formaPagamento);

}
