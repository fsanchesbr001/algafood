package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired 
	private EstadoRepository estadoRepository;
	
	@GetMapping
	public List<Cidade> listar(){
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/{cidadeId}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long cidadeId){
		try {
			Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
			return ResponseEntity.ok().body(cidade.get());
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Cidade cidadeInformada) {
		try {
			Cidade cidade = cidadeService.salvar(cidadeInformada);
			return ResponseEntity.status(HttpStatus.CREATED).body(cidade);
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{cidadeId}")
	public ResponseEntity<?> excluir(@PathVariable Long cidadeId){
		try {
			cidadeService.excluir(cidadeId);
			return ResponseEntity.noContent().build();
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping("/{cidadeId}")
	public ResponseEntity<?> alterar(@PathVariable Long cidadeId,@RequestBody Cidade cidadeInformada){
		try {
			Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);
			Optional<Estado> estado=estadoRepository.findById(cidadeInformada.getEstado().getId());
			BeanUtils.copyProperties(cidadeInformada, cidadeAtual.get(),"id");
			Cidade cidade = cidadeService.salvar(cidadeAtual.get());
			return ResponseEntity.ok(cidade);
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}