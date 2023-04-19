package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.farmacia.model.Produtos;

public interface ProdutosRepository extends JpaRepository <Produtos, Long>{
	
	public List <Produtos> findAllBynomeContainingIgnoreCase(@Param("nome") String nome);
	


}
