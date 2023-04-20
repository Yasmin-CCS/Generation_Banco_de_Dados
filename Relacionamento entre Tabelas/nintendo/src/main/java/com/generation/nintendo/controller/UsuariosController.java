package com.generation.nintendo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.nintendo.model.Usuarios;
import com.generation.nintendo.repository.UsuariosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping ("/usuarios")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class UsuariosController {
	

	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@GetMapping
	public ResponseEntity<List<Usuarios>> getAll(){
		return ResponseEntity.ok(usuariosRepository.findAll());
	}
	
	@GetMapping ("nome/{nome}")
	public ResponseEntity<List<Usuarios>> getByNome (@PathVariable String nome){
		return ResponseEntity.ok(usuariosRepository.findAllBynomeContainingIgnoreCase(nome));
	}
	
	@GetMapping ("/{Id}")
	public ResponseEntity<Usuarios> getById (@PathVariable Long Id){
		return usuariosRepository.findById(Id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<Usuarios> post(@Valid @RequestBody Usuarios usuarios) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuariosRepository.save(usuarios));
	}
	
	@PutMapping
	public ResponseEntity<Usuarios> put(@Valid @RequestBody Usuarios usuarios) {
		
		return usuariosRepository.findById(usuarios.getId())
				
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(usuariosRepository.save(usuarios)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	 @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        Optional <Usuarios> tema = usuariosRepository.findById(id);
	        
	        if(tema.isEmpty())
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        
	        usuariosRepository.deleteById(id);              
	    }
	

}
