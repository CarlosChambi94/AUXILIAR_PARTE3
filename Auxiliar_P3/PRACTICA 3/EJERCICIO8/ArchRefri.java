package EJERCICIO8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ArchRefri {

    private String nombreArch;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Alimento[] alimentos;
    private int n = 0;

    public ArchRefri(String nombreArch) {
        this.nombreArch = nombreArch;
        alimentos = cargar();
        n = alimentos.length;
    }


    private Alimento[] cargar() {
        try (FileReader r = new FileReader(nombreArch)) {
            Alimento[] datos = gson.fromJson(r, Alimento[].class);
            return (datos != null) ? datos : new Alimento[0];
        } catch (Exception e) {
            return new Alimento[0];
        }
    }


    private void guardar() {
        try (FileWriter w = new FileWriter(nombreArch)) {
            gson.toJson(alimentos, w);
            System.out.println("Guardado en JSON.");
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void crear(Alimento a) {
        Alimento[] nuevo = new Alimento[n + 1];
        for (int i=0; i<n; i++) nuevo[i] = alimentos[i];
        nuevo[n] = a;
        alimentos = nuevo;
        n++;
        guardar();
    }


    public void modificar(String nombre, String nuevaFecha, int nuevaCant) {
        for (int i=0; i<n; i++) {
            if (alimentos[i].getNombre().equalsIgnoreCase(nombre)) {
                alimentos[i].setFechaVencimiento(nuevaFecha);
                alimentos[i].setCantidad(nuevaCant);
                guardar();
                return;
            }
        }
        System.out.println("No existe ese alimento.");
    }


    public void eliminar(String nombre) {
        int pos = -1;
        for (int i=0; i<n; i++)
            if (alimentos[i].getNombre().equalsIgnoreCase(nombre))
                pos = i;

        if (pos == -1) return;

        Alimento[] nuevo = new Alimento[n-1];
        for (int i=0, j=0; i<n; i++)
            if (i != pos) nuevo[j++] = alimentos[i];

        alimentos = nuevo;
        n--;
        guardar();
    }

    public void caducadosAntesDe(String fechaX) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date f = sdf.parse(fechaX);
            for (int i=0; i<n; i++) {
                if (sdf.parse(alimentos[i].getFechaVencimiento()).before(f))
                    System.out.println(alimentos[i]);
            }
        } catch (Exception e){ e.printStackTrace(); }
    }


    public void eliminarCantidadCero() {
        int cont=0;
        for (int i=0; i<n; i++)
            if (alimentos[i].getCantidad()>0) cont++;

        Alimento[] nuevo = new Alimento[cont];
        for (int i=0,j=0; i<n; i++)
            if (alimentos[i].getCantidad()>0) nuevo[j++] = alimentos[i];

        alimentos = nuevo;
        n = cont;
        guardar();
    }

    public void alimentosVencidos() {
        String hoy = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        caducadosAntesDe(hoy);
    }


    public void mayorCantidad() {
        if (n==0) return;
        Alimento mayor = alimentos[0];
        for (int i=1; i<n; i++)
            if (alimentos[i].getCantidad()>mayor.getCantidad())
                mayor = alimentos[i];

        System.out.println("Alimento con más cantidad:");
        System.out.println(mayor);
    }
}