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
public class Cliente extends Pessoa {

	@Id
	@Column(name = "idCliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "CPF nao pode ser vazio")
	@NotBlank(message = "CPF nao pode ser vazio")
	@Size(max = 20, message = "CPF pode ter no maximo 20 caracters")
	private String cpfCliente;

	@NotNull(message = "nome do cliente nao pode ser vazio")
	@NotBlank(message = "nome do cliente nao pode ser vazio")
	@Size(max = 100, message = "nome do cliente pode ter no maximo 100 caracters")
	private String nomeCliente;

	// este construtor eh para uso de sping / jackson
	@Deprecated
	public Cliente() {
	}
	
	public Cliente(Long id, String cpfCliente, String nomeCliente, Contato contato, Endereco endereco) {
		super(contato, endereco);
		this.id = id;
		this.cpfCliente = cpfCliente;
		this.nomeCliente = nomeCliente;
		isValid();
	}

	public Long getId() {
		return id;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
}
