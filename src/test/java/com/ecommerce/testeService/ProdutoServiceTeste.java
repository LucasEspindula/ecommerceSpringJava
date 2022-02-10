package com.ecommerce.testeService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ecommerce.dominio.Cliente;
import com.ecommerce.dominio.Produto;
import com.ecommerce.infra.repository.ProdutoRepository;
import com.ecommerce.service.ProdutoService;

public class ProdutoServiceTeste {
	
	@Mock
	private ProdutoRepository produtoRepository;
	private ProdutoService produtoService;
	
	@BeforeEach
	public void iniciar() {
		MockitoAnnotations.openMocks(this);
		produtoService = new ProdutoService(produtoRepository);
	}
	
	String nomeDoProduto = "Produto type null";		
	String descricaoDoProduto = "type null";		
	Double valorUnitario = 15.00;
	Long id = 1L;
	
	@Test
	public void deveSalvarProdutoComSucesso() {
		
		var produtoTeste = new Produto(id, nomeDoProduto, descricaoDoProduto, valorUnitario);
		
		produtoService.salvar(produtoTeste);
		verify(produtoRepository, times(1)).save(Mockito.any(Produto.class));
	}
	
	@Test
	public void deveValidarProdutoExistente() {
		
		try {
			var produtoTeste = new Produto(id, nomeDoProduto, descricaoDoProduto, valorUnitario);
			produtoService.salvar(produtoTeste);
//			fail("deve quebrar");
			
		} catch (Exception e) {
			Assertions.assertEquals("Produto ja cadastrado", e.getMessage());
		}
	}
}
