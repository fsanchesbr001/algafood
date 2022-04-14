package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@Override
	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);
	}

	@Override
	public List<Cidade> listar() {
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}

	@Override
	public Cidade buscarPorId(Long id) {
		Cidade cidade = manager.find(Cidade.class, id);
		if(cidade == null) {
			throw new EntidadeNaoEncontradaException(String.format("A cidade com Id=%d, não está cadastrada", id));
		}
		return cidade;
	}
	
	@Transactional
	@Override
	public void remover(Long cidadeId) {
		Cidade cidade = buscarPorId(cidadeId);
		if(cidade==null) {
			throw new EntidadeNaoEncontradaException(String.format("A cidade de Id=%d não está cadastrada.", cidadeId));
		}
		manager.remove(cidade);
	}

}
