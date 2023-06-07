package com.castilho.backend.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castilho.backend.dto.PessoaClienteRequisicaoDTO;

import com.castilho.backend.entidade.Pessoa;
import com.castilho.backend.servico.PessoaClienteServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoaCliente")
@CrossOrigin
public class PessoaClienteControle {
    
    @Autowired
    private PessoaClienteServico pessoaClienteServico;

    @PostMapping("/")
    public Pessoa inserir(@Valid @RequestBody PessoaClienteRequisicaoDTO pessoaClienteRequisicaoDTO){
        return pessoaClienteServico.registrar(pessoaClienteRequisicaoDTO);
    }
}
