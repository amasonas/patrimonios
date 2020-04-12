package com.navita.exam.marca.service;

import com.navita.exam.marca.Exception.MarcaNotFounException;
import com.navita.exam.marca.Marca;
import com.navita.exam.marca.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Marca save(@RequestBody Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca findById(Long id) throws MarcaNotFounException {
        return marcaRepository.findById(id).orElseThrow(() -> new MarcaNotFounException(id));
    }

    @Override
    public Marca update(Marca marca, Marca marcaAtualizada) {

        marca.setNome(marcaAtualizada.getNome());

        return marcaRepository.save(marca);
    }

    @Override
    public void delete(Marca marca) {
        marcaRepository.delete(marca);
    }

    @Override
    public List<Marca> findAll() {
        return marcaRepository.findAll();
    }
}
