package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.ProblemasIntegridadeException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		try {
			Optional<Cozinha> cozinha = cozinhaRepository.findById(restaurante.getCozinha().getId());
			if(cozinha.isEmpty()) {
				throw new EntidadeNaoEncontradaException(String.format(
						"A cozinha de Id %d não esta cadastrada",restaurante.getCozinha().getId()));
			}
			
			restaurante.setCozinha(cozinha.get());
			return restauranteRepository.save(restaurante);
		} catch(DataIntegrityViolationException e ) {
			throw new ProblemasIntegridadeException("Provavel Problema de Payload.");
		}
	}
	
	public void excluir(Long restauranteId) {
		try {
			restauranteRepository.deleteById(restauranteId);
		} catch(EmptyResultDataAccessException e){
			throw new EntidadeNaoEncontradaException(String.format(
					"O restaurante de id=%d, não está cadastrado", restauranteId)); 
		}
	}
}