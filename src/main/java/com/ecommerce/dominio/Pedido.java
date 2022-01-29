package com.ecommerce.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "CPF nao pode ser null")
	@NotBlank(message = "CPF nao pode ser vazio")
	@Size(max = 20, message = "CPF pode ter no maximo 20 caracters")
	private LocalDateTime dataCompra;
	
	@NotNull(message = "CPF nao pode ser null")
	@NotBlank(message = "CPF nao pode ser vazio")
	@Size(max = 20, message = "CPF pode ter no maximo 20 caracters")
	private Fornecedor fornecedor;
	
	@NotNull(message = "CPF nao pode ser null")
	@NotBlank(message = "CPF nao pode ser vazio")
	@Size(max = 20, message = "CPF pode ter no maximo 20 caracters")
	private Cliente cliente;
	
	@NotNull(message = "CPF nao pode ser null")
	@NotBlank(message = "CPF nao pode ser vazio")
	@Size(max = 20, message = "CPF pode ter no maximo 20 caracters")
	private Double valorFrete;
	
	
	private List<Item> itens = new ArrayList<>();

	public Pedido(LocalDateTime dataCompra, Fornecedor fornecedor, Cliente cliente, Double valorFrete, int id,
			List<Item> itens) {
		super();
		this.dataCompra = dataCompra;
		this.fornecedor = fornecedor;
		this.cliente = cliente;
		this.valorFrete = valorFrete;
		this.id = id;
		this.itens = itens;
	}
	
	public Double getValorTotal() {
		return getValorTotalItens() + getValorFrete();
	}

	public Double getValorTotalItens() {
		double valorTotal = 0;		
		for (Item item : itens) {
//			valorTotal += item.getValorTotal();
		}
		return valorTotal;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public int getId() {
		return id;
	}

	public List<Item> getItens() {
		return itens;
	}
}	
