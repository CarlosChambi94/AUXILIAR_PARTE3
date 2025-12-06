package EJERCICIO1;

public class Main {
    public static void main(String[] args) {
        GestorCharango gestor = new GestorCharango(100);
        boolean[] c1 = {true,true,false,false,false,true,true,true,false,false};
        boolean[] c2 = {true,true,true,true,true,true,true,true,true,true};
        boolean[] c3 = {false,false,false,false,false,false,false,true,false,false};

        gestor.agregarCharango(new Charango("Zmadera", c1));
        gestor.agregarCharango(new Charango("Madera", c2));
        gestor.agregarCharango(new Charango("plastico", c3));

        System.out.println("Inicial");
        gestor.mostrar();
        gestor.EliminarCharangos();
        System.out.println("Borrando cuerdas fakes ");
        gestor.mostrar();
        gestor.material("plastico ");
        System.out.println("Charango con 10 cuerdas");
        gestor.buscarCharango();
        System.out.println("Ordenar charango por material");
        gestor.ordenar();
        gestor.mostrar();
        gestor.guardarArchivo();

    }
}
