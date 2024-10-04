package servicio;

import java.util.Scanner;

import dominio.Categoria;
import dominio.Jugador;
import dominio.Palabra;
import utilidad.ArchivoUtil;
import utilidad.TiempoUtil;

public class JuegoTraductorImpl implements JuegoTraductor {
	private Jugador[] jugadores;
	private Categoria[] categorias;
	private int cantidadJugadores;
	private int cantidadCategorias;
	private static final int MAX_JUGADORES = 10;
	private static final int MAX_CATEGORIAS = 5;

	public JuegoTraductorImpl() {
		this.jugadores = new Jugador[MAX_JUGADORES];
		this.categorias = new Categoria[MAX_CATEGORIAS];
		this.cantidadJugadores = 0;
		this.cantidadCategorias = 0;
		cargarCategoriasDesdeArchivo();
	}

	@Override
	public void registrarJugador(String nombre) {
		if (cantidadJugadores < MAX_JUGADORES) {
			jugadores[cantidadJugadores++] = new Jugador(nombre);
		} else {
			System.out.println("No se pueden registrar más jugadores. Límite alcanzado.");
		}
	}

	@Override
	public boolean hayJugadores() {
		return cantidadJugadores > 0;
	}

	@Override
	public void iniciarJuegoPorTurnos() {
		if (cantidadJugadores < 2) {
			System.out.println("Se necesitan al menos dos jugadores para iniciar el juego por turnos.");
			return; // Salir del método si no hay suficientes jugadores
		}

		Scanner scanner = new Scanner(System.in);
		int rondasPorJugador = 3; // Cada jugador tiene 3 intentos en cada ronda

		for (int ronda = 0; ronda < rondasPorJugador; ronda++) {
			for (int i = 0; i < cantidadJugadores; i++) {
				Jugador jugador = jugadores[i];
				System.out.println("\nTurno del jugador: " + jugador.getNombre() + " (Ronda " + (ronda + 1) + ")");

				Categoria categoria = seleccionarCategoriaAleatoria();
				Palabra palabra = categoria.obtenerPalabraAleatoria();

				if (palabra != null) {
					String idioma = Math.random() < 0.5 ? "en" : "es";
					String palabraMostrar = idioma.equals("en") ? palabra.getPalabraEs() : palabra.getPalabraEn();
					System.out.print("Traduce la palabra '" + palabraMostrar + "' al "
							+ (idioma.equals("en") ? "inglés" : "español") + ": ");

					long inicio = System.currentTimeMillis();
					String respuesta = scanner.nextLine();
					long fin = System.currentTimeMillis();

					if (palabra.esTraduccionCorrecta(respuesta, idioma)) {
						System.out.println("¡Correcto!");
						jugador.aumentarPuntuacion();
						jugador.agregarTiempo(fin - inicio);
					} else {
						System.out.println("Incorrecto. La respuesta correcta era: "
								+ (idioma.equals("en") ? palabra.getPalabraEn() : palabra.getPalabraEs()));
					}
				} else {
					System.out.println("No hay palabras disponibles en la categoría.");
				}
			}
		}
	}

	@Override
	public void iniciarJuegoPorTiempo(int tiempoLimite) {
		if (cantidadCategorias == 0) {
			System.out.println("No hay categorías disponibles para jugar.");
			return; // Salir si no hay categorías disponibles
		}

		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < cantidadJugadores; i++) {
			Jugador jugador = jugadores[i];
			System.out.println("Turno del jugador: " + jugador.getNombre());

			long tiempoInicioJugador = System.currentTimeMillis();
			long tiempoFinJugador = tiempoInicioJugador + tiempoLimite * 1000;

			while (System.currentTimeMillis() < tiempoFinJugador) {
				Categoria categoria = seleccionarCategoriaAleatoria();

				if (categoria == null) {
					System.out.println("No hay categorías disponibles para seleccionar.");
					break; // Salir del ciclo si no hay categorías
				}

				Palabra palabra = categoria.obtenerPalabraAleatoria();

				if (palabra != null) {
					String idioma = Math.random() < 0.5 ? "en" : "es";
					String palabraMostrar = idioma.equals("en") ? palabra.getPalabraEs() : palabra.getPalabraEn();
					System.out.print("Traduce la palabra '" + palabraMostrar + "' al "
							+ (idioma.equals("en") ? "inglés" : "español") + ": ");

					long tiempoInicio = System.currentTimeMillis(); // Tiempo de inicio para esta palabra
					String respuesta = scanner.nextLine();
					long tiempoFin = System.currentTimeMillis(); // Tiempo de finalización

					long tiempoTranscurrido = TiempoUtil.calcularTiempoTranscurrido(tiempoInicio, tiempoFin);
					String tiempoFormateado = TiempoUtil.formatearTiempo(tiempoTranscurrido);

					if (palabra.esTraduccionCorrecta(respuesta, idioma)) {
						System.out.println("¡Correcto! Tiempo utilizado: " + tiempoFormateado);
						jugador.aumentarPuntuacion();
					} else {
						System.out.println("Incorrecto. La respuesta correcta era: "
								+ (idioma.equals("en") ? palabra.getPalabraEn() : palabra.getPalabraEs()));
						System.out.println("Tiempo utilizado: " + tiempoFormateado);
					}
				} else {
					System.out.println("No hay palabras disponibles en la categoría.");
				}
			}
			System.out.println("Tiempo agotado para el jugador: " + jugador.getNombre());
		}
	}

	@Override
	public void mostrarResultados() {
		System.out.println("Resultados del juego:");
		for (int i = 0; i < cantidadJugadores; i++) {
			Jugador jugador = jugadores[i];
			System.out.println("Jugador: " + jugador.getNombre() + " - Puntos: " + jugador.getPuntuacion()
					+ " - Tiempo total: " + jugador.getTiempoTotal() + " ms");
		}
	}

	private Categoria seleccionarCategoriaAleatoria() {
		if (cantidadCategorias == 0) {
			return null; // No hay categorías disponibles
		}
		int indiceAleatorio = (int) (Math.random() * cantidadCategorias);
		return categorias[indiceAleatorio];
	}

	private void cargarCategoriasDesdeArchivo() {
		Categoria[] categoriasCargadas = ArchivoUtil.cargarCategorias();
		if (categoriasCargadas != null) {
			for (Categoria categoria : categoriasCargadas) {
				if (cantidadCategorias < MAX_CATEGORIAS && categoria != null) {
					categorias[cantidadCategorias++] = categoria;
				}
			}
		}
	}
	
}// FINAL CLASS
