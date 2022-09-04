package ui;

import model.*;
import java.util.Scanner;

public class Main {
    public static Scanner lc = new Scanner(System.in);
    public static Controladora ct = new Controladora();
    public static void main(String [] args){
        int option = 0;
        do{
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
                [1]Nueva Partida
                [2]Ver Puntaje
                [3]Salir
                """);
        int option = lc.nextInt();
        lc.nextLine();
        return option;
    }

    public static void nuevaPartida(){
        int option = 0;
        System.out.println("Digite su nickName");
        String nombre = lc.nextLine();
        System.out.println(ct.nuevaPartida(nombre));
        do{
            option = partidaMenu();
            switch (option){
                case 1:
                    ponerTuberia();
                    break;
                case 2:
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
        System.out.println("Digite la fila:");
        int fila = lc.nextInt();
        lc.nextLine();
        System.out.println("Digite la columna");
        int columna = lc.nextInt();
        lc.nextLine();
        System.out.println("Escriba el tipo de tubería =, ||, o.");
        String tipoTuberia = lc.nextLine();
        System.out.println(ct.ponerTuberia(columna,fila,tipoTuberia));
    }
    public static void verPuntaje(){

    }
}
