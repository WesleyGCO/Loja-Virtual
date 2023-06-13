package com.castilho.backend.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErroValidacaoObjeto {
    private String mensagem;
    private String campo;
    private Object valorEnviado;
}
