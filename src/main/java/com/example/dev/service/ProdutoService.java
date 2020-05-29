package com.example.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.domain.Produto;
import com.example.dev.repository.ProdutoRepository;

import javassist.NotFoundException;

@Service
public class ProdutoService
{
	
	@Autowired
	private ProdutoRepository prod_rep;
	
	public Produto save_produto(Produto produto)
	{
		return prod_rep.save(produto);
	}
	
	public Produto update_produto(Produto produto)
	{
		if(produto != null)
			return prod_rep.save(produto);
		throw new RuntimeException("Ocorreu um erro ao tentar atualizar o produto.");
	}
	
	public void delete_produto(Integer id) 
	{
		prod_rep.deleteById(id);
	
	}
	
	public Produto get_produto(Integer id)
	{
		return prod_rep.findById(id).get();
	}
	
	public List<Produto> list_produto()
	{
		return prod_rep.findAll();
	}
	
}
