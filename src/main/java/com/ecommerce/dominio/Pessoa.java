package com.ecommerce.dominio;

import javax.persistence.MappedSuperclass;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Pessoa extends Entidade {
	
	@Valid
	@NotNull(message = "contato nao pode ser vazio")
	private Contato contato;

	@Valid
	@NotNull(message = "endereco nao pode ser vazio")
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
