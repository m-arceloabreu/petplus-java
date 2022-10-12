package com.tcc.petPlusBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.petPlusBackEnd.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
