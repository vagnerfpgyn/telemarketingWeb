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
import com.example.tmkweb.api.model.Cidade;
import com.example.tmkweb.api.repository.CidadeRepository;
import com.example.tmkweb.api.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Cidade> listarCidades(){
		return cidadeRepository.findAll();		
	}
	
	@PostMapping
	public ResponseEntity<Cidade> salvar(@Valid @RequestBody Cidade cidade, HttpServletResponse response) {
		Cidade cidadeSalvo = cidadeRepository.save(cidade);
		publisher.publishEvent(new RecursoCriadoEvent(this,response, cidadeSalvo.getId_cidade()));		
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeSalvo);
	}
	
	@GetMapping ("/{id_cidade}")
	public ResponseEntity<Cidade> buscarPeloCodigo(@PathVariable long id_cidade){
		Cidade cidade = cidadeRepository.findOne(id_cidade);
		return cidade !=null? ResponseEntity.ok(cidade) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id_cidade}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover (@PathVariable long id_cidade) {
		cidadeRepository.delete(id_cidade);
	}
	
	@PutMapping("/{id_cidade}")
	public ResponseEntity<Cidade> atualizar(@PathVariable long id_cidade,@Valid @RequestBody Cidade cidade){
		Cidade cidadeSalva = cidadeService.atualizar(id_cidade, cidade);
		return ResponseEntity.ok(cidadeSalva);
		
	}
}
