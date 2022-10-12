package com.tcc.petPlusBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcc.petPlusBackEnd.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}
