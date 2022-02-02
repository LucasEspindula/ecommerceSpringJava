package com.ecommerce.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dominio.Cliente;
import com.ecommerce.service.ClienteService;

@RequestMapping("/cliente")
@RestController
public class ClienteController {
	
	private ClienteService clienteService;
		
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@GetMapping
	public List<Cliente> buscar(@RequestParam("nome") String nome) {
		return clienteService.buscar(nome);
	}
	
	@PostMapping
	public void criarCliente(@RequestBody @Valid Cliente novoCliente) {
		clienteService.salvar(novoCliente);
	}
}
