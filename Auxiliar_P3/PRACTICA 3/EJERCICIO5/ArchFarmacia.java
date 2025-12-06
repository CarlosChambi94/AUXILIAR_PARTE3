package EJERCICIO5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchFarmacia {
    private String na = "farmacia.json";
    private Farmacia[] f = new Farmacia[50];
    private int n  ;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public ArchFarmacia( ) {
        this.na = na;
        this.n = 0;
    }
    public void adicionar(Farmacia x) {
        if (n < f.length) {
            f[n++] = x;
        }
    }
    public void listar() {
        for (int i = 0; i < n; i++) {
            f[i].mostrar();
        }
    }
    public void mostrarTosSucursal(int x){
        for(int i = 0; i < n ; i ++){
            if(f[i].getSucursal() == x){
                f[i].buscaMedicamento("tos");
                return;
            }
        }
    }
    public void buscarTapsin(){
        for(int i = 0; i < n  ; i++){
            Medicamentos m = f[i].buscaMedicamento("Tapsin");
            if(m!=null){
                System.out.println("Tapsin esta en la sucursal: " + f[i].getSucursal() + "Direccion" + f[i].getDireccion());
            }
        }
    }
    public void buscarPorTipo(String tipo){
        for(int i = 0  ; i< n; i++){
            f[i].mostrarMedicamentos(tipo);
        }
    }
    public void ordenarPorDireccion(){
        for (int i = 0 ; i< n-1 ; i++){
            for(int j = i+1 ; j < n ; j++){

                if(f[i].getDireccion().compareTo(f[j].getDireccion())>0){
                    Farmacia aux = f[i];
                    f[i] = f[j];
                    f[j] = aux ;
                }
            }
        }
    }

    public void moverMedicamentos(String tipo, int sucY, int sucZ) {

        Farmacia origen = null;
        Farmacia destino = null;

        for (int i = 0; i < n; i++) {
            if (f[i].getSucursal() == sucY) origen = f[i];
            if (f[i].getSucursal() == sucZ) destino = f[i];
        }

        if (origen == null || destino == null) {
            System.out.println("Sucursal no encontrada.");
            return;
        }

        Medicamentos[] meds = origen.getMedicamentos();

        for (int i = 0; i < origen.getNroMedicamentos(); i++) {
            if (meds[i] != null && meds[i].getTipo().equalsIgnoreCase(tipo)) {
                destino.agregarMedicamento(meds[i]);
                meds[i] = null;
            }
        }

        guardarArchivo();
        System.out.println("Medicamentos movidos con éxito.");
    }
    public void guardarArchivo() {
        try (FileWriter writer = new FileWriter(na)) {

            // Solo guardamos FARMACIAS válidas
            Farmacia[] existentes = new Farmacia[n];
            for (int i = 0; i < n; i++) {
                existentes[i] = f[i];
            }

            gson.toJson(existentes, writer);
            System.out.println("Archivo guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    public void cargarArchivo() {
        try (FileReader reader = new FileReader(na)) {

            Farmacia[] datos = gson.fromJson(reader, Farmacia[].class);

            if (datos != null) {
                n = datos.length;
                for (int i = 0; i < n; i++) {
                    f[i] = datos[i];
                }
            }

            System.out.println("Archivo cargado correctamente.");

        } catch (Exception e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo.");
            guardarArchivo(); // crear archivo vacío
        }
    }


}
