package com.generation.farmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/*Create and name the table*/
@Entity
@Table (name = "tb_produtos")
public class Produtos {
	
//Creating Attributes and their important behaviors:

	@Id
//It generates the Id number in sequence by it self. It's = to AUTO INCREMENT in MySQL
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//Method to create the attribute(column) Id
	private Long Id;
	
//Shows a message if the user don't fill the field
	@NotBlank(message = "Por favor, insita um nome para o produto :)")
/*Establishes size rules for the data inserted
Shows a message the name inserted by the user isn't according to the rules established*/
	@Size (min = 3, max = 200, message = "Por favor insira um nome com no mínimo 3 e no máximo 200 caracteres")
//Method to create the attribute(column) name
	private String nome;

/*Method to relate the two tables
Many Products to One Category*/
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;
		
//Method to create the attribute(column) company
	private String marca;
	

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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
}
