package Bevarsalolistakezelo.keres;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TetelKeres {

    @NotBlank(message = "A tetel neve nem lehet ures")
    private String megnevezes;

    @NotNull(message = "A mennyiseg kotelezo")
    @Min(value = 1, message = "A mennyiseg legalabb 1 legyen")
    private Integer mennyiseg;

    private boolean bevasarolt;

    @NotNull(message = "A lista azonosito kotelezo")
    private Long listaAzonosito;

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

    public Long getListaAzonosito() {
        return listaAzonosito;
    }

    public void setListaAzonosito(Long listaAzonosito) {
        this.listaAzonosito = listaAzonosito;
    }
}
