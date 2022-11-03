package com.tcc.petPlusBackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.petPlusBackEnd.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{
	/* public List<Servico> findByClinicaID(Long clinicaID); */
}
