package com.navita.exam.patrimonio;

import com.navita.exam.marca.Exception.MarcaNotFounException;
import com.navita.exam.marca.Marca;
import com.navita.exam.patrimonio.service.PatrimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patrimonio")
public class PatrimonioRestController {
    @Autowired
    private PatrimonioService patrimonioService;

    @GetMapping
    public List<Patrimonio> findAll() {
        return patrimonioService.findAll();
    }

    @GetMapping("{marca}")
    public List<Patrimonio> findAll(@PathVariable Marca marca) throws MarcaNotFounException {
        if (marca == null) {
            throw new MarcaNotFounException();
        }

        return patrimonioService.findByMarca(marca);
    }

    @PostMapping
    public Patrimonio create(@RequestBody PatrimonioDto patrimonioDto) throws Exception {

        return patrimonioService.create(patrimonioDto);
    }

    @PutMapping("{patrimonio}")
    public Patrimonio Update(@PathVariable Patrimonio patrimonio, @RequestBody PatrimonioDto patrimonioDto) throws Exception {

        return patrimonioService.update(patrimonio, patrimonioDto);
    }

    @DeleteMapping("{patrimonio}")
    public void delete(@PathVariable Patrimonio patrimonio) {
        patrimonioService.delete(patrimonio);
    }
}
