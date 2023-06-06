package com.castilho.backend.servico;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castilho.backend.entidade.CarrinhoCompra;
import com.castilho.backend.repositorio.CarrinhoCompraRepositorio;

@Service
public class CarrinhoCompraServico {
    
    @Autowired
    private CarrinhoCompraRepositorio carrinhoCompraRepositorio;

    public List<CarrinhoCompra> listarTodos(){
        return carrinhoCompraRepositorio.findAll();
    }

    public CarrinhoCompra inserir(CarrinhoCompra carrinhoCompra){
        carrinhoCompra.setDataCompra(new Date());
        CarrinhoCompra carrinhoCompraNovo = carrinhoCompraRepositorio.saveAndFlush(carrinhoCompra);
        return carrinhoCompraNovo;
    }

    public CarrinhoCompra atualizar(CarrinhoCompra carrinhoCompra){
        carrinhoCompra.setDataAtualizacao(new Date());
        CarrinhoCompra carrinhoCompraAtualizado = carrinhoCompraRepositorio.saveAndFlush(carrinhoCompra);
        return carrinhoCompraAtualizado;
    }

    public void excluir(Long id){
        CarrinhoCompra carrinhoCompra = carrinhoCompraRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Compra de carrinho não encontrada."));
        carrinhoCompraRepositorio.delete(carrinhoCompra);
    }
}
