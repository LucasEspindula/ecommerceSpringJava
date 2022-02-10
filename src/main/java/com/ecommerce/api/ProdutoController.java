package com.ecommerce.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dominio.Produto;
import com.ecommerce.service.ProdutoService;

@RequestMapping("/produto")
@RestController
public class ProdutoController {
	
	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public List<Produto> buscar(@RequestParam("nome") String nome) {
		return produtoService.buscar(nome);
	}
	
	@PostMapping
	public void criarProduto(@RequestBody @Valid Produto novoProduto) {
		produtoService.salvar(novoProduto);
	}
}
