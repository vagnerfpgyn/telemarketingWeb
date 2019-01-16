package com.example.tmkweb.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.tmkweb.api.model.Produto;
import com.example.tmkweb.api.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Produto atualizar(long id_produto, Produto produto){
		Produto produtoSalvo = produtoRepository.findOne(id_produto);
		if (produtoSalvo == null) {
			throw new EmptyResultDataAccessException(1);			
		}
		BeanUtils.copyProperties(this, produtoSalvo, "id_produto");
		return produtoRepository.save(produto);
	}
	
	

}
