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
@Table (name = "tb_Usuarios")
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank(message = "Por favor insira um nome para esse produto... :)")
	@Size (min = 2, max = 500, message = "Ops! O nome precisa ter um mínimo de 2 e um máximo de 500 caracteres :)")
	private String nome;
	
	@NotBlank(message = "Por favor insira um nome para esse produto... :)")
	@Size (min = 2, max = 500, message = "Ops! O e-mail precisa ter um mínimo de 2 e um máximo de 500 caracteres :)")
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="usuario", cascade = CascadeType.REMOVE )
	@JsonIgnoreProperties("usuario")
	private List<Produtos> produtos;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
	
}
