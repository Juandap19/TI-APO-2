package model;

public class Jugador {
    private int puntaje;
    private String nombre;

    private Jugador left;
    private Jugador right;


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

    public Jugador getLeft() {
        return left;
    }

    public void setLeft(Jugador left) {
        this.left = left;
    }

    public Jugador getRight() {
        return right;
    }

    public void setRight(Jugador right) {
        this.right = right;
    }
}
