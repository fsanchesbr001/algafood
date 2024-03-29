package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.EstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public List<Estado> listar(){
		return estadoRepository.findAll();
	}
	
	@GetMapping("/{estadoId}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long estadoId){
		Optional<Estado> estado = estadoRepository.findById(estadoId);
		if(estado.isPresent()) {
			return ResponseEntity.ok(estado);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format(
				"O estado de Id=%d não está cadastrado", estadoId));
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Estado salvar(@RequestBody Estado estado) {
		return estadoService.salvar(estado);
	}
	
	@DeleteMapping("/{estadoId}")
	public ResponseEntity<Estado> remover(@PathVariable Long estadoId){
		try {
				estadoService.excluir(estadoId);
				return ResponseEntity.ok().build();
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		}
		catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PutMapping("/{estadoId}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId, @RequestBody Estado estadoInformado){
		Optional<Estado> estadoAtual =  estadoRepository.findById(estadoId);
		
		if(estadoAtual.isPresent()) {
			BeanUtils.copyProperties(estadoInformado, estadoAtual.get(),"id");
			estadoRepository.save(estadoAtual.get());
			return ResponseEntity.ok(estadoAtual.get());
		}
		return ResponseEntity.notFound().build();
	}
}
