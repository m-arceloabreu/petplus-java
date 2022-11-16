package com.tcc.petPlusBackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.petPlusBackEnd.model.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{
	public List<Veterinario> findByNome (String nome);
	public Optional<Veterinario> findByEmail(String email);
	public Optional<Veterinario> findOneByNome (String nome);
}
