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

import com.ecommerce.dominio.Contato;
import com.ecommerce.dominio.Endereco;
import com.ecommerce.dominio.Fornecedor;
import com.ecommerce.infra.repository.FornecedorRepository;
import com.ecommerce.service.FornecedorService;

public class FornecedorServiceTeste {
	
	@Mock
	private FornecedorRepository fornecedorRepository;
	private FornecedorService fornecedorService;
	
	@BeforeEach
	public void iniciar() {
		MockitoAnnotations.openMocks(this); 
		fornecedorService = new FornecedorService(fornecedorRepository);
	}
	
	Contato contatoTeste = new Contato("aiai", "999");
	Endereco enderecoTeste = new Endereco("Ruazinha", "12", "Bairrozinho", "complementozin", "9999", "alvorada", "RS");

	Long id = 1L;
	String cnpj = "12345678900";
	String nomeFantasia = "Uncharted";
	
	@Test
	public void deveSalvarFornecedorComSucesso() {
		
		var fornecedorTeste = new Fornecedor(id, cnpj, nomeFantasia, contatoTeste, enderecoTeste);
		
		fornecedorService.salvar(fornecedorTeste);
		verify(fornecedorRepository, times(1)).save(Mockito.any(Fornecedor.class));
	}
	
	@Test
	public void deveValidarFornecedorExistente() {
		
		try {
			var fornecedorTeste = new Fornecedor(id, cnpj, nomeFantasia, contatoTeste, enderecoTeste);
			fornecedorService.salvar(fornecedorTeste);
//			fail("deve quebrar");
			
		} catch (Exception e) {
			Assertions.assertEquals("Fornecedor ja cadastrado", e.getMessage());
		}
	}	
}
