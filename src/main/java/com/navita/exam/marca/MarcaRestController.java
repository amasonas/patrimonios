package com.navita.exam.marca;

import com.navita.exam.marca.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("marca")
public class MarcaRestController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public List<Marca> findAll() {
        return marcaService.findAll();
    }

    @PostMapping
    public Marca create(@RequestBody Marca marca) {
        return marcaService.save(marca);
    }

    @PutMapping("{marca}")
    public Marca update(@PathVariable Marca marca, @RequestBody Marca marcaAtualizada) {
        return marcaService.update(marca, marcaAtualizada);
    }

    @DeleteMapping("{marca}")
    public void delete(@PathVariable Marca marca) {
        marcaService.delete(marca);
    }
}
