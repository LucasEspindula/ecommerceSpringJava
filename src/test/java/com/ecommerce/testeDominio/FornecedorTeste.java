package com.ecommerce.testeDominio;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ecommerce.dominio.Contato;
import com.ecommerce.dominio.Endereco;
import com.ecommerce.dominio.Fornecedor;
import com.ecommerce.infra.excecoes.DominioInvalido;

public class FornecedorTeste {
	
	@Test
	public void deveCriarUmFornecedorValido() {
		
		var contatoTeste = new Contato("aiai", "999");
		var enderecoTeste = new Endereco("Ruazinha", "12", "Bairrozinho", "complementozin", "9999", "alvorada", "RS");
		
		Long id = 1L;
		String cnpj = "1234567";
		String nomeFantasia = "Uncharted";
		Fornecedor fornecedorTeste = new Fornecedor(id, cnpj, nomeFantasia, contatoTeste, enderecoTeste);
		
		Assertions.assertEquals(fornecedorTeste.getId(), id);
		Assertions.assertEquals(fornecedorTeste.getCnpj(), cnpj);
		Assertions.assertEquals(fornecedorTeste.getNomeFantasia(), nomeFantasia);

		Assertions.assertEquals(contatoTeste, fornecedorTeste.getContato());
		Assertions.assertEquals(enderecoTeste, fornecedorTeste.getEndereco());
	}
	
	@Test
	public void deveTestarFornecedorNullo() {
		
		try {
			var contatoTeste = new Contato(null, null);
			var enderecoTeste = new Endereco(null, null, null, null, null, null, null);
			
			Long id = null;
			String cnpj = null;
			String nomeFantasia = null;
			
			new Fornecedor(id, cnpj, nomeFantasia, contatoTeste, enderecoTeste);
		} catch (DominioInvalido dominioInvalido) {
			Assertions.assertEquals("[cnpj : CNPJ nao pode ser vazio, "
					+ "contato.email : e-mail nao pode ser vazio, "
					+ "contato.telefone : telefone nao pode ser vazio, "
					+ "endereco.bairro : Bairro nao pode ser vazio, "
					+ "endereco.cep : Cep nao pode ser vazio, "
					+ "endereco.cidade : cidade nao pode ser vazio, "
					+ "endereco.estado : estado nao pode ser vazio, "
					+ "endereco.numero : Numero nao pode ser vazio, "
					+ "endereco.rua : Rua nao pode ser vazio, "
					+ "nomeFantasia : Nome fantasia nao pode ser vazio]", 
					dominioInvalido.getMessage());
		}
	}
	
	@Test
	public void deveTestarACriacaoDeFornecedorComNumeroMaximoDeCaracter() {
		
		try {
			String emailContato = RandomStringUtils.randomAlphabetic(101);
			String telefoneContato = RandomStringUtils.randomAlphabetic(21);

			var contatoTeste = new Contato(emailContato, telefoneContato);

			String ruaEndereco = RandomStringUtils.randomAlphabetic(101);
			String numeroEndereco = RandomStringUtils.randomAlphabetic(7);
			String bairroEndereco = RandomStringUtils.randomAlphabetic(51);
			String compEndereco = RandomStringUtils.randomAlphabetic(121);
			String cepEndereco = RandomStringUtils.randomAlphabetic(11);
			String cidadeEndereco = RandomStringUtils.randomAlphabetic(51);
			String estadoEndereco = RandomStringUtils.randomAlphabetic(3);
			var enderecoTeste = new Endereco(ruaEndereco, numeroEndereco, bairroEndereco, compEndereco, cepEndereco,
					cidadeEndereco, estadoEndereco);
			
			Long id = 1L;
			String cnpj = RandomStringUtils.randomAlphabetic(21);
			String nomeFantasia = RandomStringUtils.randomAlphabetic(101);
			new Fornecedor(id, cnpj, nomeFantasia, contatoTeste, enderecoTeste);
		} catch (DominioInvalido dominioInvalido) {
			Assertions.assertEquals("[cnpj : CNPJ pode ter no maximo 20 caracters, "
					+ "contato.email : e-mail pode ter no maximo 100 caracters, "
					+ "contato.telefone : telefone pode ter no maximo 20 caracters, "
					+ "endereco.bairro : bairro pode ter no maximo 50 caracters, "
					+ "endereco.cep : Cep pode ter no maximo 10 caracters, "
					+ "endereco.cidade : cidade pode ter no maximo 50 caracters, "
					+ "endereco.complemento : complemento pode ter no maximo 120 caracters, "
					+ "endereco.estado : estado pode ter no maximo 2 caracters, "
					+ "endereco.numero : numero pode ter no maximo 6 caracters, "
					+ "endereco.rua : rua pode ter no maximo 100 caracters, "
					+ "nomeFantasia : Nome fantasia pode ter no maximo 100 caracters]", 
					dominioInvalido.getMessage());
		}
	}
	
	
	
	
	
}
