package com.example.tmkweb.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.tmkweb.api.model.Cadastro;
import com.example.tmkweb.api.repository.CadastroRepository;

@Service
public class CadastroService {

	@Autowired
	CadastroRepository cadastroRepository;
	
	
	public Cadastro atualizar(long id_cadastro, Cadastro cadastro) {
		Cadastro cadastroSalvo = cadastroRepository.findOne(id_cadastro);
		if (cadastroSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(cadastro, cadastroSalvo, "id_cadastro");
		return cadastroRepository.save(cadastroSalvo);
	}
	
}
