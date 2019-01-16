package com.example.tmkweb.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tmkweb.api.event.RecursoCriadoEvent;
import com.example.tmkweb.api.model.Produto;
import com.example.tmkweb.api.repository.ProdutoRepository;
import com.example.tmkweb.api.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {
	
	@Autowired 
	ProdutoRepository produtoRepository;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	@PostMapping
	public ResponseEntity<Produto> salvar(@Valid @RequestBody Produto produto,HttpServletResponse response){
		Produto produtoSalvo = produtoRepository.save(produto);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, produto.getId_produto()));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}
	
	@GetMapping("/{id_produto}")
	public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable long id_produto){
		Produto produto = produtoRepository.findOne(id_produto);
		return produto !=null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id_produto}")
	public ResponseEntity<Produto> atualizar(@PathVariable long id_produto, @Valid @RequestBody Produto produto) {
		Produto produtoSalvo = produtoService.atualizar(id_produto, produto);
		return ResponseEntity.ok(produtoSalvo);
	}

}
