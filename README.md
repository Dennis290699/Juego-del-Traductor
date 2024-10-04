# Juego del Traductor

El **Juego del Traductor** es una aplicación interactiva basada en consola que permite a los jugadores practicar sus habilidades de traducción entre inglés y español. Se pueden importar palabras y categorías desde un archivo externo o ingresarlas manualmente, lo que lo convierte en un juego educativo y entretenido. Este proyecto fue desarrollado en Java, siguiendo una arquitectura modular y escalable.

## Características

- **Gestión de Palabras y Categorías**: Importa palabras y categorías desde un archivo o añádelas manualmente.
- **Modos de Juego**:
  - **Por Turnos**: Cada jugador tiene al menos tres traducciones de manera intercalada.
  - **Por Tiempo**: Los jugadores traducen la mayor cantidad de palabras posible en un tiempo límite.
- **Puntuación y Tiempo**: Gana el jugador con más aciertos; en caso de empate, el tiempo total es el criterio de desempate.
- **Sin Interfaz Gráfica**: Todo el juego funciona a través de la consola.
- **POO y Modularidad**: Implementado en Java utilizando principios de Programación Orientada a Objetos y siguiendo una estructura modular.

## Estructura del Proyecto

El proyecto se divide en varios paquetes para mantener una estructura limpia y modular:

- **`principal`**: Contiene la clase `App` para la ejecución del programa.
- **`dominio`**: Define las entidades principales del juego como `Jugador`, `Palabra` y `Categoria`.
- **`servicio`**: Contiene la lógica del juego, como el registro de jugadores y el manejo de las reglas.
- **`utilidad`**: Utilidades para la gestión de archivos y cálculo de tiempo, como `ArchivoUtil` y `TiempoUtil`.

## Cómo Empezar

### Prerrequisitos

- **Java 8** o superior.
- Un IDE de desarrollo, como **Eclipse** o **IntelliJ**.

### Instalación

1. Clona el repositorio:

    ```sh
    git clone https://github.com/Dennis290699/Juego-del-Traductor.git
    ```

2. Abre el proyecto en tu IDE preferido.

3. Configura la ruta del archivo de palabras en `ArchivoUtil` (si deseas importar palabras).

### Ejecución

- Ejecuta la clase `App` dentro del paquete `principal`.
- Sigue las instrucciones que aparecen en la consola para registrar jugadores y seleccionar el modo de juego.

## Uso

Al ejecutar la aplicación, verás un menú con las siguientes opciones:

1. **Registrar jugadores**: Permite registrar los jugadores que participarán en el juego.
2. **Iniciar juego por turnos**: Los jugadores juegan de manera intercalada, cada uno realizando tres traducciones.
3. **Iniciar juego por tiempo**: Cada jugador tiene un tiempo límite para traducir tantas palabras como pueda.
4. **Salir**: Termina la ejecución del programa.

### Ejemplo de Juego

```
Bienvenido al Juego del Traductor
1. Registrar jugadores
2. Iniciar juego por turnos
3. Iniciar juego por tiempo
4. Salir
Seleccione una opción: 1
Ingrese la cantidad de jugadores: 2
Ingrese el nombre del jugador 1: Dennis290699
Ingrese el nombre del jugador 2: B4LB3R1TH

Iniciando el juego por turnos...

Turno del jugador: Dennis290699
Traduce la palabra 'verde' al inglés: green
¡Correcto!

Turno del jugador: B4LB3R1TH
Traduce la palabra 'rojo' al inglés: red
¡Correcto!
...
```

## Estructura del Código

- **`principal.App`**: Clase principal para ejecutar el juego.
- **`dominio`**: Contiene las clases `Jugador`, `Palabra` y `Categoria` que representan las entidades del juego.
- **`servicio.JuegoTraductorImpl`**: Implementación de la lógica del juego.
- **`utilidad.ArchivoUtil`**: Métodos para cargar categorías desde un archivo.
- **`utilidad.TiempoUtil`**: Utilidades para calcular y formatear el tiempo.

## Mejoras Futuras

- **Agregar más idiomas**: Actualmente soporta solo inglés y español; se podrían agregar más.
- **Interfaz Gráfica**: Una futura versión podría incluir una interfaz gráfica.
- **Persistencia de Datos**: Guardar el progreso de los jugadores para futuras partidas.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y realiza un commit (`git commit -m 'Agrega nueva característica'`).
4. Haz push a la rama (`git push origin feature/nueva-caracteristica`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT - mira el archivo [LICENSE](LICENSE) para más detalles.
