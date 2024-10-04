package utilidad;

public class TiempoUtil {

	public static long calcularTiempoTranscurrido(long tiempoInicio, long tiempoFin) {
		return tiempoFin - tiempoInicio;
	}

	public static String formatearTiempo(long tiempoEnMilisegundos) {
		long segundos = tiempoEnMilisegundos / 1000;
		long minutos = segundos / 60;
		segundos %= 60;
		return minutos + " minutos y " + segundos + " segundos";
	}

}// FINAL CLASS
