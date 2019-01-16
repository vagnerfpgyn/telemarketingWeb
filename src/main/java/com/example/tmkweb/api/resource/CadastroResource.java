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
import com.example.tmkweb.api.model.Cadastro;
import com.example.tmkweb.api.repository.CadastroRepository;
import com.example.tmkweb.api.service.CadastroService;

@RestController
@RequestMapping ("/cadastro")
public class CadastroResource {
	
	@Autowired
	CadastroRepository cadastroRepository;
	
	@Autowired
	CadastroService cadastroService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Cadastro> listar(){
		return cadastroRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Cadastro> salvar(@Valid @RequestBody Cadastro cadastro, HttpServletResponse response){
		Cadastro cadastroSalvo = cadastroRepository.save(cadastro);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cadastroSalvo.getId_cadastro()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
	}
	
	@GetMapping("/{id_cadastro}")
	public ResponseEntity<Cadastro> buscarPeloId(@PathVariable long id_cadastro){
		Cadastro cadastro = cadastroRepository.findOne(id_cadastro);
		return cadastro != null ? ResponseEntity.ok(cadastro) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id_cadastro}")
	public ResponseEntity<Cadastro> atualizar(@PathVariable long id_cadastro, @Valid @RequestBody Cadastro cadastro){
	Cadastro cadastroSalvo = cadastroService.atualizar(id_cadastro, cadastro);
	return ResponseEntity.ok(cadastroSalvo);
	}
	
	@DeleteMapping("/{id_cadastro}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover (@PathVariable long id_cadastro){
		cadastroRepository.delete(id_cadastro);
	}

}
