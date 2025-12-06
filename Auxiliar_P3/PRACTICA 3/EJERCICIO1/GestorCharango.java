package EJERCICIO1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestorCharango {
    private Charango[] lista;
    private String nombreArchivo = "CharangO.json";
    private int n ;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public GestorCharango(int capacidad){
        this.lista = new Charango[capacidad];
        this.n= 0 ;

        Charango[] cargados = cargarArchivo();
        for (Charango c : cargados) {
            if (c != null && n < lista.length) {
                lista[n++] = c;
            }
        }
    }


    public void agregarCharango(Charango c) {
        if (n < lista.length) {
            lista[n] = c;
            n++;
        } else {
            System.out.println("Arreglo lleno");
        }
    }

    private Charango[] cargarArchivo() {
        try (FileReader reader = new FileReader(nombreArchivo)) {
            Charango[] datos = gson.fromJson(reader, Charango[].class);
            return datos != null ? datos : new Charango[0];
        } catch (Exception e) {
            return new Charango[0]; // NO GUARDAR
        }
    }

    public void guardarArchivo() {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {

            Charango[] existentes = new Charango[n];
            for (int i = 0; i < n; i++) {
                existentes[i] = lista[i];
            }

            gson.toJson(existentes, writer);
            System.out.println("JSON creado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void EliminarCharangos(){
        for(int i = 0 ; i < lista.length ; i++){
            if(lista[i]!= null) {
                if (lista[i].contarFalso() > 6) {
                    lista[i] = null;
                }
            }
        }
    }
    public void material(String x ){
        for(int i = 0 ; i< lista.length ; i++){
            if(lista[i].getMaterial().equalsIgnoreCase(x));
            System.out.println("Encontrado");
            System.out.println(lista[i]);
            return;
        }
    }
    public void buscarCharango(){
        for(int i = 0 ; i < lista.length ; i++){
            if(lista[i].contarFalso()== 0 ){
                System.out.println("Encontrado");
                System.out.println(lista[i]);
                return;
            }
        }
    }
    public void ordenar(){
        for(int i = 0 ; i < lista.length ; i++){
            for(int j = i+1 ; j < lista.length   ; j++){
                if (lista[i] == null || lista[j] == null) {
                    continue;
                }
                if(lista[i].getMaterial().compareTo(lista[j].getMaterial()) > 0);
                    Charango aux = lista[j];
                    lista[j] = lista[i];
                    lista[i] = aux;

            }
        }

    }
    public void mostrar(){
        for(int i= 0 ; i < lista.length ; i++){
            if(lista[i] != null)
                System.out.println(lista[i]);
        }
    }
}
