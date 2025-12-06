package EJERCICIO6;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;

public class ArchLibro {
    private String nomArch;
    private Libro[] libros;
    private int n;

    private Gson gson = new Gson();

    public ArchLibro(String nomArch) {
        this.nomArch = nomArch;
        this.libros = new Libro[100];
        this.n = 0;
        cargar();
    }

    public void adicionar(Libro l) {
        libros[n++] = l;
    }

    public Libro buscar(int cod) {
        for (int i = 0; i < n; i++) {
            if (libros[i].getCodLibro() == cod)
                return libros[i];
        }
        return null;
    }

    public Libro[] getLibros() { return libros; }
    public int getN() { return n; }



    public void guardar() {
        try (FileWriter w = new FileWriter(nomArch)) {

            Libro[] existentes = new Libro[n];
            for (int i = 0; i < n; i++)
                existentes[i] = libros[i];

            gson.toJson(existentes, w);
            System.out.println("Libros guardados.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void cargar() {
        try (FileReader r = new FileReader(nomArch)) {

            Libro[] arr = gson.fromJson(r, Libro[].class);

            if (arr != null) {
                for (int i = 0; i < arr.length; i++)
                    libros[i] = arr[i];
                n = arr.length;
            }

        } catch (Exception e) {

        }
    }


    public void listarPorPrecio(double x, double y) {
        System.out.println("\nLibros entre " + x + " y " + y + ":");
        for (int i = 0; i < n; i++) {
            Libro l = libros[i];
            if (l.getPrecio() >= x && l.getPrecio() <= y) {
                System.out.println(l.getTitulo() + " - " + l.getPrecio());
            }
        }
    }


    public void librosNuncaVendidos(ArchPrestamo archP) {
        System.out.println("\nLibros nunca vendidos:");
        for (int i = 0; i < n; i++) {
            Libro l = libros[i];
            boolean vendido = false;
            for (int j = 0; j < archP.getN(); j++) {
                if (archP.getPrestamos()[j].getCodLibro() == l.getCodLibro()) {
                    vendido = true;
                    break;
                }
            }
            if (!vendido)
                System.out.println(l.getTitulo());
        }
    }
}
