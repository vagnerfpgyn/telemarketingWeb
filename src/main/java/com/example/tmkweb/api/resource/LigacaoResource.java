package com.example.tmkweb.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmkweb.api.event.RecursoCriadoEvent;
import com.example.tmkweb.api.model.Ligacao;
import com.example.tmkweb.api.repository.LigacaoRepository;
import com.example.tmkweb.api.service.LigacaoService;

@RestController
@RequestMapping("/ligacao")
public class LigacaoResource {
	
	@Autowired
	LigacaoRepository ligacaoRepository;
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	@Autowired
	LigacaoService ligacaoService;
	
	@GetMapping
	public List<Ligacao> listar(){
		return ligacaoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Ligacao> salvar(@Valid @RequestBody Ligacao ligacao, HttpServletResponse response){
		Ligacao ligacaoSalva = ligacaoService.addDataHora(ligacao);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, ligacaoSalva.getId_ligacao()));
		return ResponseEntity.status(HttpStatus.CREATED).body(ligacao);
	}
	
}
