package com.ecommerce.infra.excecoes;

public abstract class ExcecaoDeNegocio extends RuntimeException {
	
	public ExcecaoDeNegocio (String mensagens) {
		super(mensagens);
	}
}
