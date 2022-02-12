package com.ecommerce.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class Pedido {
	
	@Id
	@Column(name = "idPedido")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataCompra;
	
	@ManyToOne
	@JoinColumn(name = "idFornecedor")
	@NotNull(message = "Fornecedor nao pode ser vazio")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name = "idCliente")
	@NotNull(message = "Cliente nao pode ser vazio")
	private Cliente cliente;
	
	@NotNull(message = "Valor do frete nao pode ser vazio")
	private Double valorFrete;
	
	@OneToMany(cascade = {CascadeType.ALL},  mappedBy = "pedido")
	private List<Item> itens;

	// este construtor eh para uso de sping / jackson
	@Deprecated
	public Pedido() {
	}
	
	public Pedido(Long id, Fornecedor fornecedor, Cliente cliente, Double valorFrete,Item itens) {
		this.itens = new ArrayList<>();
		this.dataCompra = LocalDateTime.now();
		this.fornecedor = fornecedor;
		this.cliente = cliente;
		this.valorFrete = valorFrete;
		this.id = id;
		adicionarItem(itens);
	}
	
	public void adicionarItem(Item item) {
		// methodo guarda chuva, impede do null entrar na lista
		if (item == null) {
			return;
		}
		item.setPedido(this);
		this.itens.add(item);
	}
	
	public Double getValorTotal() {
		return getValorTotalItens() + getValorFrete();
	}

	public Double getValorTotalItens() {
		double valorTotal = 0;		
		for (Item item : itens) {
			valorTotal += item.getValorTotal();
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

	public Long getId() {
		return id;
	}

	public List<Item> getItens() {
		return itens;
	}
}	
