package com.example.dev.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer id_cat;
	private String categoria;
	
	public Categoria() {}
	
	public Categoria( String categoria)
	{

		this.categoria = categoria;
	}

	public Integer getId_cat() {
		return id_cat;
	}
	public void setId_cat(Integer id_cat) {
		this.id_cat = id_cat;
	}
	public String getCategoria()
	{
		return categoria;
	}
	public void setCategoria(String categoria)
	{
		this.categoria = categoria;
	}
	
	
}
