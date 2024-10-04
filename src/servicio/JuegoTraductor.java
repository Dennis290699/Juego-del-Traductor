package servicio;

public interface JuegoTraductor {
	void registrarJugador(String nombre);

	boolean hayJugadores();

	void iniciarJuegoPorTurnos();

	void iniciarJuegoPorTiempo(int tiempoLimite);

	void mostrarResultados();
}
