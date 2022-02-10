package com.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.dominio.Fornecedor;
import com.ecommerce.infra.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	private FornecedorRepository fornecedorRepository;
	
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	public void salvar(Fornecedor fornecedor) {
		fornecedorRepository.save(fornecedor);
	}
	
	public List<Fornecedor> buscar(String nome) {
		return fornecedorRepository.buscarFornecedor(nome);
	}
}
