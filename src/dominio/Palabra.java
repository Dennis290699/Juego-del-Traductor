package dominio;

public class Palabra {
	private String palabraEn; // Palabra en ingles
	private String palabraEs; // Palabra en espaniol

	// Constructor
	public Palabra(String palabraEn, String palabraEs) {
		this.palabraEn = palabraEn;
		this.palabraEs = palabraEs;
	}

	// Getters
	public String getPalabraEn() {
		return palabraEn;
	}

	public String getPalabraEs() {
		return palabraEs;
	}

	// Setters
	public void setPalabraEn(String palabraEn) {
		this.palabraEn = palabraEn;
	}

	public void setPalabraEs(String palabraEs) {
		this.palabraEs = palabraEs;
	}

	// Metodo para verificar si la traducción es correcta
	public boolean esTraduccionCorrecta(String palabra, String idioma) {
		if (idioma.equalsIgnoreCase("es")) {
			return palabra.equalsIgnoreCase(palabraEs);
		} else if (idioma.equalsIgnoreCase("en")) {
			return palabra.equalsIgnoreCase(palabraEn);
		}
		return false;
	}
}// FINAL CLASS
