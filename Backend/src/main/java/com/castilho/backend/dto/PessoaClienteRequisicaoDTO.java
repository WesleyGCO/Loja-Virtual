package com.castilho.backend.dto;

import org.springframework.beans.BeanUtils;
import lombok.Data;

import com.castilho.backend.entidade.Cidade;
import com.castilho.backend.entidade.Pessoa;

@Data
public class PessoaClienteRequisicaoDTO{
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private Cidade cidade;

    public Pessoa converter(PessoaClienteRequisicaoDTO pessoaClienteRequisicaoDTO){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClienteRequisicaoDTO, pessoa);
        return pessoa;
    }
}