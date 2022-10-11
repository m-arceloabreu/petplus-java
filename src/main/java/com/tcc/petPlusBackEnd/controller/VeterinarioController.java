package com.tcc.petPlusBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcc.petPlusBackEnd.model.Veterinario;
import com.tcc.petPlusBackEnd.repository.VeterinarioRepository;

@Controller
@RequestMapping("/veterinario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VeterinarioController {
	@Autowired
	VeterinarioRepository vetRepository;
	
	@GetMapping
	public ResponseEntity<List<Veterinario>> getAll(){
		return ResponseEntity.ok(vetRepository.findAll());
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<List<Veterinario>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(vetRepository.findByNome(nome));
	}

}
