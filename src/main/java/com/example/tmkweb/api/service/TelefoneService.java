package com.example.tmkweb.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tmkweb.api.model.Telefone;
import com.example.tmkweb.api.repository.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	public Telefone defineTipoTelefone(Telefone telefone){
		Telefone telefoneSalvar = telefone;
		int tamanho =0;
		tamanho = (telefoneSalvar.getTelefone()).length();
		
		if(tamanho == 8) {
			telefoneSalvar.setTipo('f');
		}
		if(tamanho ==9 ) {
			telefoneSalvar.setTipo('c');
		}		
	
		return telefoneRepository.save(telefoneSalvar);
	}

}
