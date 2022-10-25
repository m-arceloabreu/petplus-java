package com.tcc.petPlusBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import com.tcc.petPlusBackEnd.model.Produto;
import com.tcc.petPlusBackEnd.repository.ProdutoRepository;

@Controller
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	@Autowired
	ProdutoRepository prodRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(prodRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Produto> Post(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(prodRepository.save(produto));
	}

}
