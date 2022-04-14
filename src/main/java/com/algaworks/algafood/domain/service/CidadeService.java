package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		Estado estado = estadoRepository.buscarPorId(cidade.getEstado().getId());
		if(estado==null) {
			throw new EntidadeNaoEncontradaException(String.format("O estado com o ID=%d não está cadastrado.",cidade.getEstado().getId()));
		}
		return cidadeRepository.salvar(cidade);
	}
	
	public void excluir(Long cidadeId) {
			cidadeRepository.remover(cidadeId);
	}
}
