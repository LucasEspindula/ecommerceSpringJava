package com.ecommerce.testeDominio;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ecommerce.dominio.Produto;
import com.ecommerce.infra.excecoes.DominioInvalido;

public class ProdutoTeste {
	
	@Test
	public void deveCriarUmProdutoValido() {
		
		String nomeDoProduto = "Lampada";		
		String descricaoDoProduto = "ele brilha";		
		Double valorUnitario = 15.00;
		Long id = 1L;
		
		var produtoTeste = new Produto(id, nomeDoProduto, descricaoDoProduto, valorUnitario);
		
		Assertions.assertEquals(produtoTeste.getId(), id);
		Assertions.assertEquals(produtoTeste.getNomeDoProduto(), nomeDoProduto);
		Assertions.assertEquals(produtoTeste.getDescricaoDoProduto(), descricaoDoProduto);
		Assertions.assertEquals(produtoTeste.getValorUnitario(), valorUnitario);
	}
	
	@Test
	public void deveTestarProdutoNullo() {
		
		try {
			new Produto(1L, null, null, null);
			
		} catch (DominioInvalido dominioInvalido) {
			Assertions.assertEquals("[descricaoDoProduto : Descricao nao pode ser vazio, "
					+ "nomeDoProduto : Nome do produto nao pode ser vazio, "
					+ "valorUnitario : O valor nao pode ser vazio]", 
					dominioInvalido.getMessage());
		}
	}
	
	@Test
	public void deveTestarACriacaoDeProdutoComNumeroMaximoDeCaracter() {
		
		try {
			String nomeDoProduto = RandomStringUtils.randomAlphabetic(101);		
			String descricaoDoProduto = RandomStringUtils.randomAlphabetic(501);		
			Double valorUnitario = 1.00;
			Long id = 1L;
			
			new Produto(id, nomeDoProduto, descricaoDoProduto, valorUnitario);
			
		} catch (DominioInvalido dominioInvalido) {
			Assertions.assertEquals("[descricaoDoProduto : Descricao pode ter no maximo 500 caracters, "
					+ "nomeDoProduto : Nome do produto pode ter no maximo 100 caracters]", 
					dominioInvalido.getMessage());
		}
	}
}
