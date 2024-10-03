package dominio;

public class Jugador {
    private String nombre; // Nombre del jugador
    private int puntuacion; // Puntuación acumulada del jugador
    private long tiempoTotal; // Tiempo total tomado en la partida

    // Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.tiempoTotal = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public long getTiempoTotal() {
        return tiempoTotal;
    }

    // Métodos para actualizar la puntuación y tiempo
    public void aumentarPuntuacion() {
        puntuacion++;
    }

    public void agregarTiempo(long tiempo) {
        tiempoTotal += tiempo;
    }
}// FINAL CLASS
