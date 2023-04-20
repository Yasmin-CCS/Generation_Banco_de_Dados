package com.generation.nintendo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.nintendo.model.Usuarios;

public interface UsuariosRepository extends JpaRepository <Usuarios, Long>{

	public List <Usuarios> findAllBynomeContainingIgnoreCase (@Param("nome") String nome);
}
