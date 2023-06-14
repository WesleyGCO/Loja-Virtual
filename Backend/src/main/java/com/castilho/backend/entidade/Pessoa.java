package com.castilho.backend.entidade;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Table(name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{nome.not.blank}")
    private String nome;

    @NotBlank(message = "{cpf.not.blank}")
    @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "O CPF deve estar no formato 000.000.000-00")
    @Column(name = "cpf")
    private String cpf;

    @Email(message = "O email é inválido")
    @NotBlank(message = "{email.not.blank}")
    @Column(name = "email")
    private String email;

    @Size(min = 5, max = 20)
    @NotBlank(message = "{senha.not.blank}")
    @Column(name = "senha")
    private String senha;

    @NotBlank(message = "{endereco.not.blank}")
    @Column(name = "endereco")
    private String endereco;

    @NotBlank(message = "{cep.not.blank}")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 00000-000")
    @Column(name = "cep")
    private String cep;

    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "data_atualizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "fk_cidade") // Muda o nome da FK
    private Cidade cidade;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = {jakarta.persistence.CascadeType.PERSIST, jakarta.persistence.CascadeType.MERGE})
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoa;

    public void setPermissaoPessoa(List<PermissaoPessoa> pp){
        for(PermissaoPessoa p:pp){
            p.setPessoa(this);
        }
        this.permissaoPessoa = pp;
    }
}
