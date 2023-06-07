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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "carrinhoCompraProduto")
public class CarrinhoCompraProduto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo valor não pode ficar vazio")
    @Column(name = "valor")
    private double valor;

    @NotBlank(message = "O campo quantidade não pode ficar vazio")
    @Column(name = "quantidade")
    private int quantidade;

    @Size(min = 2, max = 250, message = "O campo observação deve ter entre 2 e 250 caracteres")
    @Column(name = "observacao")
    private String observacao;

    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
}
