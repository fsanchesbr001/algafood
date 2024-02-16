package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public Cidade salvar(Cidade cidade) {
		Optional<Estado> estado = estadoRepository.findById(cidade.getEstado().getId());
		if(estado.isEmpty()) {
			throw new EntidadeNaoEncontradaException(String.format("O estado com o ID=%d não está cadastrado.",cidade.getEstado().getId()));
		}
		cidade.setEstado(estado.get());
		
		return cidadeRepository.save(cidade);
	}
	
	public void excluir(Long cidadeId) {
			cidadeRepository.deleteById(cidadeId);
	}
}
