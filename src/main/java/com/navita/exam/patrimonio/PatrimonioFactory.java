package com.navita.exam.patrimonio;

import com.navita.exam.marca.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatrimonioFactory {
    @Autowired
    private MarcaService marcaService;

    public Patrimonio create(PatrimonioDto dto) throws Exception {
        Patrimonio patrimonio = new Patrimonio();

        patrimonio.setId(dto.getId());
        patrimonio.setDescricao(dto.getDescricao());
        patrimonio.setNome(dto.getNome());
        patrimonio.setMarca(marcaService.findById(dto.getMarca()));
        patrimonio.setNumeroTombo(dto.getNumeroTombo());

        return patrimonio;
    }
}
