package model;

public class Posicion {
    private String tipoTuberia;
    private Posicion casillaPrevia;
    private Posicion casillaSiguiente;

    private int posicionFila;
    private int posicionColumna;
    public Posicion(String tipoTuberia, Posicion casillaPrevia, Posicion casillaSiguiente,int posicionColumna,int posicionFila) {
        this.tipoTuberia = tipoTuberia;
        this.casillaPrevia = casillaPrevia;
        this.casillaSiguiente = casillaSiguiente;
        this.posicionColumna = posicionColumna;
        this.posicionFila = posicionFila;

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

    public int getPosicionFila() {
        return posicionFila;
    }

    public void setPosicionFila(int posicionFila) {
        this.posicionFila = posicionFila;
    }

    public int getPosicionColumna() {
        return posicionColumna;
    }

    public void setPosicionColumna(int posicionColumna) {
        this.posicionColumna = posicionColumna;
    }
}
