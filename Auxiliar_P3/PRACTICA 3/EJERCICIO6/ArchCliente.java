package EJERCICIO6;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;

public class ArchCliente {
    private String nomArch;
    private Cliente[] clientes;
    private int n;

    private Gson gson = new Gson();

    public ArchCliente(String nomArch) {
        this.nomArch = nomArch;
        this.clientes = new Cliente[100];
        this.n = 0;
        cargar();
    }

    public void adicionar(Cliente c) {
        clientes[n++] = c;
    }

    public Cliente buscar(int ci) {
        for (int i = 0; i < n; i++) {
            if (clientes[i].getCi() == ci)
                return clientes[i];
        }
        return null;
    }

    public Cliente[] getClientes() { return clientes; }
    public int getN() { return n; }



    public void guardar() {
        try (FileWriter w = new FileWriter(nomArch)) {
            Cliente[] arr = new Cliente[n];
            for (int i = 0; i < n; i++) arr[i] = clientes[i];
            gson.toJson(arr, w);
            System.out.println("Clientes guardados.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void cargar() {
        try (FileReader r = new FileReader(nomArch)) {
            Cliente[] arr = gson.fromJson(r, Cliente[].class);
            if (arr != null) {
                for (int i = 0; i < arr.length; i++)
                    clientes[i] = arr[i];
                n = arr.length;
            }
        } catch (Exception e) {

        }
    }
}
