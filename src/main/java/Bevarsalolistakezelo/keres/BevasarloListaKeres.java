package Bevarsalolistakezelo.keres;

import jakarta.validation.constraints.NotBlank;

public class BevasarloListaKeres {

    @NotBlank(message = "A lista neve nem lehet ures")
    private String nev;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
}
