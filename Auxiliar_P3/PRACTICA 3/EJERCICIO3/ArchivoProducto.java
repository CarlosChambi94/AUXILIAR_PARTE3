package EJERCICIO3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoProducto {
    private String nomA = "Producto.json";
    private Producto[] producto ;
    private int n,m ;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArchivoProducto(int capacidad){
        this.producto = new Producto[capacidad] ;
        m = 0 ;
        this.n = 0 ;
        Producto[] cargados = cargarArchivo();
        for (Producto c : cargados) {
            if (c != null && m < producto.length) {
                producto[m++] = c;
            }
        }
    }
    private Producto[] cargarArchivo() {
        try (FileReader reader = new FileReader(nomA)) {
            Producto[] datos = gson.fromJson(reader, Producto[].class);
            return datos != null ? datos : new Producto[0];
        } catch (Exception e) {
            return new Producto[0];
        }
    }

    public void guardarArchivo() {
        try (FileWriter writer = new FileWriter(nomA)) {
            Producto[] existentes = new Producto[n];
            for (int i = 0; i < n; i++) {
                existentes[i] = producto[i];
            }
            gson.toJson(existentes, writer);
            System.out.println("JSON creado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void GuardarProducto(Producto p){
        if(n < producto.length){
            producto[n] = p;
            n++;
        }else{
            System.out.println("Sin espacio suficiente ");
        }
    }
    public void buscarProducto(int c){
        for(int i = 0 ;i < n ; i++){
            if(producto[i].getCodigo() == c){
                System.out.println("Encontrado");
                System.out.println(producto[i]);
            }
        }
    }
    public int  promedioProductos(){
        float sm= 0 ;
        int c= 0;
        for(int i = 0; i < n ; i++){
            if(producto[i]!=null ){
                sm += producto[i].getPrecio();
                c++;
            }
        }
        return (int) (sm/c);

    }
    public void productoCaro(){
        int indice = 0;
        for(int i = 0 ; i < n ; i++){
            if (producto[i] != null &&
                    producto[i].getPrecio() > producto[indice].getPrecio()) {
                indice = i;
            }

        }

        System.out.println("El producto mas caro es: "
                + producto[indice].getNombre());
        }

    public void mostrar(){
        for(int i= 0 ; i < producto.length ; i++){
            if(producto[i] != null)
                System.out.println(producto[i]);
        }
    }
    }


