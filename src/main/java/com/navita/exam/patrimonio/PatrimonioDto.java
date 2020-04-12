package com.navita.exam.patrimonio;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PatrimonioDto {
    private long id;
    private long marca;

    private String descricao;

    @NotNull
    private String nome;

    private Integer numeroTombo;
}
