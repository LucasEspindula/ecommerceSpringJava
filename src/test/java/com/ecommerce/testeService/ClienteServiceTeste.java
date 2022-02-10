package com.ecommerce.testeService;

//import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.ecommerce.dominio.Cliente;
import com.ecommerce.dominio.Contato;
import com.ecommerce.dominio.Endereco;
import com.ecommerce.infra.repository.ClienteRepository;
import com.ecommerce.service.ClienteService;

public class ClienteServiceTeste {
	
	@Mock
	private ClienteRepository clienteRepository;
	private ClienteService clienteService;
	
	@BeforeEach
	public void iniciar() {
		MockitoAnnotations.openMocks(this);
		clienteService = new ClienteService(clienteRepository);
	}
	
	Contato contatoTeste = new Contato("aiai", "999");
	Endereco enderecoTeste = new Endereco("Ruazinha", "12", "Bairrozinho", "complementozin", "9999", "alvorada", "RS");

	Long id = 1L;
	String cpf = "12345678900";
	String nomeCliente = "Jose";
	
	@Test
	public void deveSalvarClienteComSucesso() {
		
		var clienteTeste = new Cliente(id, cpf, nomeCliente, contatoTeste, enderecoTeste);
		
		clienteService.salvar(clienteTeste);
		verify(clienteRepository, times(1)).save(Mockito.any(Cliente.class));
	}
	
	@Test
	public void deveValidarCLienteExistente() {
		
		try {
			var clienteTeste = new Cliente(id, cpf, nomeCliente, contatoTeste, enderecoTeste);
			clienteService.salvar(clienteTeste);
//			fail("deve quebrar");
			
		} catch (Exception e) {
			Assertions.assertEquals("Cliente ja cadastrado", e.getMessage());
		}
	}
}
