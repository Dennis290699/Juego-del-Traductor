package principal;

import java.util.Scanner;

import servicio.JuegoTraductor;
import servicio.JuegoTraductorImpl;
import utilidad.JuegoHandler;
import utilidad.MenuHandler;

public class App {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		JuegoTraductor juego = new JuegoTraductorImpl();
		MenuHandler menuHandler = new MenuHandler();
		JuegoHandler juegoHandler = new JuegoHandler();
		boolean salir = false;

		while (!salir) {
			menuHandler.mostrarMenu();
			System.out.print("Seleccione una opción: ");
			String opcion = scanner.nextLine();

			switch (opcion) {
			case "1":
				juegoHandler.registrarJugadores(juego, scanner);
				break;
			case "2":
				juegoHandler.iniciarJuegoPorTurnos(juego);
				break;
			case "3":
				juegoHandler.iniciarJuegoPorTiempo(juego, scanner);
				break;
			case "4":
				System.out.println("Gracias por jugar. ¡Hasta luego!");
				salir = true;
				break;
			default:
				System.out.println("Opción inválida. Por favor, intente de nuevo.");
				break;
			}
		}

		scanner.close();
	}
	
}// FINAL CLASS