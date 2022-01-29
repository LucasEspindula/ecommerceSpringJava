package com.ecommerce.dominio;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Contato {
	
	@NotNull(message = "e-mail nao pode ser vazio")
	@NotBlank(message = "e-mail nao pode ser vazio")
	@Size(max = 100, message = "e-mail pode ter no maximo 100 caracters")
	private String email;
	
	@NotNull(message = "telefone nao pode ser vazio")
	@NotBlank(message = "telefone nao pode ser vazio")
	@Size(max = 20, message = "telefone pode ter no maximo 20 caracters")
	private String telefone;

	// este construtor eh para uso de sping / jackson
	@Deprecated
	public Contato() {
	}
	
	public Contato(String email, String telefone) {
		this.email = email;
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}
}
