package servicio;

import dominio.Categoria;
import dominio.Jugador;
import dominio.Palabra;
import utilidad.ArchivoUtil;
import utilidad.TiempoUtil;
import java.util.Scanner;

public class JuegoTraductorImpl implements JuegoTraductor {
	private Jugador[] jugadores;
	private Categoria[] categorias;
	private int cantidadJugadores;
	private int cantidadCategorias;
	private static final int MAX_JUGADORES = 10;
	private static final int MAX_CATEGORIAS = 5;

	// Constructor
	public JuegoTraductorImpl() {
		this.jugadores = new Jugador[MAX_JUGADORES];
		this.categorias = new Categoria[MAX_CATEGORIAS];
		this.cantidadJugadores = 0;
		this.cantidadCategorias = 0;
		cargarCategoriasDesdeArchivo();
	}

	// Metodo para registrar jugadores
	@Override
	public void registrarJugadores() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese la cantidad de jugadores: ");
		int numeroJugadores = scanner.nextInt();
		scanner.nextLine(); // Consumir la nueva línea

		for (int i = 0; i < numeroJugadores && cantidadJugadores < MAX_JUGADORES; i++) {
			System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
			String nombre = scanner.nextLine();
			jugadores[cantidadJugadores++] = new Jugador(nombre);
		}
	}

	// Método para iniciar el juego por turnos
	@Override
	public void iniciarJuegoPorTurnos() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < cantidadJugadores; i++) {
			Jugador jugador = jugadores[i];
			System.out.println("Turno del jugador: " + jugador.getNombre());

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

	// Método para iniciar el juego por tiempo
	@Override
	public void iniciarJuegoPorTiempo() {
		if (cantidadCategorias == 0) {
			System.out.println("No hay categorías disponibles para jugar.");
			return; // Salir si no hay categorías disponibles
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el tiempo límite por jugador (en segundos): ");
		int tiempoLimite = scanner.nextInt();
		scanner.nextLine(); // Consumir la nueva línea

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

	// Método para mostrar los resultados finales del juego
	@Override
	public void mostrarResultados() {
		System.out.println("Resultados del juego:");
		for (int i = 0; i < cantidadJugadores; i++) {
			Jugador jugador = jugadores[i];
			System.out.println("Jugador: " + jugador.getNombre() + " - Puntos: " + jugador.getPuntuacion()
					+ " - Tiempo total: " + jugador.getTiempoTotal() + " ms");
		}
	}

	// Método privado para seleccionar una categoría aleatoria
	private Categoria seleccionarCategoriaAleatoria() {
		if (cantidadCategorias == 0) {
			return null; // No hay categorías disponibles
		}
		int indiceAleatorio = (int) (Math.random() * cantidadCategorias);
		return categorias[indiceAleatorio];
	}

	// Método privado para cargar las categorías desde un archivo usando
	// `ArchivoUtil`
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
