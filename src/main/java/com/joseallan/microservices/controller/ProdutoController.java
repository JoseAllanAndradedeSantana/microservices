package com.joseallan.microservices.controller;

import com.joseallan.microservices.model.Produto;
import com.joseallan.microservices.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping(method = RequestMethod.POST)
    Produto create(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Optional<Produto> findById(@PathVariable Long id){
        return produtoRepository.findById(id);
    }
}
