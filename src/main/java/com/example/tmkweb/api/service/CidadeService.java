package com.example.tmkweb.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.tmkweb.api.model.Cidade;
import com.example.tmkweb.api.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepository cidadeRepository;

	public Cidade atualizar (long id_cidade, Cidade cidade) {
		Cidade cidadeSalva = cidadeRepository.findOne(id_cidade);
		if (cidadeSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(cidade, cidadeSalva, "id_cidade");
		return cidadeRepository.save(cidadeSalva);
	}
}
