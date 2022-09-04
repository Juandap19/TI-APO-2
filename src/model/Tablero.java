package model;

import java.util.Random;

public class Tablero {
    private Posicion inicio;
    private Posicion final1;
    private Jugador jugadorActual;

    public Tablero(Posicion inicio, Posicion final1, Jugador jugadorActual) {
        this.inicio = inicio;
        this.final1 = final1;
        this.jugadorActual = jugadorActual;
    }
    public void generarNuevaPartida(String name){
        Jugador nuevoJugador = new Jugador(0,name);
        jugadorActual = nuevoJugador;
        Random numAleatorio = new Random();
        int numberF = numAleatorio.nextInt(15-5+1) + 5;
        int numberD = numAleatorio.nextInt(50-38+1) + 38;
        int posicionFila = 0;
        int posicionColumna = 0;
        for (int i = 0; i < 64; i++) {
            if(numberF == i){
                generarPosiciones("F",posicionColumna,posicionFila);
            }else if(numberD == i){
                generarPosiciones("D",posicionColumna,posicionFila);
            }else{
                generarPosiciones("x",posicionColumna,posicionFila);
            }
            if((posicionColumna%7)==0&&posicionColumna != 0){
                posicionColumna = 0;
                posicionFila++;
            }else {
                posicionColumna++;
            }
        }
    }
    public void generarPosiciones(String tuberiaType,int posicionColumna,int posicionFila){
        Posicion nuevaPosicion = new Posicion(tuberiaType,null,null,posicionColumna,posicionFila);
        if(inicio ==null){
            inicio = nuevaPosicion;
            final1 = nuevaPosicion;
        }else{
            final1.setCasillaSiguiente(nuevaPosicion);
            nuevaPosicion.setCasillaPrevia(final1);
            final1=final1.getCasillaSiguiente();
            nuevaPosicion.setCasillaSiguiente(inicio);

        }
    }

    public void ponerTuberia(int columna , int fila, String tipoTuberia){
        Posicion pointer = inicio;
        boolean continue1 = true;
        while(continue1 != false){
            if(pointer.getPosicionColumna() == columna && pointer.getPosicionFila() == fila){
                continue1 = false;
            }else{
                pointer = pointer.getCasillaSiguiente();
            }
        }
        if(pointer.getTipoTuberia().equals("F")||pointer.getTipoTuberia().equals("D")){

        }else{
            pointer.setTipoTuberia(tipoTuberia);
        }
    }

    public String showAll(){
        String message = "";
        if(inicio==null){
            message = "no hay nodos";
        }else{
            Posicion pointer= inicio;
            int counter = 1;
            while(pointer!=null&&counter !=65) {
                if(counter%8==0){
                    message = message+" " + pointer.getTipoTuberia()+"\n";
                    pointer = pointer.getCasillaSiguiente();
                    counter++;
                }else{
                    message = message+" " + pointer.getTipoTuberia();
                    pointer = pointer.getCasillaSiguiente();
                    counter++;
                }
            }

        }
        return message;
    }


    public Posicion getInicio() {
        return inicio;
    }

    public void setInicio(Posicion inicio) {
        this.inicio = inicio;
    }

    public Posicion getFinal1() {
        return final1;
    }

    public void setFinal1(Posicion final1) {
        this.final1 = final1;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }
}
