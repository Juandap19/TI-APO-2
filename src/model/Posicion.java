package model;

public class Posicion {
    private String tipoTuberia;
    private Posicion casillaPrevia;
    private Posicion casillaSiguiente;

    public Posicion(String tipoTuberia, Posicion casillaPrevia, Posicion casillaSiguiente) {
        this.tipoTuberia = tipoTuberia;
        this.casillaPrevia = casillaPrevia;
        this.casillaSiguiente = casillaSiguiente;
    }

    public String getTipoTuberia() {
        return tipoTuberia;
    }

    public void setTipoTuberia(String tipoTuberia) {
        this.tipoTuberia = tipoTuberia;
    }

    public Posicion getCasillaPrevia() {
        return casillaPrevia;
    }

    public void setCasillaPrevia(Posicion casillaPrevia) {
        this.casillaPrevia = casillaPrevia;
    }

    public Posicion getCasillaSiguiente() {
        return casillaSiguiente;
    }

    public void setCasillaSiguiente(Posicion casillaSiguiente) {
        this.casillaSiguiente = casillaSiguiente;
    }
}
