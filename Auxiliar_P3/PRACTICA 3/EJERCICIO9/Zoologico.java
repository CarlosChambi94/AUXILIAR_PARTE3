package EJERCICIO9;

public class Zoologico {
    int id;
    String nombre;
    int nroAnimales;
    Animal animales[] = new Animal[30];

    public Zoologico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.nroAnimales = 0;
    }

    public void agregarAnimal(Animal a){
        if(nroAnimales < 30){
            animales[nroAnimales++] = a;
        }
    }

    public String toString(){
        return "["+id+"] "+nombre+"  Animales:"+nroAnimales;
    }
}
