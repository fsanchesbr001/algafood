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
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CidadeService;

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
		return cidadeRepository.listar();
	}
	
	@GetMapping("/{cidadeId}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long cidadeId){
		try {
			Cidade cidade = cidadeRepository.buscarPorId(cidadeId);
			return ResponseEntity.ok().body(cidade);
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
			Cidade cidadeAtual = cidadeRepository.buscarPorId(cidadeId);
			estadoRepository.buscarPorId(cidadeInformada.getEstado().getId());
			BeanUtils.copyProperties(cidadeInformada, cidadeAtual,"id");
			cidadeAtual= cidadeService.salvar(cidadeAtual);
			return ResponseEntity.ok(cidadeAtual);
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}