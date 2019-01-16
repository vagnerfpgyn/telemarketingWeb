package com.example.tmkweb.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tmkweb.api.model.Ligacao;
import com.example.tmkweb.api.repository.LigacaoRepository;

@Service
public class LigacaoService {
	
	@Autowired
	LigacaoRepository ligacaoRepository;
	
	public Ligacao addDataHora(Ligacao ligacao){
		ligacao.setDataHora(LocalDateTime.now());
		return ligacaoRepository.save(ligacao);
	}

}
