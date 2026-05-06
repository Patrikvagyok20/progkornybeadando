package Bevarsalolistakezelo.tarolo;

import Bevarsalolistakezelo.entitas.Tetel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TetelTarolo extends JpaRepository<Tetel, Long> {
    List<Tetel> findByBevasarloListaAzonosito(Long listaAzonosito);
}
