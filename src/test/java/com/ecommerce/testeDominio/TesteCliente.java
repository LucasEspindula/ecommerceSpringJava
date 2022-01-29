package com.ecommerce.testeDominio;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ecommerce.dominio.Cliente;
import com.ecommerce.dominio.Contato;
import com.ecommerce.dominio.Endereco;
import com.ecommerce.infra.excecoes.DominioInvalido;

public class TesteCliente {

	@Test
	public void deveCriarUmClienteValido() {

		var contatoTeste = new Contato("aiai", "999");
		var enderecoTeste = new Endereco("Ruazinha", "12", "Bairrozinho", "complementozin", "9999", "alvorada", "RS");

		Long id = 1L;
		String cpf = "12345678900";
		String nomeCliente = "Jose";
		var clienteTeste = new Cliente(id, cpf, nomeCliente, contatoTeste, enderecoTeste);

		Assertions.assertEquals(clienteTeste.getId(), id);
		Assertions.assertEquals(clienteTeste.getCpfCliente(), cpf);
		Assertions.assertEquals(clienteTeste.getNomeCliente(), nomeCliente);

		Assertions.assertEquals(contatoTeste, clienteTeste.getContato());
		Assertions.assertEquals(enderecoTeste, clienteTeste.getEndereco());
	}

	@Test
	public void deveTestarClienteNullo() {

		try {
			var contatoTeste = new Contato(null, null);
			var enderecoTeste = new Endereco(null, null, null, null, null, null, null);

			Long id = null;
			String cpf = null;
			String nomeCliente = null;
			new Cliente(id, cpf, nomeCliente, contatoTeste, enderecoTeste);

		} catch (DominioInvalido dominioInvalido) {
			Assertions.assertEquals(
					"[contato.email : e-mail nao pode ser vazio, "
					+ "contato.telefone : telefone nao pode ser vazio, "
					+ "cpfCliente : CPF nao pode ser vazio, "
					+ "endereco.bairro : Bairro nao pode ser vazio, "
					+ "endereco.cep : Cep nao pode ser vazio, "
					+ "endereco.cidade : cidade nao pode ser vazio, "
					+ "endereco.complemento : informe um complemento, "
					+ "endereco.estado : estado nao pode ser vazio, "
					+ "endereco.numero : Numero nao pode ser vazio, "
					+ "endereco.rua : Rua nao pode ser vazio, "
					+ "nomeCliente : nome do cliente nao pode ser vazio]",
					dominioInvalido.getMessage());
		}
	}

	@Test
	public void deveTestarACriacaoDeClienteComNumeroMaximoDeCaracter() {

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
			String clienteCpf = RandomStringUtils.randomAlphabetic(21);
			String clienteNome = RandomStringUtils.randomAlphabetic(101);
			new Cliente(id, clienteCpf, clienteNome, contatoTeste, enderecoTeste);

		} catch (DominioInvalido dominioInvalido) {
			Assertions.assertEquals(
					"[contato.email : e-mail pode ter no maximo 100 caracters, "
					+ "contato.telefone : telefone pode ter no maximo 20 caracters, "
					+ "cpfCliente : CPF pode ter no maximo 20 caracters, "
					+ "endereco.bairro : bairro pode ter no maximo 50 caracters, "
					+ "endereco.cep : Cep pode ter no maximo 10 caracters, "
					+ "endereco.cidade : cidade pode ter no maximo 50 caracters, "
					+ "endereco.complemento : complemento pode ter no maximo 120 caracters, "
					+ "endereco.estado : estado pode ter no maximo 2 caracters, "
					+ "endereco.numero : numero pode ter no maximo 6 caracters, "
					+ "endereco.rua : rua pode ter no maximo 100 caracters, "
					+ "nomeCliente : nome do cliente pode ter no maximo 100 caracters]",
					dominioInvalido.getMessage());
		}
	}
}
