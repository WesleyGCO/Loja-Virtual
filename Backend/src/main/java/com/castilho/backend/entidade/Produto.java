package com.castilho.backend.entidade;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    @Size(min = 2, max = 250, message = "O campo descrição longa deve ter entre 2 e 250 caracteres")
    @Column(name = "descricaoLonga")
    private String descricaoLonga;

    @NotBlank(message = "O valor custo não pode ficar vazio")
    @Column(name = "valorCusto")
    private double valorCusto;

    @NotBlank(message = "O valor venda não pode ficar vazio")
    @Column(name = "valorVenda")
    private double valorVenda;

    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "fk_marca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "fk_categoria")
    private Categoria categoria;
}
