package com.tcc.petPlusBackEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcc.petPlusBackEnd.model.Servico;
import com.tcc.petPlusBackEnd.repository.ServicoRepository;

@Controller
@RequestMapping("/servico")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServicoController {
	@Autowired
	ServicoRepository servicoRepository;
	
	@GetMapping
	public ResponseEntity<List<Servico>> getAll(){
		return ResponseEntity.ok(servicoRepository.findAll());
	}

}
