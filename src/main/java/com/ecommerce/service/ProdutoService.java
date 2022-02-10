package com.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.dominio.Produto;
import com.ecommerce.infra.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public void salvar(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public List<Produto> buscar(String nome) {
		return produtoRepository.buscarProduto(nome);
	}
}
