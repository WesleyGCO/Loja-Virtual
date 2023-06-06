package com.castilho.backend.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "carrinhoCompraProduto")
public class CarrinhoCompraProduto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor")
    private double valor;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
