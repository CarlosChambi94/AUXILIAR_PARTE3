package EJERCICIO9;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;

public class ArchZoo {

    private String archivo;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private Zoologico[] zoos;
    private int n;

    public ArchZoo(String archivo) {
        this.archivo = archivo;
        this.zoos = cargar();
        n = zoos.length;
    }

    private Zoologico[] cargar() {
        try (FileReader fr = new FileReader(archivo)) {
            Zoologico[] data = gson.fromJson(fr, Zoologico[].class);
            return (data != null) ? data : new Zoologico[0];
        } catch (Exception e) {
            return new Zoologico[0];
        }
    }

    private void guardar() {
        try (FileWriter fw = new FileWriter(archivo)) {
            gson.toJson(zoos, fw);
        } catch (Exception e) {
        }
    }
    public void crear(Zoologico z){
        Zoologico nuevo[] = new Zoologico[n+1];
        for(int i=0;i<n;i++) nuevo[i]=zoos[i];
        nuevo[n]=z;
        zoos=nuevo;
        n++;
        guardar();
    }

    public void modificar(int id, String nuevoNombre){
        for(int i=0;i<n;i++){
            if(zoos[i].id==id){
                zoos[i].nombre=nuevoNombre;
                guardar();
                return;
            }
        }
    }

    public void eliminar(int id){
        int pos=-1;
        for(int i=0;i<n;i++) if(zoos[i].id==id) pos=i;
        if(pos==-1)return;

        Zoologico nuevo[]=new Zoologico[n-1];
        for(int i=0,j=0;i<n;i++) if(i!=pos) nuevo[j++]=zoos[i];

        zoos=nuevo; n--;
        guardar();
    }
    public void mayorVariedad(){
        if(n==0)return;

        Zoologico mayor = zoos[0];
        for(int i=1;i<n;i++)
            if(zoos[i].nroAnimales > mayor.nroAnimales)
                mayor = zoos[i];

        System.out.println("Zoológico con mayor variedad:");
        System.out.println(mayor);
    }
    public void eliminarVacios(){
        int cont=0;
        for(int i=0;i<n;i++) if(zoos[i].nroAnimales>0) cont++;

        Zoologico nuevo[]=new Zoologico[cont];
        for(int i=0,j=0;i<n;i++)
            if(zoos[i].nroAnimales>0) nuevo[j++]=zoos[i];

        zoos=nuevo; n=cont;
        guardar();
        System.out.println("Zoológicos vacíos eliminados.");
    }
    public void animalesDe(String especie){
        for(int i=0;i<n;i++){
            for(int j=0;j<zoos[i].nroAnimales;j++){
                if(zoos[i].animales[j].especie.equalsIgnoreCase(especie))
                    System.out.println("Zoo "+zoos[i].nombre+": "+zoos[i].animales[j]);
            }
        }
    }
    public void mover(int idOrigen,int idDestino){
        Zoologico o=null,d=null;
        for(Zoologico z:zoos){
            if(z.id==idOrigen) o=z;
            if(z.id==idDestino) d=z;
        }
        if(o==null||d==null)return;

        for(int i=0;i<o.nroAnimales;i++)
            d.agregarAnimal(o.animales[i]);

        o.nroAnimales=0;
        System.out.println("Animales movidos de Zoo "+idOrigen+" a"+idDestino);
        guardar();
    }
}


