package com.tcc.petPlusBackEnd.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tcc.petPlusBackEnd.model.Veterinario;
import com.tcc.petPlusBackEnd.model.VeterinarioLogin;
import com.tcc.petPlusBackEnd.repository.VeterinarioRepository;

@Service
public class VeterinarioService {
	@Autowired
	private VeterinarioRepository vetRepository;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public Veterinario cadastrarVeterinario(Veterinario veterinario) {
		String senhaEncoder = encoder.encode(veterinario.getSenha());
		veterinario.setSenha(senhaEncoder);
		return vetRepository.save(veterinario);
	}
	
	public Optional<VeterinarioLogin> Logar(Optional<VeterinarioLogin> user) {

		Optional<Veterinario> usuario = vetRepository.findByEmail(user.get().getEmail());

		if (usuario.isPresent()) {
			if (compararSenhas(user.get().getSenha(), usuario.get().getSenha())) {
				user.get().setToken(generatorBasicToken(user.get().getEmail(), user.get().getSenha()));
				user.get().setNome(usuario.get().getNome());
				user.get().setEmail(usuario.get().getEmail());
				user.get().setImagem(usuario.get().getImagem());
				user.get().setIdVeterinario(usuario.get().getIdVeterinario());
				user.get().setSenha(usuario.get().getSenha());

				return user;
			}
		}
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos.", null);
	}
	
	public Optional<Veterinario> atualizarVeterinario(Veterinario veterinario) {
		Optional<Veterinario> buscaVeterinario = vetRepository.findById(veterinario.getIdVeterinario());
		
		if(buscaVeterinario.isPresent()) {
			buscaVeterinario.get().setIdVeterinario(buscaVeterinario.get().getIdVeterinario());
			buscaVeterinario.get().setNome(veterinario.getNome());
			buscaVeterinario.get().setImagem(veterinario.getImagem());
			buscaVeterinario.get().setRg(veterinario.getRg());
			buscaVeterinario.get().setTelefone(veterinario.getTelefone());
			buscaVeterinario.get().setLogradouro(veterinario.getLogradouro());
			buscaVeterinario.get().setNumero(veterinario.getNumero());
			buscaVeterinario.get().setBairro(veterinario.getBairro());
			buscaVeterinario.get().setCidade(veterinario.getCidade());
			buscaVeterinario.get().setUf(veterinario.getUf());
			buscaVeterinario.get().setCrmv(veterinario.getCrmv());
			buscaVeterinario.get().setSenha(criptografarSenha(veterinario.getSenha()));
			
			veterinario = buscaVeterinario.get();
			
		}
		return Optional.of(vetRepository.save(veterinario));
	}
	private String criptografarSenha(String senha) {
		String senhaEncoder = encoder.encode(senha);
		return senhaEncoder;
	}
	
	private boolean compararSenhas(String senhaDigitada, String senhaDB) {
		return encoder.matches(senhaDigitada, senhaDB);
	}

	private String generatorBasicToken(String email, String password) {
		String structure = email + ":" + password;
		byte[] structureBase64 = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(structureBase64);
	}

}
