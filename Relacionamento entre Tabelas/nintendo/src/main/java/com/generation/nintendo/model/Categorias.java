package com.generation.nintendo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "tb_Categorias")
public class Categorias {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotBlank(message = "Por favor insira um nome para essa categoria... :)")
	@Size (min = 2, max = 200, message = "Ops! O nome precisa ter um mínimo de 2 e um máximo de 200 caracteres :)")
	private String nome;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="categoria", cascade = CascadeType.REMOVE )
	@JsonIgnoreProperties("categoria")
	private List<Produtos> produtos;
	
	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
