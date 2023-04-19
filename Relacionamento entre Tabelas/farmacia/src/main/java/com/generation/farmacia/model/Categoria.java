package com.generation.farmacia.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_categoria")
public class Categoria {

//Creating Attributes and their important behaviors:

	@Id
//It generates the Id number in sequence by it self. It's = to AUTO INCREMENT in MySQL
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//Method to create the attribute(column) Id
	private Long Id;
		
//Shows a message if the user don't fill the field
	@NotBlank(message = "Por favor, insita um nome para a categoria :)")
/*Establishes size rules for the data inserted
Shows a message the name inserted by the user isn't according to the rules established*/
	@Size (min = 3, max = 200, message = "Por favor insira um nome com no mínimo 3 e no máximo 200 caracteres")
//Method to create the attribute(column) name
	private String nome;
	
/*Method to relate the two tables
One Category to Many Products*/
	@OneToMany(fetch = FetchType.LAZY, mappedBy="categoria", cascade = CascadeType.REMOVE )
	@JsonIgnoreProperties("tema")
	private List<Produtos> produtos;


//Methods GET and SET for each attribute
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

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
	
			
}
