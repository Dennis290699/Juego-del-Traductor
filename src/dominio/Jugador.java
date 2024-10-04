package dominio;

public class Jugador {
	
	private String nombre;
	private int puntuacion;
	private long tiempoTotal;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
		this.tiempoTotal = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public long getTiempoTotal() {
		return tiempoTotal;
	}

	public void aumentarPuntuacion() {
		puntuacion++;
	}

	public void agregarTiempo(long tiempo) {
		tiempoTotal += tiempo;
	}
	
}// FINAL CLASS
