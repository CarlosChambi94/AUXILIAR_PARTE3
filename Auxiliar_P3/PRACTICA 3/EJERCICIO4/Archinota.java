package EJERCICIO4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;

public class Archinota {
    private String nombrearchi = "notas.json";
    private Nota[] notas;
    private int n ;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create() ;

    public Archinota(int capacidad) {
        this.notas = new Nota[capacidad];
        this.n = n;
        Nota[] cargadas = cargar();
        for (Nota no : cargadas) {
            if (no != null) {
                notas[n++] = no;
            }
        }
    }
    private Nota[] cargar() {
        try (FileReader r = new FileReader(nombrearchi)) {
            Nota[] datos = gson.fromJson(r, Nota[].class);
            return datos != null ? datos : new Nota[0];
        } catch (Exception e) {
            return new Nota[0];
        }
    }

    public void guardar() {
        try (FileWriter w = new FileWriter(nombrearchi)) {
            Nota[] existentes = new Nota[n];
            for (int i = 0; i < n; i++) existentes[i] = notas[i];

            gson.toJson(existentes, w);
            System.out.println("JSON guardado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void agregarnotas(Nota no){
        if(n < notas.length){
            notas[n] = no;
            n++;
        } else {
            System.out.println("Sin espacio suficiente ");
        }
    }
    public double  obtenerPromedio(){
        double sm = 0;
        for(int i = 0 ; i < n ; i++){
            sm += notas[i].getNotaFina();
        }
        return sm / n;
    }
    public void mejorNota(){
        int indice = 0;
        for(int i = 0; i < n ; i++){
            if(notas[i].getNotaFina() > notas[indice].getNotaFina() ){
                indice = i ;
            }
        }
        System.out.println("El estudiante con mayor nota es:" + notas[indice].getEstudiante().getNombre());
    }
    public void eliminarMateria(String materia){
        for (int i = 0; i < n; i++) {
            if (notas[i] != null && notas[i].getMateria().equalsIgnoreCase(materia)) {
                for (int j = i; j < n - 1; j++) {
                    notas[j] = notas[j + 1];
                }
                notas[n - 1] = null;
                n--;
                i--;
            }
        }
    }
    public void mostrar() {
        for (int i = 0; i < n; i++) {
            System.out.println(notas[i]);
        }
    }
}
