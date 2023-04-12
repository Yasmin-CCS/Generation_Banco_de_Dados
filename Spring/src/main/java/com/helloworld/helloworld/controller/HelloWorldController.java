package com.helloworld.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {

	@GetMapping
	public String helloworld() {
		return "Hello World!!!";
	}
	
	@GetMapping ("/listaBSM")
	public String listaBSM() {
		return "Lista Habilidades Comportamentais e Mentalidades\r\n"
			+ "Responsabilidade Pessoal\r\n"
			+ "Mentalidade de Crescimento\r\n"	
			+ "Persistência\r\n"
			+ "Orientação ao Futuro\r\n"
			+ "Comunicação\r\n"
			+ "Proatividade\r\n";
	}
	
	@GetMapping ("/listaobjetivos")
	public String listaobjetivo() {
		return "Lista de Objetivos\r\n"
			+ "Responsabilidade Pessoal\r\n"
			+ "Mentalidade de Crescimento\r\n"	
			+ "Persistência\r\n";
	
		}
		
	
}
