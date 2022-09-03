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
        /*primer if() se busca un numero random entre 5 20 el segundo if 21 y 50 y demas
        * se usa el ultimo else*/
        Random numAleatorio = new Random();
        int numberF = numAleatorio.nextInt(15-5+1) + 5;
        int numberD = numAleatorio.nextInt(50-38+1) + 38;
        for (int i = 0; i < 64; i++) {
            if(numberF == i){
                generarPosiciones("F",i);
            }else if(numberD == i){
                generarPosiciones("D",i);
            }else{
                generarPosiciones("x",i);
            }
        }
    }
    public void generarPosiciones(String tuberiaType,int posicionVerdadera){
        Posicion nuevaPosicion = new Posicion(tuberiaType,null,null,posicionVerdadera);
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
