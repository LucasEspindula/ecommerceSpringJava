package com.ecommerce.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Item extends Entidade{
	
	@Id
	@Column(name = "idItem")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	
	@JoinColumn(name = "idProduto")
	@NotNull(message = "Produto nao pode ser vazio")
	private Produto produto;
	
	@NotNull(message = "Quantidade nao pode ser vazia")
	private int quantidade;

	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedido pedido;
	
	
//	 este construtor eh para uso de sping / jackson
	@Deprecated
	public Item() {
	}
	
	public Item(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
		isValid();
	}

	public double getValorTotal() {
		return produto.getValorUnitario() * quantidade;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
