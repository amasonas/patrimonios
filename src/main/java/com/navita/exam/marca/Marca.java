package com.navita.exam.marca;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.navita.exam.patrimonio.Patrimonio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Marca {

    @JsonIgnore
    @OneToMany(mappedBy = "marca")
    List<Patrimonio> patrimonios;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(unique = true)
    private String nome;
}
