package model;

import java.util.ArrayList;

public class Controladora {
    private Tablero tablero;

    private Jugador inicioPuntajes;
    private ArrayList<Jugador> listaJugadores;

//    Metodos
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
    public String simularTuberia(){
        return tablero.simularTuberia();
    }
    public void addJugador(String jugadorNombre,int score){
        Jugador newJugador = new Jugador(score,jugadorNombre);
        addJugador(newJugador, this.inicioPuntajes);

    }
    private Jugador addJugador(Jugador newJugador,Jugador pointer){
        if(inicioPuntajes== null){
            inicioPuntajes = newJugador;
            return inicioPuntajes;
        }else{
            if(newJugador.getPuntaje() > pointer.getPuntaje()){
                if(pointer.getRight()==null) {
                    pointer.setRight(newJugador);
                    return pointer.getRight();
                }else {
                    return addJugador(newJugador,pointer.getRight());
                }
            } else if (newJugador.getPuntaje() < pointer.getPuntaje()) {
                if(pointer.getLeft()==null) {
                    pointer.setLeft(newJugador);
                    return pointer.getLeft();
                }else {
                    return addJugador(newJugador,pointer.getLeft());
                }
            }
        }

        System.out.println("El jugador"+ newJugador.getPuntaje()+""+newJugador.getNombre());
        return newJugador;
    }
    public int calcularPuntos(int tiempoDemorado){
        int tuberiasUsadas = tablero.calcularTuberias();
        int puntaje = tuberiasUsadas * 100 -(60-tiempoDemorado) * 10;


        return puntaje;
    }
    public String verPuntajes(){
        listaJugadores = new ArrayList<Jugador>();
        String mensaje = "";
        verPuntajes(this.inicioPuntajes);
        if(listaJugadores.size() == 0){
            mensaje = "No hay jugadores Registrados";
        }else{
            for (int i = 0; i < listaJugadores.size(); i++) {
                mensaje = mensaje + "\n"+"["+ (i+1) +"]"+ listaJugadores.get(i).getNombre()+": "+listaJugadores.get(i).getPuntaje()+" Puntajes";
            }
        }

        return mensaje;
    }
    private void verPuntajes(Jugador pointer){
        if(pointer==null){

        }else{
            verPuntajes(pointer.getRight());
            listaJugadores.add(pointer);
            verPuntajes(pointer.getLeft());
        }
    }

//    Getters and Setters


    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public Jugador getInicioPuntajes() {
        return inicioPuntajes;
    }

    public void setInicioPuntajes(Jugador inicioPuntajes) {
        this.inicioPuntajes = inicioPuntajes;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }
}