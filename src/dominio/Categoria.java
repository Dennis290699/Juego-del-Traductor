package dominio;

public class Categoria {
    private String nombre; // Nombre de la categoria
    private Palabra[] palabras; // Array de palabras en esta categoria
    private int cantidadPalabras; // Número actual de palabras en la categoría

    // Constructor
    public Categoria(String nombre, int maxPalabras) {
        this.nombre = nombre;
        this.palabras = new Palabra[maxPalabras];
        this.cantidadPalabras = 0;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Metodo para añadir una palabra a la categoria
    public boolean agregarPalabra(Palabra palabra) {
        if (cantidadPalabras < palabras.length) {
            palabras[cantidadPalabras++] = palabra;
            return true;
        }
        return false; // El array esta lleno, no se puede agregar mas palabras
    }

    // Método para obtener una palabra aleatoria de la categoría
    public Palabra obtenerPalabraAleatoria() {
        if (cantidadPalabras == 0) {
            return null;
        }
        int indiceAleatorio = (int) (Math.random() * cantidadPalabras);
        return palabras[indiceAleatorio];
    }

    // Metodo para obtener todas las palabras en la categoria
    public Palabra[] getPalabras() {
        Palabra[] palabrasActuales = new Palabra[cantidadPalabras];
        System.arraycopy(palabras, 0, palabrasActuales, 0, cantidadPalabras);
        return palabrasActuales;
    }
}// FINAL CLASS
