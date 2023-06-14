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

    @NotBlank(message = "{nome.not.blank}")
    private String nome;

    @Size(min = 2, max = 250)
    @NotBlank(message = "{descricao.not.blank}")
    @Column(name = "descricaoLonga")
    private String descricaoLonga;

    @NotBlank(message = "{valorCusto.not.blank}")
    @Column(name = "valorCusto")
    private double valorCusto;

    @NotBlank(message = "{valorVenda.not.blank}")
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
