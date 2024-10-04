package utilidad;

import servicio.JuegoTraductor;
import java.util.Scanner;

public class JuegoHandler {
	public void registrarJugadores(JuegoTraductor juego, Scanner scanner) {
		System.out.print("Ingrese la cantidad de jugadores: ");
		try {
			int cantidadJugadores = Integer.parseInt(scanner.nextLine());
			for (int i = 0; i < cantidadJugadores; i++) {
				System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
				String nombre = scanner.nextLine();
				juego.registrarJugador(nombre);
			}
		} catch (NumberFormatException e) {
			System.out.println("Entrada inválida. Debe ingresar un número para la cantidad de jugadores.");
		}
	}

	public void iniciarJuegoPorTurnos(JuegoTraductor juego) {
		if (juego.hayJugadores()) {
			juego.iniciarJuegoPorTurnos();
		} else {
			System.out.println("No hay jugadores registrados. Por favor, registre jugadores antes de comenzar.");
		}
	}

	public void iniciarJuegoPorTiempo(JuegoTraductor juego, Scanner scanner) {
		if (juego.hayJugadores()) {
			System.out.print("Ingrese el tiempo límite por jugador (en segundos): ");
			try {
				int tiempoLimite = Integer.parseInt(scanner.nextLine());
				juego.iniciarJuegoPorTiempo(tiempoLimite);
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Debe ingresar un número para el tiempo límite.");
			}
		} else {
			System.out.println("No hay jugadores registrados. Por favor, registre jugadores antes de comenzar.");
		}
	}
}// FINAL CLASS
