package com.generation.nintendo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.nintendo.model.Categorias;


public interface CategoriasRepository extends JpaRepository <Categorias, Long>{

	public List <Categorias> findAllBynomeContainingIgnoreCase (@Param("nome") String nome);
				
}
