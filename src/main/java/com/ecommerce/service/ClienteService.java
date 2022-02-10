package com.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.dominio.Cliente;
import com.ecommerce.infra.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public List<Cliente> buscar(String nome) {
		return clienteRepository.buscarCliente(nome);
	}
}
