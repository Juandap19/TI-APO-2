package ui;

import model.*;
import exceptions.*;

import java.util.InputMismatchException;
import java.time.LocalTime;
import java.util.Scanner;


public class Main {
    public static Scanner lc = new Scanner(System.in);
    public static Controladora ct = new Controladora();
    public static void main(String [] args){
        int option = 0;
        do{
            System.out.println("Bienvenido a PipeMania");
            option = menu();
            switch (option){
                case 1:
                    nuevaPartida();
                    break;
                case 2:
                    verPuntaje();
                    break;
                case 3:
                    break;

            }
        }while(option !=3);
    }
    public static int menu(){
        System.out.println("""
                /////////////////////////
                [1]Nueva Partida
                [2]Ver Puntaje
                [3]Salir
                /////////////////////////
                """);
        int option = lc.nextInt();
        lc.nextLine();
        return option;
    }
    public static void verPuntaje(){
        System.out.println(ct.verPuntajes());
    }
    public static void nuevaPartida(){
        int option = 0;
        System.out.println("Digite su nickName");
        String nombre = lc.nextLine();
        System.out.println(ct.nuevaPartida(nombre));
        int puntosObtenidos = 0;
        LocalTime tiempoInicio = LocalTime.now();
        int minInicio = tiempoInicio.getMinute();
        int segInicio = tiempoInicio.getSecond();
        do{
            option = partidaMenu();
            switch (option){
                case 1:
                    ponerTuberia();
                    break;
                case 2:
                    LocalTime tiempoFinal = LocalTime.now();
                    int minFinal = tiempoFinal.getMinute();
                    int segFinal = tiempoFinal.getSecond();
                    int tiempoObtenido = ((minFinal-minInicio) * 60 ) + (segFinal - segInicio);
                    puntosObtenidos = ct.calcularPuntos(tiempoObtenido);
                    option = simularTuberia();
                    if(option == 3){
                        ct.addJugador(nombre,puntosObtenidos);
                    }
                    break;
                case 3:
                    break;
            }

        }while(option != 3);
    }
    public static int partidaMenu(){
        int option = 0;
        System.out.println("""
                [1]Poner Tuberia
                [2]Simular
                [3]Salir""");
        option = lc.nextInt();
        lc.nextLine();
        return option;
    }
    public static void ponerTuberia(){
        try{
            System.out.println("Digite la fila:");
            int fila = Integer.parseInt(lc.next());
            lc.nextLine();
            System.out.println("Digite la columna:");
            int columna = Integer.parseInt(lc.next());
            lc.nextLine();
            System.out.println("Escriba el tipo de tubería =, ||, o.");
            String tipoTuberia = lc.nextLine();
            tipoTuberia = tipoTuberia.toLowerCase();
            validacionTuberia(tipoTuberia);
            System.out.println(ct.ponerTuberia(columna,fila,tipoTuberia));
        }
        catch (NumberFormatException e) {
            System.out.println("Solo numeros entre 0 - 7");
            ponerTuberia();
        }catch (NullPointerException exception) {
            System.out.println("El valor sale del rango entre 0-7");
            ponerTuberia();
        }catch (TuberiaValidaException exception){
            System.out.println(exception);
            ponerTuberia();
        }

    }
    public static void validacionTuberia(String tipoTuberia) throws TuberiaValidaException{
        if(tipoTuberia.equals("=")||tipoTuberia.equals("||")||tipoTuberia.equals("o")){

        }else{
            throw new TuberiaValidaException("No se aceptan tuberias diferentes");
        }
    }
    public static int  simularTuberia(){
        int option = 0;
        String mensaje = ct.simularTuberia();
        System.out.println(mensaje);
        if(mensaje.equalsIgnoreCase("La solución es correcta")){
            option = 3;
        }
        return  option;
    }
}
