package com.navita.exam.patrimonio.service;

import com.navita.exam.marca.Marca;
import com.navita.exam.patrimonio.Patrimonio;
import com.navita.exam.patrimonio.PatrimonioDto;

import javax.validation.Valid;
import java.util.List;

public interface PatrimonioService {

    Patrimonio create(@Valid PatrimonioDto patrimonio) throws Exception;

    void delete(Patrimonio patrimonio);

    List<Patrimonio> findAll();

    List<Patrimonio> findByMarca(Marca marca);

    Patrimonio update(Patrimonio patrimonio, PatrimonioDto patrimonioAtualizado) throws Exception;
}
