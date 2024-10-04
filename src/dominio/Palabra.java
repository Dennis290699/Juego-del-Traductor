package dominio;

public class Palabra {
	
	private String palabraEn;
	private String palabraEs;

	public Palabra(String palabraEn, String palabraEs) {
		this.palabraEn = palabraEn;
		this.palabraEs = palabraEs;
	}

	public String getPalabraEn() {
		return palabraEn;
	}

	public String getPalabraEs() {
		return palabraEs;
	}

	public void setPalabraEn(String palabraEn) {
		this.palabraEn = palabraEn;
	}

	public void setPalabraEs(String palabraEs) {
		this.palabraEs = palabraEs;
	}

	public boolean esTraduccionCorrecta(String palabra, String idioma) {
		if (idioma.equalsIgnoreCase("es")) {
			return palabra.equalsIgnoreCase(palabraEs);
		} else if (idioma.equalsIgnoreCase("en")) {
			return palabra.equalsIgnoreCase(palabraEn);
		}
		return false;
	}

}// FINAL CLASS
