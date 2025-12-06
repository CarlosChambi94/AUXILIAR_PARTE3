package EJERCICIO2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoTrabajador {
    private String nombreArch = "Trabajador.json";
    private int n, m;
    private Trabajador[] trabajadores;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArchivoTrabajador(int capacidad){
        trabajadores = new Trabajador[capacidad];
        m= 0 ;
        Trabajador[] cargados = cargarArchivo();
        for (Trabajador c : cargados) {
            if (c != null && m < trabajadores.length) {
                trabajadores[m++] = c;
            }
        }
    }

    private Trabajador[] cargarArchivo() {
        try (FileReader reader = new FileReader(nombreArch)) {
            Trabajador[] datos = gson.fromJson(reader, Trabajador[].class);
            return datos != null ? datos : new Trabajador[0];
        } catch (Exception e) {
            return new Trabajador[0];
        }
    }

    public void guardarArchivo() {
        try (FileWriter writer = new FileWriter(nombreArch)) {
            Trabajador[] existentes = new Trabajador[n];
            for (int i = 0; i < n; i++) {
                existentes[i] = trabajadores[i];
            }
            gson.toJson(existentes, writer);
            System.out.println("JSON creado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarTrabajador(Trabajador j){
        if(n < trabajadores.length){
            trabajadores[n] = j;
            n++;
        } else {
            System.out.println("ESPACIO LLENO |");
        }
    }
    public void aumentarSalario(Trabajador j, double a){
        for(int i = 0 ; i < trabajadores.length ; i ++){
            if(trabajadores[i] != null){
                if(trabajadores[i].getNombre().equalsIgnoreCase(j.getNombre())){
                    j.setSalario(a);
                    return;
                }
            }
        }
    }

    public void mayorTrabajador(){
        int indice = 0;
        for (int i = 0 ; i < n ; i++) {
            if (trabajadores[i] != null &&
                    trabajadores[i].getSalario() > trabajadores[indice].getSalario()) {
                indice = i;
            }
        }

        System.out.println("El trabajador con mayor salario es: "
                + trabajadores[indice].getNombre());


    }

    public void mayorSalario(){
        Trabajador aux;
        for(int i = 0 ; i < trabajadores.length ; i++){
            for(int j = i+1 ; j < trabajadores.length ; j++){
                if (trabajadores[i] == null || trabajadores[j] == null) {
                    continue;
                }
                if(trabajadores[i].getSalario() < trabajadores[j].getSalario()){
                    aux = trabajadores[i];
                    trabajadores[i] = trabajadores[j];
                    trabajadores[j] = aux ;
                }
            }
        }
    }
    public void mostrar(){
        for(int i= 0 ; i < trabajadores.length ; i++){
            if(trabajadores[i] != null)
                System.out.println(trabajadores[i]);
        }
    }
}
