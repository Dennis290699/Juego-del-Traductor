package utilidad;

import dominio.Categoria;
import dominio.Palabra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoUtil {
	private static final String RUTA_ARCHIVO = "Resources/categorias.txt"; // LECTURA DEL ARCHIVO DENTRO DEL PROYECTO

	public static Categoria[] cargarCategorias() {
		Categoria[] categorias = new Categoria[11]; // Máximo de 11 categorías
		int cantidadCategorias = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
			String linea;
			Categoria categoriaActual = null;

			while ((linea = br.readLine()) != null) {
				linea = linea.trim();
				if (linea.isEmpty()) {
					continue; // Saltar líneas vacías
				}

				if (linea.startsWith("#")) {
					// Cada línea que comienza con '#' es una nueva categoría
					String nombreCategoria = linea.substring(1).trim();
					categoriaActual = new Categoria(nombreCategoria, 10); // Suponiendo un máximo de 10 palabras por categoría												
					categorias[cantidadCategorias++] = categoriaActual;
				} else if (categoriaActual != null) {
					// Añadir una palabra a la categoría actual
					String[] palabras = linea.split(" - ");
					if (palabras.length == 2) {
						Palabra palabra = new Palabra(palabras[0].trim(), palabras[1].trim());
						categoriaActual.agregarPalabra(palabra);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

		return categorias;
	}
}// FINAL CLASS
