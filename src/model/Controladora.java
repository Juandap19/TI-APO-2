package model;

public class Controladora {
    private Tablero tablero;
    public Controladora() {
    }

    public String nuevaPartida(String nombreJugador) {
        tablero = new Tablero(null,null,null);
        tablero.generarNuevaPartida(nombreJugador);
        String message = tablero.showAll();
        return  message;
    }

    public String ponerTuberia(int columna,int fila,String tipoTuberia){
    tablero.ponerTuberia(columna, fila, tipoTuberia);
    String mensaje = tablero.showAll();
    return  mensaje;


    }
}