package EJERCICIO10;

public class Main {
    public static void main(String[] args) {
        ArchivoJugadores archivo = new ArchivoJugadores();

        // Cargar datos (no interactivo - ejemplo simple)
        Jugador p1 = new Jugador("Carlos", 10, 1500);
        Jugador p2 = new Jugador("María", 15, 2200);
        Jugador p3 = new Jugador("Luis", 8, 1200);

        archivo.guardar(p1);
        archivo.guardar(p2);
        archivo.guardar(p3);

        System.out.println("LISTA DE TODOS LOS JUGADORES:");
        archivo.mostrar();

        System.out.println(" BUSQUEDA POR NOMBRE: 'María'");
        archivo.buscar("María");
    }
}