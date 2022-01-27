package com.ecommerce.dominio;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@NotNull(message = "CNPJ nao pode ser null")
	@NotBlank(message = "CNPJ nao pode ser vazio")
	@Size(max = 20, message = "CNPJ pode ter no maximo 20 caracters")
	private String cnpj;

	@NotNull(message = "Nome fantasia nao pode ser null")
	@NotBlank(message = "Nome fantasia nao pode ser vazio")
	@Size(max = 100, message = "Nome fantasia pode ter no maximo 100 caracters")
	private String nomeFantasia;

	// este construtor eh para uso de sping / jackson
	@Deprecated
	public Fornecedor() {
	}
	
	public Fornecedor(String id, String cnpj, String nomeFantasia, Contato contato, Endereco endereco) {
		super(contato, endereco);
		this.id = id;
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}

	public String getId() {
		return id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}
}
