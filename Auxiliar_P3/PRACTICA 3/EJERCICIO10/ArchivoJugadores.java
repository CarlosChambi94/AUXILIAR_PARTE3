package EJERCICIO10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoJugadores {
    String nombreArchivo = "Jugadores.txt";


    public void guardar(Jugador j) {
        try (FileWriter fw = new FileWriter(nombreArchivo, true)) {
            fw.write(j.toString() + "\n");
        } catch (IOException e) { System.out.println("Error al guardar"); }
    }


    public void mostrar() {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while((linea = br.readLine()) != null){
                mostrarJugadorFormateado(linea);
            }
        } catch (IOException e) { System.out.println("Archivo no encontrado"); }
    }


    public void buscar(String nombreBuscado) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            boolean encontrado = false;

            while((linea = br.readLine()) != null){
                String[] datos = linea.split(",");
                if(datos[0].equalsIgnoreCase(nombreBuscado)){
                    mostrarJugadorFormateado(linea);
                    encontrado = true;
                }
            }
            if(!encontrado) System.out.println("Jugador no encontrado");
        } catch (IOException e) { System.out.println("Error en la búsqueda"); }
    }

    private void mostrarJugadorFormateado(String linea){
        String[] d = linea.split(",");
        System.out.println("Jugador = Nombre: " + d[0] + " | Nivel: " + d[1] + " | Puntaje: " + d[2]);
    }
}

