package com.navita.exam.patrimonio.service;

import com.navita.exam.marca.Marca;
import com.navita.exam.patrimonio.Patrimonio;
import com.navita.exam.patrimonio.PatrimonioDto;
import com.navita.exam.patrimonio.PatrimonioFactory;
import com.navita.exam.patrimonio.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class PatrimonioServiceImpl implements PatrimonioService {

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Autowired
    private PatrimonioFactory patrimonioFactory;

    @Override
    public Patrimonio create(@Valid PatrimonioDto patrimonioDto) throws Exception {

        Patrimonio patrimonio = patrimonioFactory.create(patrimonioDto);
        patrimonio.setNumeroTombo(gerarNumeroPatrimonio());

        return patrimonioRepository.save(patrimonio);
    }

    @Override
    public void delete(Patrimonio patrimonio) {
        patrimonioRepository.delete(patrimonio);
    }

    @Override
    public List<Patrimonio> findAll() {
        return patrimonioRepository.findAll();
    }

    @Override
    public List<Patrimonio> findByMarca(Marca marca) {
        return patrimonioRepository.findByMarca(marca);
    }

    @Override
    public Patrimonio update(Patrimonio patrimonio, PatrimonioDto patrimonioAtualizadoDto) throws Exception {

        Patrimonio patrimonioAtualizado = patrimonioFactory.create(patrimonioAtualizadoDto);

        patrimonio.setMarca(patrimonioAtualizado.getMarca());
        patrimonio.setNome(patrimonioAtualizado.getNome());
        patrimonio.setDescricao(patrimonioAtualizado.getDescricao());

        return patrimonioRepository.save(patrimonio);
    }

    private Integer gerarNumeroPatrimonio() {
        Integer currentMax = patrimonioRepository.findMaxNumeroTombo();

        if (currentMax == null) {
            currentMax = 0;
        }

        return currentMax + 1;
    }
}
