package com.ecommerce.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Produto extends Entidade{
	
	@Id
	@Column(name = "idProduto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Nome do produto nao pode ser vazio")
	@NotBlank(message = "Nome do produto nao pode ser vazio")
	@Size(max = 100, message = "Nome do produto pode ter no maximo 100 caracters")
	private String nomeDoProduto;
	
	@NotNull(message = "Descricao nao pode ser vazio")
	@NotBlank(message = "Descricao nao pode ser vazio")
	@Size(max = 500, message = "Descricao pode ter no maximo 500 caracters")
	private String descricaoDoProduto;
	
	@NotNull(message = "O valor nao pode ser vazio")
	private Double valorUnitario;

	// este construtor eh para uso de sping / jackson
	@Deprecated
	public Produto() {
	}
	
	public Produto(Long id, String nomeDoProduto, String descricaoDoProduto, Double valorUnitario) {
		this.nomeDoProduto = nomeDoProduto;
		this.descricaoDoProduto = descricaoDoProduto;
		this.valorUnitario = valorUnitario;
		this.id = id;
		isValid();
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

	public Long getId() {
		return id;
	}
}
