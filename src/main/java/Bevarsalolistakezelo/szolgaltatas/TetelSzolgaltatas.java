package Bevarsalolistakezelo.szolgaltatas;

import Bevarsalolistakezelo.entitas.BevasarloLista;
import Bevarsalolistakezelo.entitas.Tetel;
import Bevarsalolistakezelo.keres.TetelKeres;
import Bevarsalolistakezelo.tarolo.BevasarloListaTarolo;
import Bevarsalolistakezelo.tarolo.TetelTarolo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TetelSzolgaltatas {

    private final TetelTarolo tetelTarolo;
    private final BevasarloListaTarolo bevasarloListaTarolo;

    public TetelSzolgaltatas(TetelTarolo tetelTarolo, BevasarloListaTarolo bevasarloListaTarolo) {
        this.tetelTarolo = tetelTarolo;
        this.bevasarloListaTarolo = bevasarloListaTarolo;
    }

    public List<Tetel> osszesTetel() {
        return tetelTarolo.findAll();
    }

    public Tetel egyTetel(Long azonosito) {
        return tetelTarolo.findById(azonosito)
                .orElseThrow(() -> new RuntimeException("Nincs ilyen tetel: " + azonosito));
    }

    public List<Tetel> listaTetelei(Long listaAzonosito) {
        return tetelTarolo.findByBevasarloListaAzonosito(listaAzonosito);
    }

    public Tetel ujTetel(TetelKeres keres) {
        BevasarloLista bevasarloLista = bevasarloListaTarolo.findById(keres.getListaAzonosito())
                .orElseThrow(() -> new RuntimeException("Nincs ilyen bevasarlolista: " + keres.getListaAzonosito()));

        Tetel tetel = new Tetel();
        tetel.setMegnevezes(keres.getMegnevezes());
        tetel.setMennyiseg(keres.getMennyiseg());
        tetel.setBevasarolt(keres.isBevasarolt());
        tetel.setBevasarloLista(bevasarloLista);

        return tetelTarolo.save(tetel);
    }

    public Tetel tetelModositasa(Long azonosito, TetelKeres keres) {
        Tetel tetel = egyTetel(azonosito);
        BevasarloLista bevasarloLista = bevasarloListaTarolo.findById(keres.getListaAzonosito())
                .orElseThrow(() -> new RuntimeException("Nincs ilyen bevasarlolista: " + keres.getListaAzonosito()));

        tetel.setMegnevezes(keres.getMegnevezes());
        tetel.setMennyiseg(keres.getMennyiseg());
        tetel.setBevasarolt(keres.isBevasarolt());
        tetel.setBevasarloLista(bevasarloLista);

        return tetelTarolo.save(tetel);
    }

    public void tetelTorlese(Long azonosito) {
        Tetel tetel = egyTetel(azonosito);
        tetelTarolo.delete(tetel);
    }
}
