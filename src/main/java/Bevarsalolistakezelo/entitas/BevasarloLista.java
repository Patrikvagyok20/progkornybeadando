package Bevarsalolistakezelo.entitas;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class BevasarloLista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long azonosito;

    @NotBlank(message = "A lista neve nem lehet ures")
    private String nev;

    @JsonManagedReference
    @OneToMany(mappedBy = "bevasarloLista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tetel> tetelek = new ArrayList<>();

    public Long getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(Long azonosito) {
        this.azonosito = azonosito;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public List<Tetel> getTetelek() {
        return tetelek;
    }

    public void setTetelek(List<Tetel> tetelek) {
        this.tetelek = tetelek;
    }
}
