package model;

import java.util.Random;

public class Tablero {
    private Posicion inicio;
    private Posicion final1;
    private Jugador jugadorActual;

//    Metodos

    public Tablero(Posicion inicio, Posicion final1, Jugador jugadorActual) {
        this.inicio = inicio;
        this.final1 = final1;
        this.jugadorActual = jugadorActual;
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
            nuevaPosicion.setCasillaPrevia(final1);
            final1.setCasillaSiguiente(nuevaPosicion);
            final1 = final1.getCasillaSiguiente();

        }
    }
    public void ponerTuberia(int columna , int fila, String tipoTuberia){
        Posicion pointer = buscarPosicion(inicio,columna,fila);

        if(pointer.getTipoTuberia().equals("F")||pointer.getTipoTuberia().equals("D")){

        }else{
            pointer.setTipoTuberia(tipoTuberia);
        }
    }
    public Posicion buscarPosicion(Posicion pointer,int columna, int fila){
        boolean continue1 = true;
        while(continue1 != false){
            if(pointer.getPosicionColumna() == columna && pointer.getPosicionFila() == fila){
                continue1 = false;
            }else{
                pointer = pointer.getCasillaSiguiente();
            }
        }

        return pointer;
    }
    public String simularTuberia(){
        boolean posibleSolucion = simularTuberia(true,inicio);
        if(inicioValidacion(inicio) == false){
            posibleSolucion = false;
        }
        if(posibleSolucion==true){
            return "La solución es correcta";
        }else{
            System.out.println(showAll());
            return "La tubería no funciona";
        }
    }

    private boolean simularTuberia(boolean posibleSolucion,Posicion pointer ) {
        if (pointer == null) {

        } else if (pointer.getTipoTuberia().equals("o") && pointer.getCasillaSiguiente().getTipoTuberia().equals("o")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("=") && pointer.getCasillaSiguiente().getTipoTuberia().equals("||")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("=") && pointer.getCasillaSiguiente().getTipoTuberia().equals("x")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("||") && pointer.getCasillaSiguiente().getTipoTuberia().equals("=")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("o") && casillaInferior(pointer).equals("=")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("||") && casillaInferior(pointer).equals("=")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("||") && casillaInferior(pointer).equals("x")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("F") && pointer.getCasillaSiguiente().equals("o")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("F") && pointer.getCasillaPrevia().equals("o")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("F") && casillaInferior(pointer).equals("o")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("F") && casillaSuperior(pointer).equals("o")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("D") && pointer.getCasillaPrevia().equals("o")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("D") && casillaInferior(pointer).equals("o")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("D") && casillaSuperior(pointer).equals("o")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("D") && pointer.getCasillaSiguiente().equals("o")) {
            posibleSolucion = false;
        } else if (pointer.getTipoTuberia().equals("=") && pointer.getCasillaPrevia().getTipoTuberia().equals("x")) {
            posibleSolucion = false;
        }else if(pointer.getTipoTuberia().equals("o") && pointer.getCasillaPrevia().getTipoTuberia().equals("=") || pointer.getTipoTuberia().equals("o") && pointer.getCasillaPrevia().getTipoTuberia().equals("||")){
            posibleSolucion = false;
        }
        else{
                posibleSolucion = simularTuberia(posibleSolucion,pointer.getCasillaSiguiente());
        }



        return posibleSolucion;
    }
    public static boolean inicioValidacion(Posicion pointer){
        boolean hanJugado= true;
        int counter = 0 ;
        int counterX = 0;
        while(counter !=63){
            if(pointer.getTipoTuberia().equals("x")){
                counterX++;
            }
            pointer = pointer.getCasillaSiguiente();
            counter++;
        }
        if(counterX == 61){
            hanJugado = false;
        }
        return hanJugado;
    }
    public String casillaInferior(Posicion pointer){
        int pointerFilainferior = pointer.getPosicionFila();
        pointerFilainferior++;
        int pointerColumnainferior = pointer.getPosicionColumna();
        Posicion casillaInferior = buscarPosicion(inicio,pointerColumnainferior,pointerFilainferior);
        return casillaInferior.getTipoTuberia();
    }
    public String casillaSuperior(Posicion pointer){
        int pointerFilaSuperior = pointer.getPosicionFila();
        pointerFilaSuperior--;
        int pointerColumnainferior = pointer.getPosicionColumna();
        if(pointerFilaSuperior < 0){
            return "Casilla Superior Alcanzada";
        }else{
            Posicion casillaInferior = buscarPosicion(inicio,pointerColumnainferior,pointerFilaSuperior);
            return casillaInferior.getTipoTuberia();
        }
    }
    public int restantes(Posicion pointer){
        int restantes = 0;
        boolean continue1 = true;
        Posicion posicionD = null;
        while(continue1 != false && pointer != null){
            if(pointer.getTipoTuberia().equals("D")){
                continue1 = false;
                posicionD = pointer;

            }else{
                pointer = pointer.getCasillaSiguiente();
            }
        }
        if(pointer != null){
            pointer = inicio;
            int posicionVerdaderaD = posicionD.getPosicionColumna() * posicionD.getPosicionFila();

            while(pointer!= null&& posicionVerdaderaD != 64){
                posicionVerdaderaD++;
                if(pointer.getTipoTuberia().equals("x")){
                    pointer= pointer.getCasillaSiguiente();
                }else{
                    restantes++;
                }
            }
            return restantes;
        }
        return  0;

    }
    public int calcularTuberias(){
        int tuberiasUsadas = 0;
        Posicion pointer = inicio;
        for(int i = 0;i<65 ;i++){
            if(pointer.getTipoTuberia().equals("o") || pointer.getTipoTuberia().equals("=") ||pointer.getTipoTuberia().equals("||") ){
                tuberiasUsadas++;
            }
        }
        return tuberiasUsadas;

    }

//    Getter and Setters.
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
