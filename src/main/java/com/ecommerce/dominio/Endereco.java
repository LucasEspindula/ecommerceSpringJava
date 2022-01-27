package com.ecommerce.dominio;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Endereco {

	@NotNull(message = "rua nao pode ser null")
	@NotBlank(message = "rua nao pode ser vazio")
	@Size(max = 100, message = "rua pode ter no maximo 100 caracters")
	private String rua;

	@NotNull(message = "numero nao pode ser null")
	@NotBlank(message = "numero nao pode ser vazio")
	@Size(max = 6, message = "numero pode ter no maximo 6 caracters")
	private String numero;

	@NotNull(message = "bairro nao pode ser null")
	@NotBlank(message = "bairro nao pode ser vazio")
	@Size(max = 50, message = "bairro pode ter no maximo 50 caracters")
	private String bairro;

	@NotNull(message = "complemento nao pode ser null")
	@NotBlank(message = "complemento nao pode ser vazio")
	@Size(max = 120, message = "complemento pode ter no maximo 120 caracters")
	private String complemento;

	@NotNull(message = "Cep nao pode ser null")
	@NotBlank(message = "Cep nao pode ser vazio")
	@Size(max = 10, message = "Cep pode ter no maximo 10 caracters")
	private String cep;

	@NotNull(message = "cidade nao pode ser null")
	@NotBlank(message = "cidade nao pode ser vazio")
	@Size(max = 50, message = "cidade pode ter no maximo 50 caracters")
	private String cidade;

	@NotNull(message = "estado nao pode ser null")
	@NotBlank(message = "estado nao pode ser vazio")
	@Size(max = 2, message = "estado pode ter no maximo 2 caracters")
	private String estado;

	// este construtor eh para uso de sping / jackson
	@Deprecated
	public Endereco() {
	}
	
	public Endereco(String rua, String numero, String bairro, String complemento, String cep, String cidade,
			String estado) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
}
