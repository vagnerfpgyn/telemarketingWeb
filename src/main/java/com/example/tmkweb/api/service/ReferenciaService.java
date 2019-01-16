package com.example.tmkweb.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.tmkweb.api.model.Referencia;
import com.example.tmkweb.api.repository.ReferenciaRepository;

@Service
public class ReferenciaService {
	
	@Autowired
	ReferenciaRepository referenciaRepository;
	
	public Referencia atualizar(long id_referencia, Referencia referencia){
		Referencia referenciaSalva = referenciaRepository.findOne(id_referencia);
		if (referenciaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(referencia, referenciaSalva, "id_referencia");
		return referenciaRepository.save(referenciaSalva);
	}

}
