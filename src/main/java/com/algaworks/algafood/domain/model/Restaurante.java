package com.algaworks.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(name = "taxa_frete")
	private BigDecimal taxaFrete;
	
	//@JsonIgnore
	@ManyToOne
	private Cozinha cozinha;
	
//	@JsonIgnore
//	@Embedded
//	private Endereco endereco;
	
	@ManyToMany
	@JoinTable(name = "restaurante_forma_pagamento",
			   joinColumns = @JoinColumn(name="restaurante_id"),
			   inverseJoinColumns = @JoinColumn(name="forma_pagamento_id"))
	//@JsonIgnore
	private List<FormaPagamento> formasPagamento = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurante")
	private List<Produto> produtos = new ArrayList<>();
	
	@CreationTimestamp
	@Column(nullable = false,columnDefinition = "datetime")
	//@JsonIgnore
	private LocalDateTime dataCadastro;
	
	@UpdateTimestamp
	@Column(nullable = false,columnDefinition = "datetime")
	//@JsonIgnore
	private LocalDateTime dataUltimaAtualizacao;
	
	
}
