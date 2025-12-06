package EJERCICIO4;

public class Main {
    public static void main(String[] args) {
        Archinota gestor = new Archinota(100);
        Estudiante e1 = new Estudiante(101, "Ana", "López", "Mendez", 20);
        Estudiante e2 = new Estudiante(102, "Luis", "Pérez", "Flores", 22);
        Estudiante e3 = new Estudiante(103, "María", "Suarez", "Gomez", 19);

        gestor.agregarnotas(new Nota("Matemáticas", 85, e1));
        gestor.agregarnotas(new Nota("Matemáticas", 95, e2));
        gestor.agregarnotas(new Nota("Programación", 96, e3));
        gestor.mostrar();
        System.out.println("\nPromedio general: " + gestor.obtenerPromedio());
        System.out.println("\nMejor nota:");
        gestor.mejorNota();
        System.out.println("\nEliminar materia Matemáticas");
        gestor.eliminarMateria("Matemáticas");
        gestor.mostrar();
        gestor.guardar();

    }
}
