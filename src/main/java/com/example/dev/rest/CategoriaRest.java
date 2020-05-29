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

import com.example.dev.domain.Categoria;
import com.example.dev.service.CategoriaService;

@RestController
@RequestMapping("/app")
public class CategoriaRest
{
	@Autowired
	private CategoriaService cat_serv;
	
	@PostMapping("/categoria")
	public ResponseEntity<Categoria> save_categoria(@RequestBody @Valid Categoria categoria)
	{
		return ResponseEntity.ok(cat_serv.save_categoria(categoria));
	}
	
	@DeleteMapping("/categoria/{id}")
	public ResponseEntity delete_categoria(@PathVariable Integer id)
	{
		try
		{
			cat_serv.delete_categoria(id);
			return ResponseEntity.ok().build();
		}
		catch (Exception e)
		{
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/categoria")
	public ResponseEntity<Categoria> update_categoria(@RequestBody @Valid Categoria categoria)
	{
		return ResponseEntity.ok(cat_serv.update_categoria(categoria));
	}
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> list_categoria()
	{
		return ResponseEntity.ok(cat_serv.list_categoria());
	}
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<Categoria> get_categoria(@PathVariable Integer id)
	{
		return ResponseEntity.ok(cat_serv.get_categoria(id));
	}
}
