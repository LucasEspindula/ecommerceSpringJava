package com.ecommerce.dominio;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Pessoa {
	
	@NotNull(message = "contato nao pode ser null")
	@NotBlank(message = "contato nao pode ser vazio")
	private Contato contato;

	@NotNull(message = "endereco nao pode ser null")
	@NotBlank(message = "endereco nao pode ser vazio")
	private Endereco endereco;
	
	// este construtor eh para uso de sping / jackson
	@Deprecated
	public Pessoa() {
	}
	
	public Pessoa(Contato contato, Endereco endereco) {
		this.contato = contato;
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}
}
