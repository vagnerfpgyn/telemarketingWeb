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
import com.example.tmkweb.api.model.Status;
import com.example.tmkweb.api.repository.StatusRepository;
import com.example.tmkweb.api.service.StatusService;

@RestController
@RequestMapping("/status")
public class StatusResource {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Status> listarStatus(){
		return statusRepository.findAll();		
	}
	
	@PostMapping
	public ResponseEntity<Status> salvar(@Valid @RequestBody Status status, HttpServletResponse response) {
		Status statusSalvo = statusRepository.save(status);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, statusSalvo.getId_status()));
		 return ResponseEntity.status(HttpStatus.CREATED).body(statusSalvo);	
	}
	
	@GetMapping("/{id_status}")
	public ResponseEntity<Status> buscarPeloCodigo(@PathVariable Long id_status) {
		Status status = statusRepository.findOne(id_status);
		return status != null ? ResponseEntity.ok(status) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id_status}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover (@PathVariable long id_status) {
		statusRepository.delete(id_status);
	}
	
	@PutMapping("/{id_status}")
	public ResponseEntity<Status> atualizar(@PathVariable long id_status, @Valid @RequestBody Status status){
		Status statusSalvo = statusService.atualizar(id_status, status);
		return ResponseEntity.ok(statusSalvo);
	}
}
