package com.ecommerce.dominio;

public class Produto {
	
	private String nomeDoProduto;
	
	private String descricaoDoProduto;
	
	private Double valorUnitario;
	
	private int id;

	public Produto(String nomeDoProduto, String descricaoDoProduto, Double valorUnitario, int id) {
		super();
		this.nomeDoProduto = nomeDoProduto;
		this.descricaoDoProduto = descricaoDoProduto;
		this.valorUnitario = valorUnitario;
		this.id = id;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public String getDescricaoDoProduto() {
		return descricaoDoProduto;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public int getId() {
		return id;
	}
	
	
}
