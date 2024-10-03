package utilidad;

public class TiempoUtil {

    // Método para calcular el tiempo transcurrido en milisegundos
    public static long calcularTiempoTranscurrido(long tiempoInicio, long tiempoFin) {
        return tiempoFin - tiempoInicio;
    }

    // Método para convertir el tiempo a un formato legible (minutos y segundos)
    public static String formatearTiempo(long tiempoEnMilisegundos) {
        long segundos = tiempoEnMilisegundos / 1000;
        long minutos = segundos / 60;
        segundos %= 60;
        return minutos + " minutos y " + segundos + " segundos";
    }
}// FINAL CLASS
