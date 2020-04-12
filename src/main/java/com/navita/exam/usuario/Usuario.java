package com.navita.exam.usuario;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String email;

    @NotNull(message = "O campo nome deve ser informado")
    private String nome;

    @NotNull(message = "O campo senha deve ser informado")
    @Length(min = 6, message = "O campo senha deve ter no mínimo 6 dígitos")
    private String senha;

    private boolean ativo;
}
