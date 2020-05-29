package com.example.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dev.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>
{

}
