package principal;

import servicio.JuegoTraductor;
import servicio.JuegoTraductorImpl;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JuegoTraductor juego = new JuegoTraductorImpl();
        
        boolean salir = false;
        while (!salir) {
            System.out.println("Bienvenido al Juego del Traductor");
            System.out.println("1. Registrar jugadores");
            System.out.println("2. Iniciar juego por turnos");
            System.out.println("3. Iniciar juego por tiempo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    juego.registrarJugadores();
                    break;
                case 2:
                    juego.iniciarJuegoPorTurnos();
                    break;
                case 3:
                    juego.iniciarJuegoPorTiempo();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
            }
        }
        scanner.close();
    }
}// FINAL CLASS
