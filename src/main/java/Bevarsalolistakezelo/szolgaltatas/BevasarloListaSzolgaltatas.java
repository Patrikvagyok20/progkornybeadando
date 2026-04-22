package Bevarsalolistakezelo.szolgaltatas;

import Bevarsalolistakezelo.entitas.BevasarloLista;
import Bevarsalolistakezelo.keres.BevasarloListaKeres;
import Bevarsalolistakezelo.tarolo.BevasarloListaTarolo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BevasarloListaSzolgaltatas {

    private final BevasarloListaTarolo bevasarloListaTarolo;

    public BevasarloListaSzolgaltatas(BevasarloListaTarolo bevasarloListaTarolo) {
        this.bevasarloListaTarolo = bevasarloListaTarolo;
    }

    public List<BevasarloLista> osszesLista() {
        return bevasarloListaTarolo.findAll();
    }

    public BevasarloLista egyLista(Long azonosito) {
        return bevasarloListaTarolo.findById(azonosito)
                .orElseThrow(() -> new RuntimeException("Nincs ilyen bevasarlolista: " + azonosito));
    }

    public BevasarloLista ujLista(BevasarloListaKeres keres) {
        BevasarloLista bevasarloLista = new BevasarloLista();
        bevasarloLista.setNev(keres.getNev());
        return bevasarloListaTarolo.save(bevasarloLista);
    }

    public BevasarloLista listaModositasa(Long azonosito, BevasarloListaKeres keres) {
        BevasarloLista bevasarloLista = egyLista(azonosito);
        bevasarloLista.setNev(keres.getNev());
        return bevasarloListaTarolo.save(bevasarloLista);
    }

    public void listaTorlese(Long azonosito) {
        BevasarloLista bevasarloLista = egyLista(azonosito);
        bevasarloListaTarolo.delete(bevasarloLista);
    }
}
