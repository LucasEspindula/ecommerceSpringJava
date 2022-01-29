package com.ecommerce.dominio;

import javax.validation.*;

import com.ecommerce.infra.excecoes.DominioInvalido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public abstract  class Entidade {

    void isValid() {
        Configuration<?> configuracaoes = Validation.byDefaultProvider().configure();
        ValidatorFactory fabrica = configuracaoes.buildValidatorFactory();
        Validator validador = fabrica.getValidator();
        Set<ConstraintViolation<Entidade>> regrasVioladas = validador.validate(this);

        Set<String> mensagens = new HashSet<>();

        for (ConstraintViolation<Entidade> constraintViolation : regrasVioladas) {
            String campo = constraintViolation.getPropertyPath().toString();
            String msg = constraintViolation.getMessage();
            mensagens.add(campo.concat(" : ").concat(msg));
        }

        if (!mensagens.isEmpty()) {
        	List<String> mensagensOrdenadas = new ArrayList<>(mensagens);
        	Collections.sort(mensagensOrdenadas);
            throw new DominioInvalido(mensagensOrdenadas.toString());
        }
    }
}
