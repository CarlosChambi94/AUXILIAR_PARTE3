package EJERCICIO2;

public class Main {
    public static void main(String[] args) {
        ArchivoTrabajador gestor = new ArchivoTrabajador(100);
        Trabajador j1 = new Trabajador("Juan", 123, 10);
        Trabajador j2 = new Trabajador("Fabri", 1234, 1000);
        Trabajador j3 = new Trabajador("Leo", 1235, 250);

        gestor.guardarTrabajador(j1);
        gestor.guardarTrabajador(j2);
        gestor.guardarTrabajador(j3);
        gestor.mostrar();

        gestor.aumentarSalario(j1, 70);
        System.out.println("Ordenado");
        gestor.mayorTrabajador();
        gestor.mayorSalario();
        gestor.mostrar();
        gestor.guardarArchivo();

    }
}
