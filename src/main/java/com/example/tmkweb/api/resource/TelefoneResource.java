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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmkweb.api.event.RecursoCriadoEvent;
import com.example.tmkweb.api.model.Telefone;
import com.example.tmkweb.api.repository.TelefoneRepository;
import com.example.tmkweb.api.service.TelefoneService;

@RestController
@RequestMapping("/telefone")
public class TelefoneResource {

	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	@Autowired
	TelefoneService telefoneService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Telefone> salvar(@Valid @RequestBody Telefone telefone, HttpServletResponse response) {
		Telefone telefoneSalvo = telefoneService.defineTipoTelefone(telefone);
		publisher.publishEvent( new RecursoCriadoEvent(this, response, telefoneSalvo.getId_telefone()));
		return ResponseEntity.status(HttpStatus.CREATED).body(telefoneSalvo);
	}
	
	@GetMapping
	public List<Telefone> listarTodos(){
		return telefoneRepository.findAll();
	}
	
	@GetMapping("/{id_telefone}")
	public ResponseEntity<Telefone> buscarPeloCodigo(@PathVariable long id_telefone){
		Telefone telefone = telefoneRepository.findOne(id_telefone);
		return telefone != null ? ResponseEntity.ok(telefone): ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id_telefone}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar (@PathVariable long id_telefone) {
		telefoneRepository.delete(id_telefone);
	}
	

}
