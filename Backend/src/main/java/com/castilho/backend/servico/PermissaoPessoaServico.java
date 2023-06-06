package com.castilho.backend.servico;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castilho.backend.entidade.Permissao;
import com.castilho.backend.entidade.PermissaoPessoa;
import com.castilho.backend.entidade.Pessoa;
import com.castilho.backend.repositorio.PermissaoPessoaRepositorio;
import com.castilho.backend.repositorio.PermissaoRepositorio;

@Service
public class PermissaoPessoaServico {
    
    @Autowired
    private PermissaoPessoaRepositorio permissaoPessoaRepositorio;
    @Autowired
    private PermissaoRepositorio permissaoRepositorio;

    public void vincularPermissao(Pessoa pessoa) {
        List<Permissao> listaPermissoes = permissaoRepositorio.findByNome("cliente");
        if (listaPermissoes.size() > 0) {
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissoes.get(0));
        }
    }

    public List<PermissaoPessoa> listarTodos(){
        return permissaoPessoaRepositorio.findAll();
    }

    public PermissaoPessoa inserir(PermissaoPessoa permissaoPessoa){
        permissaoPessoa.setDataCriacao(new Date());
        PermissaoPessoa permissaoPessoaNova = permissaoPessoaRepositorio.saveAndFlush(permissaoPessoa);
        return permissaoPessoaNova;
    }

    public PermissaoPessoa atualizar(PermissaoPessoa permissaoPessoa){
        permissaoPessoa.setDataAtualizacao((new Date()));
        PermissaoPessoa permissaoPessoaAtualizada = permissaoPessoaRepositorio.saveAndFlush(permissaoPessoa);
        return permissaoPessoaAtualizada;
    }

    public void excluir(Long id){
        PermissaoPessoa permissaoPessoa = permissaoPessoaRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Permissão pessoa não encontrada."));
        permissaoPessoaRepositorio.delete(permissaoPessoa);
    }
}
