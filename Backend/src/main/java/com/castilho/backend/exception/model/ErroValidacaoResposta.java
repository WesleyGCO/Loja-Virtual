package com.castilho.backend.exception.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErroValidacaoResposta {
    private String mensagem;
    private int codigo;
    private String status;
    private String nomeObjeto;
    private List<ErroValidacaoObjeto> erros;
}
