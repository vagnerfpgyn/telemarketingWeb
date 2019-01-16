package com.example.tmkweb.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tmkweb.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
