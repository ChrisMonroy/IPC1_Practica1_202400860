/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1;

/**
 *
 * @author Christopher
 */
import java.util.Random;
import java.util.Scanner;
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    private String[] palabras; // Vector para almacenar palabras
    private String[] historial; // Vector para almacenar historial de partidas
    private int[] puntuaciones; // Vector para almacenar puntuaciones
    private int puntos; //Contador de puntos
    private int fallos; //Contador de fallos
    private char[][] tablero; //Creador del tablero
    private int numPalabras; // Contador de palabras
    private int numHistorial; // Contador de historial
    private int numPuntuaciones; // Contador para el numero de puntuaciones
    

    public Practica1() {
 // Contador de puntuaciones

        palabras = new String[5]; // Capacidad máxima de 5 palabras
        historial = new String[100]; // Capacidad máxima de 100 partidas
        puntuaciones = new int[100]; // Capacidad máxima de 100 puntuaciones
        tablero = new char[25][25];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                tablero[i][j] = '-';
            }
        }
        puntos = 25;
        fallos = 0;
        numPalabras = 0;
        numHistorial = 0;
        numPuntuaciones = 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Practica1 juego = new Practica1();
        int opcion;

        System.out.println("Bienvenidos a mi programa :)");
        System.out.println("Las reglas son simples");
        System.out.println("Agrege las palabras en Gestion de palabras y luego regresar al menu");
        System.out.println("Por ultimo selecciona Empezar nueva partida y Diviertete");
        do {
            System.out.println(" Selecciona una de las opciones ");
            System.out.println("1. Empezar Nueva Partida");
            System.out.println("2. Mostrar Historial de Partidas");
            System.out.println("3. Mostrar Puntuaciones");
            System.out.println("4. Gestionar Palabras");
            System.out.println("5. Mostrar Informacion del Estudiante");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    juego.jugarV();
                    break;
                case 2:
                    juego.mostrarHistorial();
                    break;
                case 3:
                    juego.puntuaciones();
                    break;
                case 4:
                    juego.gestionar();
                    break;
                case 5:
                    juego.estudiante();
                    break;
                case 6:
                    System.out.println("Saliendo del juego. Gracias por jugar");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    public void gestionar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Gestion de Palabras");
            System.out.println("1. Insertar Palabra");
            System.out.println("2. Modificar Palabra");
            System.out.println("3. Eliminar Palabra");
            System.out.println("4. Mostrar Palabras");
            System.out.println("5. Regresar al Menu Principal");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    insertar();
                    break;
                case 2:
                    modificar();
                    break;
                case 3:
                    eliminar();
                    break;
                case 4:
                    mostrar();
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);
    }

    public void insertar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una palabra de 6 a 15 caracteres: ");
        String palabra = scanner.nextLine();
        if (validarPalabra(palabra)) {
            palabras[numPalabras++] = palabra.toLowerCase(); // Agregar palabra en minúsculas
            System.out.println("Palabra insertada correctamente.");
        } else {
            System.out.println("La palabra no cumple con los requisitos.");
        }
    }

    public boolean validarPalabra(String palabra) {
        return palabra.length() >= 6 && palabra.length() <= 15;
    }

    public void eliminar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la palabra que desea eliminar: ");
        String palabra = scanner.nextLine().toLowerCase(); // Convertir a minúsculas
        if (eliminarPalabra(palabra)) {
            System.out.println("Palabra eliminada correctamente.");
        } else {
            System.out.println("La palabra no se encuentra en la lista.");
        }
    }

    public boolean eliminarPalabra(String palabra) {
        for (int i = 0; i < numPalabras; i++) {
            if (palabras[i].equals(palabra)) {
                // Mover las palabras hacia la izquierda
                for (int j = i; j < numPalabras - 1; j++) {
                    palabras[j] = palabras[j + 1];
                }
                palabras[--numPalabras] = null; // Reducir el tamaño
                return true;
            }
        }
        return false;
    }

    public void mostrar() {
        System.out.println("Palabras ingresadas por el usuario:");
        for (int i = 0; i < numPalabras; i++) {
            System.out.println("  " + palabras[i]);
        }
    }

    public void modificar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la palabra a modificar: ");
        String palabraA = scanner.nextLine().toLowerCase(); // Convertir a minúsculas
        for (int i = 0; i < numPalabras; i++) {
            if (palabras[i].equals(palabraA)) {
                System.out.print("Ingrese la nueva palabra (debe tener de 6 a 15 caracteres): ");
                String nuevaPalabra = scanner.nextLine();
                if (validarPalabra(nuevaPalabra)) {
                    palabras[i] = nuevaPalabra.toLowerCase(); // Modificar la palabra en minúsculas
                    System.out.println("Palabra modificada correctamente.");
                } else {
                    System.out.println("La nueva palabra no cumple con los requisitos.");
                }
                return;
            }
        }
        System.out.println("La palabra a modificar no se encuentra en la lista.");
    }
    public void colocarPalabras() {
        Random random = new Random();
        for (int i = 0; i < numPalabras; i++) {
            String palabra = palabras[i].toLowerCase(); // Convertir a minúsculas
            boolean colocada = false;
            while (!colocada) {
                int fila = random.nextInt(25);
                int columna = random.nextInt(25);
                boolean horizontal = random.nextBoolean();
                if (horizontal && columna + palabra.length() <= 25) {
                    // Colocar horizontalmente
                    boolean col = true;
                    for (int j = 0; j < palabra.length(); j++) {
                        if (tablero[fila][columna + j] != '-') {
                            col = false;
                            break;
                        }
                    }
                    if (col) {
                        for (int j = 0; j < palabra.length(); j++) {
                            tablero[fila][columna + j] = palabra.charAt(j);
                        }
                        colocada = true;
                    }
                } else if (!horizontal && fila + palabra.length() <= 25) {
                    // Colocar verticalmente
                    boolean puedeColocar = true;
                    for (int j = 0; j < palabra.length(); j++) {
                        if (tablero[fila + j][columna] != '-') {
                            puedeColocar = false;
                            break;
                        }
                    }
                    if (puedeColocar) {
                        for (int j = 0; j < palabra.length(); j++) {
                            tablero[fila + j][columna] = palabra.charAt(j);
                        }
                        colocada = true;
                    }
                }
            }
        }
        // Rellenar el resto del tablero con letras aleatorias
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (tablero[i][j] == '-') {
                    tablero[i][j] = (char) ('a' + random.nextInt(26));
                }
            }
        }
    }

    public void marcarPalabraEncontrada(String palabra) {
        palabra = palabra.toLowerCase(); // Convertir a minúsculas
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (tablero[i][j] == palabra.charAt(0)) {
                    // Verificar si la palabra está horizontal
                    if (j + palabra.length() <= 25) {
                        boolean encontrada = true;
                        for (int k = 0; k < palabra.length(); k++) {
                            if (tablero[i][j + k] != palabra.charAt(k)) {
                                encontrada = false;
                                break;
                            }
                        }
                        if (encontrada) {
                            for (int k = 0; k < palabra.length(); k++) {
                                tablero[i][j + k] = '#';
                            }
                            return;
                        }
                    }
                    // Verificar si la palabra está vertical
                    if (i + palabra.length() <= 25) {
                        boolean encontrada = true;
                        for (int k = 0; k < palabra.length(); k++) {
                            if (tablero[i + k][j] != palabra.charAt(k)) {
                                encontrada = false;
                                break;
                            }
                        }
                        if (encontrada) {
                            for (int k = 0; k < palabra.length(); k++) {
                                tablero[i + k][j] = '#';
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    public void mostrarTablero() {
        System.out.println("Tablero de juego");
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void jugarV() {
        Scanner scanner = new Scanner(System.in);
        boolean jugarDeNuevo;
        do {
            comenzar(); // Iniciar una nueva partida
            System.out.print("¿Desea jugar de nuevo? (sí/no): ");
        String respuesta = scanner.nextLine().toLowerCase(); 
        jugarDeNuevo = respuesta.equals("sí");
            puntos = 25;
            fallos = 0;
            // Puedes reiniciar el tablero si es necesario
            for (int i = 0; i < 25; i++) {
                for (int j = 0; j < 25; j++) {
                    tablero[i][j] = '-';
                }
            }
        } while (jugarDeNuevo);
    }
    
    public void comenzar() {
        if (numPalabras == 0) {
            System.out.println("No hay palabras para jugar. Agregue palabras primero.");
            return;
        }
        colocarPalabras();
        Scanner scanner = new Scanner(System.in);
        while (fallos < 4 && numPalabras > 0) {
            mostrarTablero();
            System.out.print("Ingrese una palabra: ");
            String palabraIngresada = scanner.nextLine().toLowerCase(); // Convertir a minúsculas
            if (buscarPalabra(palabraIngresada)) {
                marcarPalabraEncontrada(palabraIngresada);
                puntos += palabraIngresada.length();
                eliminarPalabra(palabraIngresada);
                System.out.println("¡Palabra encontrada! Puntos: " + puntos);
            } else {
                fallos++;
                puntos -= 5;
                System.out.println("Palabra no encontrada. Fallos: " + fallos + ", Puntos: " + puntos);
            }
        }
        if (fallos >= 4) {
            System.out.println("Has alcanzado el límite de fallos. Fin del juego.");
        } else {
            System.out.println("¡Has encontrado todas las palabras! Puntos finales: " + puntos);
        }
        historial[numHistorial++] = " - Puntos: " + puntos;
        puntuaciones[numPuntuaciones++] = puntos;
    }

     public boolean buscarPalabra(String palabra) {
        palabra = palabra.toLowerCase(); 
        for (int i = 0; i < numPalabras; i++) {
            if (palabras[i].equals(palabra)) {
                return true;
            }
        }
        return false;
    }
     
    public void mostrarHistorial() {
        System.out.println("Historial de partidas: ");
        for (int i = 0; i < numHistorial; i++) {
            System.out.println(historial[i]);
        }
    }

    public void estudiante() {
        System.out.println("Nombre: Christopher Alejandro Monroy Maldonado");
        System.out.println("Carnet: 202400860");
        System.out.println("Seccion: D");
    }

    public void puntuaciones() {
        System.out.println("Puntuaciones más altas:");
    for (int i = 0; i < numPuntuaciones - 1; i++) {
        for (int j = 0; j < numPuntuaciones - 1 - i; j++) {
            if (puntuaciones[j] < puntuaciones[j + 1]) {
                int temp = puntuaciones[j];
                puntuaciones[j] = puntuaciones[j + 1];
                puntuaciones[j + 1] = temp;
            }
        }
    }

    for (int i = 0; i < numPuntuaciones; i++) {
        System.out.println((i + 1) + ". " + puntuaciones[i]);
    }
    }
}