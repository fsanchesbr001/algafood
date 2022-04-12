package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
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
		
		Cozinha cozinha = cozinhaRepository.buscar(restaurante.getCozinha().getId());
		if(cozinha==null) {
			throw new EntidadeNaoEncontradaException(String.format(
					"A cozinha de Id %d não esta cadastrada",restaurante.getCozinha().getId()));
		}
		return restauranteRepository.salvar(restaurante);
	}
	
	public void excluir(@RequestBody Long restauranteId) {
		try {
			restauranteRepository.remover(restauranteId);
		} catch(EmptyResultDataAccessException e){
			throw new EntidadeNaoEncontradaException(String.format(
					"O restaurante de id=%d, não está cadastrado", restauranteId)); 
		}
	}
}