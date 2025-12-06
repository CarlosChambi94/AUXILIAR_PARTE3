package EJERCICIO6;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;

public class ArchPrestamo {
    private String nomArch;
    private Prestamo[] prestamos;
    private int n;

    private Gson gson = new Gson();

    public ArchPrestamo(String nomArch) {
        this.nomArch = nomArch;
        this.prestamos = new Prestamo[100];
        this.n = 0;
        cargar();
    }

    public void adicionar(Prestamo p) {
        prestamos[n++] = p;
    }

    public Prestamo[] getPrestamos() { return prestamos; }
    public int getN() { return n; }


    public void guardar() {
        try (FileWriter w = new FileWriter(nomArch)) {
            Prestamo[] arr = new Prestamo[n];
            for (int i = 0; i < n; i++) arr[i] = prestamos[i];
            gson.toJson(arr, w);
            System.out.println("Prestamos guardados.");
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void cargar() {
        try (FileReader r = new FileReader(nomArch)) {
            Prestamo[] arr = gson.fromJson(r, Prestamo[].class);
            if (arr != null) {
                for (int i = 0; i < arr.length; i++)
                    prestamos[i] = arr[i];
                n = arr.length;
            }
        } catch (Exception e) { }
    }

    public double ingresoPorLibro(int codLibro, ArchLibro archL) {
        double total = 0;
        Libro l = archL.buscar(codLibro);

        for (int i = 0; i < n; i++) {
            Prestamo p = prestamos[i];
            if (p.getCodLibro() == codLibro) {
                total += p.getCantidad() * l.getPrecio();
            }
        }
        return total;
    }


    public void clientesPorLibro(int codLibro, ArchCliente archC) {
        System.out.println("\nClientes que compraron el libro " + codLibro + ":");

        for (int i = 0; i < n; i++) {
            Prestamo p = prestamos[i];
            if (p.getCodLibro() == codLibro) {
                Cliente c = archC.buscar(p.getCodCliente());
                System.out.println(c.getNombre() + " " + c.getApellido());
            }
        }
    }


    public Libro libroMasPrestado(ArchLibro archL) {
        int[] cont = new int[archL.getN()];

        for (int i = 0; i < n; i++) {
            Prestamo p = prestamos[i];

            for (int j = 0; j < archL.getN(); j++) {
                if (archL.getLibros()[j].getCodLibro() == p.getCodLibro()) {
                    cont[j] += p.getCantidad();
                }
            }
        }

        int max = -1, idx = -1;
        for (int i = 0; i < cont.length; i++) {
            if (cont[i] > max) {
                max = cont[i];
                idx = i;
            }
        }

        return idx == -1 ? null : archL.getLibros()[idx];
    }

    public Cliente clienteMasPrestamos(ArchCliente archC) {
        int[] cont = new int[archC.getN()];

        for (int i = 0; i < n; i++) {
            Prestamo p = prestamos[i];

            for (int j = 0; j < archC.getN(); j++) {
                if (archC.getClientes()[j].getCi() == p.getCodCliente()) {
                    cont[j] += p.getCantidad();
                }
            }
        }

        int max = -1, idx = -1;
        for (int i = 0; i < cont.length; i++) {
            if (cont[i] > max) {
                max = cont[i];
                idx = i;
            }
        }

        return idx == -1 ? null : archC.getClientes()[idx];
    }
}
