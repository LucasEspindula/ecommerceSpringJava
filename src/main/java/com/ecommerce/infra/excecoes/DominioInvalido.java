package com.ecommerce.infra.excecoes;

import java.util.Set;

public class DominioInvalido extends ExcecaoDeNegocio {

    public DominioInvalido(Set<String> mensagens) {
        super(mensagens.toString());
    }

    public DominioInvalido(String mensagem) {
        super(mensagem);
    }
}
