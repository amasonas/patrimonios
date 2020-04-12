package com.navita.exam.marca.service;

import com.navita.exam.marca.Exception.MarcaNotFounException;
import com.navita.exam.marca.Marca;

import java.util.List;

public interface MarcaService {
    Marca save(Marca marca);

    Marca findById(Long id) throws MarcaNotFounException;

    Marca update(Marca marca, Marca marcaAtualizada);

    void delete(Marca marca);

    List<Marca> findAll();
}
