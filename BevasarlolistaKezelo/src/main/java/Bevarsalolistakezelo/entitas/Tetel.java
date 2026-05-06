package Bevarsalolistakezelo.entitas;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Tetel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long azonosito;

    @NotBlank(message = "A tetel neve nem lehet ures")
    private String megnevezes;

    @NotNull(message = "A mennyiseg kotelezo")
    @Min(value = 1, message = "A mennyiseg legalabb 1 legyen")
    private Integer mennyiseg;

    private boolean bevasarolt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "lista_azonosito")
    private BevasarloLista bevasarloLista;

    public Long getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(Long azonosito) {
        this.azonosito = azonosito;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    public Integer getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(Integer mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public boolean isBevasarolt() {
        return bevasarolt;
    }

    public void setBevasarolt(boolean bevasarolt) {
        this.bevasarolt = bevasarolt;
    }

    public BevasarloLista getBevasarloLista() {
        return bevasarloLista;
    }

    public void setBevasarloLista(BevasarloLista bevasarloLista) {
        this.bevasarloLista = bevasarloLista;
    }
}
