package com.navita.exam.patrimonio;

import com.navita.exam.marca.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {

    List<Patrimonio> findByMarca(Marca marca);

    Patrimonio findByNumeroTombo(Integer numeroTombo);

    @Query("SELECT MAX(p.numeroTombo) from Patrimonio p")
    Integer findMaxNumeroTombo();
}
