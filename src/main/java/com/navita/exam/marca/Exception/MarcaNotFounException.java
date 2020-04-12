package com.navita.exam.marca.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MarcaNotFounException extends Exception {

    public MarcaNotFounException() {
        super("A marca referenciada não foi encontrada");
    }

    public MarcaNotFounException(Long id) {
        super("A marca com o id " + id + " não foi encontrada");
    }
}
