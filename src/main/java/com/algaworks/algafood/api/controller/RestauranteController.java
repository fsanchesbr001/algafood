package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.ProblemasIntegridadeException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.RestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private RestauranteService restauranteService;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping
	public List<Restaurante> listar(){
		return restauranteRepository.findAll();
	}
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscarPorId(@PathVariable Long restauranteId) {
		Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);
		
		if(restaurante.isPresent()) {
			return ResponseEntity.ok(restaurante.get());
		}
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante){
		try {
			Restaurante restauranteCriado = restauranteService.salvar(restaurante);
			return ResponseEntity.status(HttpStatus.CREATED).body(restauranteCriado);
		} catch(EntidadeNaoEncontradaException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		} catch(ProblemasIntegridadeException e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@DeleteMapping("/{restauranteId}")
	public ResponseEntity<?> remover(@PathVariable Long restauranteId){
		try {
			restauranteService.excluir(restauranteId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch(EntidadeNaoEncontradaException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restauranteInformado){
		Optional<Restaurante> restaurante =  restauranteRepository.findById(restauranteId);
		if(restaurante.isPresent()) {
			Optional<Cozinha> cozinhaInformada=cozinhaRepository.findById(restauranteInformado.getCozinha().getId());
			if(cozinhaInformada.isPresent()) {
				BeanUtils.copyProperties(restauranteInformado, restaurante.get(),
						"id","endereco","formasPagamento","dataCadastro","produtos");
				restauranteRepository.save(restaurante.get());
				return ResponseEntity.ok(restaurante.get());
			}
			else {
				return ResponseEntity.badRequest().body(String.format(
						"A cozinha de Id=%d não esta cadastrada", restauranteInformado.getCozinha().getId()));
			}
		}
		return ResponseEntity.notFound().build();
	}
}
