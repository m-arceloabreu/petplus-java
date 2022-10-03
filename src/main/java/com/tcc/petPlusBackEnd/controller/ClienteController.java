package com.tcc.petPlusBackEnd.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcc.petPlusBackEnd.model.Cliente;
import com.tcc.petPlusBackEnd.model.ClienteLogin;
import com.tcc.petPlusBackEnd.service.ClienteService;
import com.tcc.petPlusBackEnd.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {
	
	@Autowired
	private ClienteService usuarioService;
	
	@PostMapping("/logar")
	public ResponseEntity<ClienteLogin> Autentication(@RequestBody Optional<ClienteLogin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Cliente> Post(@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.cadastrarCliente(cliente));
		
	}
	
	
}
