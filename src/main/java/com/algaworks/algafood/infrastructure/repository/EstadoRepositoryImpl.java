package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository{

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	@Override
	public Estado salvar(Estado estado) {
		return manager.merge(estado);
	}

	@Override
	public List<Estado> listar() {
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}

	@Override
	public Estado buscarPorId(Long id) {
		Estado estado = manager.find(Estado.class, id);
		if(estado==null) {
			throw new EntidadeNaoEncontradaException(String.format("O estado com Id=%d não está cadastrado", id));
		}
		return estado;
	}
	
	@Transactional
	@Override
	public void remover(Long id) {
		Estado estado=buscarPorId(id);
		if(estado==null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(estado);
		
	}

}
