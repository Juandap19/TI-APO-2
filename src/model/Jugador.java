package model;

public class Jugador {
    private int puntaje;
    private String nombre;


    public Jugador(int puntaje, String nombre) {
        this.puntaje = puntaje;
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
