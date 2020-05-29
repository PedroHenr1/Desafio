package com.example.dev.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dev.domain.Produto;
import com.example.dev.service.ProdutoService;

@RestController
@RequestMapping("/app")
public class ProdutoRest
{
	
	@Autowired
	private ProdutoService prod_serv;
	
	@PostMapping("/produto")
	public ResponseEntity<Produto> save_produto(@RequestBody @Valid Produto produto)
	{
		return ResponseEntity.ok(prod_serv.save_produto(produto));
	}
	
	@PutMapping("/produto")
	public ResponseEntity<Produto> update_produto(@RequestBody @Valid Produto produto)
	{
		return ResponseEntity.ok(prod_serv.update_produto(produto));
	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity delete_produto(@PathVariable Integer id)
	{
		try
		{
			prod_serv.delete_produto(id);
			return ResponseEntity.ok().build();
		}
		catch (Exception e)
		{
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> list_produto()
	{
		return ResponseEntity.ok(prod_serv.list_produto());
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> get_produto(@PathVariable Integer id)
	{
		return ResponseEntity.ok(prod_serv.get_produto(id));
	}
}
