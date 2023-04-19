package com.generation.farmacia.controller;

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

import com.generation.farmacia.model.Produtos;
import com.generation.farmacia.repository.ProdutosRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/produtos")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ProdutosController {

	@Autowired
	private ProdutosRepository produtosRepository;
	
//GET Methods
	
// -Search by Id
	@GetMapping ("/{id}")
	public ResponseEntity<Produtos> getById(@PathVariable Long id) {
		return produtosRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
// -Search by name
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produtos>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtosRepository.findAllBynomeContainingIgnoreCase(nome));
	}
	

// -Search by company
	@GetMapping("/marca/{marca}")
	public ResponseEntity<List<Produtos>> getByMarca(@PathVariable String marca){
		return ResponseEntity.ok(produtosRepository.findAllBynomeContainingIgnoreCase(marca));
	}
	
//POST Method
	@PostMapping
	public ResponseEntity<Produtos> post(@Valid @RequestBody Produtos produtos) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(produtosRepository.save(produtos));
	}
	
//PUT Method
	@PutMapping
	public ResponseEntity<Produtos> put(@Valid @RequestBody Produtos produtos) {
		return produtosRepository.findById(produtos.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(produtosRepository.save(produtos)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

//DELETE Method **** porque as formas de puxar por ID e deletar por ID são =s?
	@ResponseStatus(HttpStatus.NO_CONTENT)
	 @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        Optional <Produtos> tema = produtosRepository.findById(id);
	        
	        if(tema.isEmpty())
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	        
	        produtosRepository.deleteById(id);              
	    }
	
}
