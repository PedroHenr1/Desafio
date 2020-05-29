package com.example.dev.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id_produto")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_cat")
	private Categoria id_categoria;
	private String descricao;
	
	public Produto() {}
	
	public Produto(Categoria cat, String desc)
	{
		this.id_categoria = cat;
		this.descricao = desc;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Categoria getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getDescricao()
	{
		return descricao;
	}
	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
	
	
}
