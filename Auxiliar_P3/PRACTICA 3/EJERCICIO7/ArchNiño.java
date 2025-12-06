package EJERCICIO7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;

public class ArchNiño {

    private String nomArch;
    private Niño[] niños;
    private int n;


    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArchNiño(String nomArch) {
        this.nomArch = nomArch;
        this.niños = new Niño[100];
        this.n = 0;
        cargar();
    }

    public void agregar(Niño x) {
        niños[n++] = x;
        guardar();
    }

    public Niño buscar(int ci) {
        for (int i = 0; i < n; i++) {
            if (niños[i].getCi() == ci)
                return niños[i];
        }
        return null;
    }

    public void listar() {
        for (int i = 0; i < n; i++)
            System.out.println(niños[i]);
    }



    private void cargar() {
        try (FileReader r = new FileReader(nomArch)) {

            Niño[] datos = gson.fromJson(r, Niño[].class);

            if (datos != null) {
                for (Niño x : datos)
                    niños[n++] = x;
            }

        } catch (Exception e) {
        }
    }

    private void guardar() {
        try (FileWriter w = new FileWriter(nomArch)) {

            Niño[] aux = new Niño[n];
            for (int i = 0; i < n; i++) aux[i] = niños[i];

            gson.toJson(aux, w);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public int pesoAdecuado() {
        int cont = 0;
        for (int i = 0; i < n; i++) {
            Niño x = niños[i];

            if (x.getEdad() <= 3 && x.getTalla().equals("baja") && x.getPeso().equals("bajo"))
                cont++;

            if (x.getEdad() >= 4 && x.getEdad() <= 7 && x.getTalla().equals("media") && x.getPeso().equals("normal"))
                cont++;

            if (x.getEdad() > 7 && x.getTalla().equals("alta") && x.getPeso().equals("alto"))
                cont++;
        }
        return cont;
    }


    public void noAdecuados() {
        for (int i = 0; i < n; i++) {
            Niño x = niños[i];
            boolean ok = false;

            if (x.getEdad() <= 3 && x.getTalla().equals("baja") && x.getPeso().equals("bajo"))
                ok = true;

            if (x.getEdad() >= 4 && x.getEdad() <= 7 && x.getTalla().equals("media") && x.getPeso().equals("normal"))
                ok = true;

            if (x.getEdad() > 7 && x.getTalla().equals("alta") && x.getPeso().equals("alto"))
                ok = true;

            if (!ok) System.out.println(x);
        }
    }


    public double promedioEdad() {
        if (n == 0) return 0;
        int suma = 0;
        for (int i = 0; i < n; i++) suma += niños[i].getEdad();
        return suma / (double) n;
    }

    public Niño buscarCarnet(int ci) {
        return buscar(ci);
    }


    public void tallaMasAlta() {
        int max = 0;

        for (int i = 0; i < n; i++)
            max = Math.max(max, Integer.parseInt(niños[i].getTalla()));

        for (int i = 0; i < n; i++)
            if (Integer.parseInt(niños[i].getTalla()) == max)
                System.out.println(niños[i]);
    }
}