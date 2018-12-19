package com.example.tmkweb.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.tmkweb.api.model.Status;
import com.example.tmkweb.api.repository.StatusRepository;

@RestController
@RequestMapping("/status")
public class StatusResource {
	
	@Autowired
	private StatusRepository statusRepository;

	@GetMapping
	public List<Status> listarStatus(){
		return statusRepository.findAll();		
	}
	
	@PostMapping
	public ResponseEntity<Status> salvar(@Valid @RequestBody Status status, HttpServletResponse response) {
		Status statusSalvo = statusRepository.save(status);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				 .buildAndExpand(statusSalvo.getId_status()).toUri();		 				 		 
		 return ResponseEntity.created(uri).body(statusSalvo);		
	}
	@GetMapping("/{id_status}")
	public ResponseEntity<Status> buscarPeloCodigo(@PathVariable Long id_status) {
		Status status = statusRepository.findOne(id_status);
		return status != null ? ResponseEntity.ok(status) : ResponseEntity.notFound().build();
		
	}
}
