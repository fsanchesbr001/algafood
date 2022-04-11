package com.algaworks.algafood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}