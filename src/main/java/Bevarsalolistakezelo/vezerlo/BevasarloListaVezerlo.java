package Bevarsalolistakezelo.vezerlo;

import Bevarsalolistakezelo.entitas.BevasarloLista;
import Bevarsalolistakezelo.entitas.Tetel;
import Bevarsalolistakezelo.keres.BevasarloListaKeres;
import Bevarsalolistakezelo.szolgaltatas.BevasarloListaSzolgaltatas;
import Bevarsalolistakezelo.szolgaltatas.TetelSzolgaltatas;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/listak")
public class BevasarloListaVezerlo {

    private final BevasarloListaSzolgaltatas bevasarloListaSzolgaltatas;
    private final TetelSzolgaltatas tetelSzolgaltatas;

    public BevasarloListaVezerlo(BevasarloListaSzolgaltatas bevasarloListaSzolgaltatas,
                                 TetelSzolgaltatas tetelSzolgaltatas) {
        this.bevasarloListaSzolgaltatas = bevasarloListaSzolgaltatas;
        this.tetelSzolgaltatas = tetelSzolgaltatas;
    }

    @GetMapping
    public List<BevasarloLista> osszesLista() {
        return bevasarloListaSzolgaltatas.osszesLista();
    }

    @GetMapping("/{azonosito}")
    public BevasarloLista egyLista(@PathVariable Long azonosito) {
        return bevasarloListaSzolgaltatas.egyLista(azonosito);
    }

    @GetMapping("/{azonosito}/tetelek")
    public List<Tetel> listaTetelei(@PathVariable Long azonosito) {
        return tetelSzolgaltatas.listaTetelei(azonosito);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BevasarloLista ujLista(@Valid @RequestBody BevasarloListaKeres keres) {
        return bevasarloListaSzolgaltatas.ujLista(keres);
    }

    @PutMapping("/{azonosito}")
    public BevasarloLista listaModositasa(@PathVariable Long azonosito,
                                          @Valid @RequestBody BevasarloListaKeres keres) {
        return bevasarloListaSzolgaltatas.listaModositasa(azonosito, keres);
    }

    @DeleteMapping("/{azonosito}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void listaTorlese(@PathVariable Long azonosito) {
        bevasarloListaSzolgaltatas.listaTorlese(azonosito);
    }
}
