package com.navita.exam.usuario;

import com.navita.exam.role.Role;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean ativo;

    @Column(unique = true)
    private String email;

    @NotNull(message = "O campo nome deve ser informado")
    private String nome;

    @NotNull(message = "O campo senha deve ser informado")
    @Length(min = 6, message = "O campo senha deve ter no mínimo 6 dígitos")
    private String senha;

    @ManyToMany
    @JoinTable(
            name = "role_usuario",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
}
