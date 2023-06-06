package com.castilho.backend.controle;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castilho.backend.entidade.CarrinhoCompra;
import com.castilho.backend.servico.CarrinhoCompraServico;


@RestController
@RequestMapping("/carrinhoCompra")
@CrossOrigin
public class CarrinhoCompraControle {
    @Autowired
    private CarrinhoCompraServico carrinhoCompraServico;

    // localhost:8080/carrinhoCompra/ - com verbo get
    @GetMapping("/")
    public List<CarrinhoCompra> listarTodos(){
        return carrinhoCompraServico.listarTodos();
    }

    // localhost:8080/carrinhoCompra/ - com verbo post
    @PostMapping("/")
    public CarrinhoCompra inserir(@RequestBody CarrinhoCompra carrinhoCompra) {
        return carrinhoCompraServico.inserir(carrinhoCompra);
    }

    @PutMapping("/")
    public CarrinhoCompra atualizar(@RequestBody CarrinhoCompra carrinhoCompra) {
        return carrinhoCompraServico.atualizar(carrinhoCompra);
    }

    // localhost:8080/carrinhoCompra/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCarrinhoCompra(@PathVariable Long id) {
        try {
            carrinhoCompraServico.excluir(id);
            return ResponseEntity.ok("Carrinho de compra excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
