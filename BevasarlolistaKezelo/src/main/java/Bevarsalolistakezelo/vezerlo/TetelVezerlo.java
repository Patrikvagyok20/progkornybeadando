package Bevarsalolistakezelo.vezerlo;

import Bevarsalolistakezelo.entitas.Tetel;
import Bevarsalolistakezelo.keres.TetelKeres;
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
@RequestMapping("/tetelek")
public class TetelVezerlo {

    private final TetelSzolgaltatas tetelSzolgaltatas;

    public TetelVezerlo(TetelSzolgaltatas tetelSzolgaltatas) {
        this.tetelSzolgaltatas = tetelSzolgaltatas;
    }

    @GetMapping
    public List<Tetel> osszesTetel() {
        return tetelSzolgaltatas.osszesTetel();
    }

    @GetMapping("/{azonosito}")
    public Tetel egyTetel(@PathVariable Long azonosito) {
        return tetelSzolgaltatas.egyTetel(azonosito);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tetel ujTetel(@Valid @RequestBody TetelKeres keres) {
        return tetelSzolgaltatas.ujTetel(keres);
    }

    @PutMapping("/{azonosito}")
    public Tetel tetelModositasa(@PathVariable Long azonosito,
                                 @Valid @RequestBody TetelKeres keres) {
        return tetelSzolgaltatas.tetelModositasa(azonosito, keres);
    }

    @DeleteMapping("/{azonosito}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void tetelTorlese(@PathVariable Long azonosito) {
        tetelSzolgaltatas.tetelTorlese(azonosito);
    }
}
