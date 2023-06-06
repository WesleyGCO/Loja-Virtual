package com.castilho.backend.servico;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castilho.backend.dto.PessoaClienteRequisicaoDTO;
import com.castilho.backend.repositorio.PessoaClienteRepositorio;
import com.castilho.backend.entidade.Pessoa;

@Service
public class PessoaClienteServico {
    
    @Autowired
    private PessoaClienteRepositorio pessoaClienteRepositorio;

    @Autowired
    private PermissaoPessoaServico permissaoPessoaServico;

    public Pessoa registrar(PessoaClienteRequisicaoDTO pessoaClienteRequisicaoDTO){
        Pessoa pessoa = new PessoaClienteRequisicaoDTO().converter(pessoaClienteRequisicaoDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaClienteRepositorio.saveAndFlush(pessoa);
        permissaoPessoaServico.vincularPermissao(pessoaNova);

        return pessoaNova;
    }
}
