package dominio;

public class Categoria {
	
	private String nombre;
	private Palabra[] palabras;
	private int cantidadPalabras;

	public Categoria(String nombre, int maxPalabras) {
		this.nombre = nombre;
		this.palabras = new Palabra[maxPalabras];
		this.cantidadPalabras = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean agregarPalabra(Palabra palabra) {
		if (cantidadPalabras < palabras.length) {
			palabras[cantidadPalabras++] = palabra;
			return true;
		}
		return false; // El array esta lleno, no se puede agregar mas palabras
	}

	public Palabra obtenerPalabraAleatoria() {
		if (cantidadPalabras == 0) {
			return null;
		}
		int indiceAleatorio = (int) (Math.random() * cantidadPalabras);
		return palabras[indiceAleatorio];
	}

	public Palabra[] getPalabras() {
		Palabra[] palabrasActuales = new Palabra[cantidadPalabras];
		System.arraycopy(palabras, 0, palabrasActuales, 0, cantidadPalabras);
		return palabrasActuales;
	}

}// FINAL CLASS
