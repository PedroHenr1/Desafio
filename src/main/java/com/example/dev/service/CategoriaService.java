package com.example.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.domain.Categoria;
import com.example.dev.repository.CategoriaRepository;

@Service
public class CategoriaService
{
	@Autowired
	private CategoriaRepository cat_rep;
	
	public Categoria save_categoria(Categoria categoria)
	{
		return cat_rep.save(categoria);
	}
	
	public void delete_categoria(Integer id)
	{
		cat_rep.deleteById(id);
	}
	
	public Categoria update_categoria(Categoria categoria)
	{
		if(categoria != null)
			return cat_rep.save(categoria);
		
		throw new RuntimeException("Erro ao atualizar categoria.");
	}
	
	public List<Categoria> list_categoria()
	{
		return cat_rep.findAll();
	}
	
	public Categoria get_categoria(Integer id)
	{
		return cat_rep.findById(id).get();
	}
}
