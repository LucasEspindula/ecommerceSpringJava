package com.ecommerce.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dominio.Fornecedor;
import com.ecommerce.service.FornecedorService;

@RequestMapping("/fornecedor")
@RestController
public class FornecedorController {
	
	private FornecedorService fornecedorService;

	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}
	
	@GetMapping
	public List<Fornecedor> buscar(@RequestParam("nome") String nome) {
		return fornecedorService.buscar(nome);
	}
	
	@PostMapping
	public void criarFornecedor(@RequestBody @Valid Fornecedor novoFornecedor) {
		fornecedorService.salvar(novoFornecedor);
	}
}
