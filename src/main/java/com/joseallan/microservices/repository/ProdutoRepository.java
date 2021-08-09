package com.joseallan.microservices.repository;

import com.joseallan.microservices.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto,Long> {
}
