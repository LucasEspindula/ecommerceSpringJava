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
public class Fornecedor extends Pessoa {

	@Id
	@Column(name = "idFornecedor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "CNPJ nao pode ser vazio")
	@NotBlank(message = "CNPJ nao pode ser vazio")
	@Size(max = 20, message = "CNPJ pode ter no maximo 20 caracters")
	private String cnpj;

	@NotNull(message = "Nome fantasia nao pode ser vazio")
	@NotBlank(message = "Nome fantasia nao pode ser vazio")
	@Size(max = 100, message = "Nome fantasia pode ter no maximo 100 caracters")
	private String nomeFantasia;

	// este construtor eh para uso de sping / jackson
	@Deprecated
	public Fornecedor() {
	}
	
	public Fornecedor(Long id, String cnpj, String nomeFantasia, Contato contato, Endereco endereco) {
		super(contato, endereco);
		this.id = id;
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		isValid();
	}

	public Long getId() {
		return id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}
}
