package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {
	
	@Autowired
	CozinhaRepository cozinhaRepository;
	
	@Autowired 
	CozinhaService cozinhaService;
	
	@GetMapping
	public List<Cozinha> listar(){
		return cozinhaRepository.listar();
	}

	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId){
		Cozinha cozinha =  cozinhaRepository.buscar(cozinhaId);
		
		if(cozinha!=null) {
			return ResponseEntity.ok(cozinha);
		}
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cozinha salvar(@RequestBody Cozinha cozinha) {
		return cozinhaService.salvar(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinhaInformada){
		Cozinha cozinhaAtual =  cozinhaRepository.buscar(cozinhaId);
		
		if(cozinhaAtual!=null) {
			BeanUtils.copyProperties(cozinhaInformada, cozinhaAtual,"id");
			cozinhaRepository.salvar(cozinhaAtual);
			return ResponseEntity.ok(cozinhaAtual);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
		try {
				cozinhaService.excluir(cozinhaId);
				return ResponseEntity.ok().build();
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
