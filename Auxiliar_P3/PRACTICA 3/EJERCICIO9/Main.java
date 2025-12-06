package EJERCICIO9;

public class Main {
    public static void main(String[] args) {

        ArchZoo z = new ArchZoo("zoO.json");

        Zoologico z1=new Zoologico(1,"Safari");
        z1.agregarAnimal(new Animal("Felino","Tigre",4));
        z1.agregarAnimal(new Animal("Reptil","Cocodrilo",3));

        Zoologico z2=new Zoologico(2,"Amazónico");
        z2.agregarAnimal(new Animal("Ave","Guacamayo",10));
        Zoologico z3 =new Zoologico(3,"Ártico");
        z.crear(z1);
        z.crear(z2);
        z.crear(z3);
        System.out.println(" variedad:");
        z.mayorVariedad();
        System.out.println(" Eliminando vacios");
        z.eliminarVacios();
        System.out.println(" Animales de especie 'Felino':");
        z.animalesDe("Felino");
        System.out.println(" Mover del Zoo 1 al 2:");
        z.mover(1,2);

    }
}
