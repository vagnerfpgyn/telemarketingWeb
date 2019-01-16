package com.example.tmkweb.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmkweb.api.event.RecursoCriadoEvent;
import com.example.tmkweb.api.model.Referencia;
import com.example.tmkweb.api.repository.ReferenciaRepository;
import com.example.tmkweb.api.service.ReferenciaService;

@RestController
@RequestMapping("/referencia")
public class ReferenciaResource {
	
	@Autowired
	ReferenciaRepository referenciaRepository;
	
	@Autowired
	ReferenciaService referenciaService;
	
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Referencia> listarReferencias(){
		return referenciaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Referencia> salvar (@Valid @RequestBody Referencia referencia, HttpServletResponse response){
		Referencia referenciaSalva = referenciaRepository.save(referencia);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, referenciaSalva.getId_referencia()));
		return ResponseEntity.status(HttpStatus.CREATED).body(referenciaSalva);
	}
	
	@GetMapping("/{id_referencia}")
	public ResponseEntity<Referencia> buscarPeloCodigo(@PathVariable Long id_referencia){
		Referencia referencia = referenciaRepository.findOne(id_referencia);
		return referencia !=null ? ResponseEntity.ok(referencia) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id_referencia}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover (@PathVariable Long id_referencia) {
		referenciaRepository.delete(id_referencia);
	}
	
	@PutMapping("/{id_referencia}")
	public ResponseEntity<Referencia> atualizar(@PathVariable Long id_referencia, @Valid @RequestBody Referencia referencia){
		Referencia referenciaSalva = referenciaService.atualizar(id_referencia, referencia);
		return ResponseEntity.ok(referenciaSalva);
		
		
	}
	

}
