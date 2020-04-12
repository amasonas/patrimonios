package com.navita.exam.patrimonio;

import com.navita.exam.marca.Marca;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class Patrimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descricao;

    @Column(nullable = false)
    private String nome;

    private Integer numeroTombo;

    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = true)
    private Marca marca;
}
