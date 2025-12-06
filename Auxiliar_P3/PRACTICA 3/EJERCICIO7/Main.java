package EJERCICIO7;

public class Main {
    public static void main(String[] args) {

        ArchNiño arch = new ArchNiño("niñoS.json");

        arch.agregar(new Niño("Luis", "Perez", "Mamani", 123,
                5, "normal", "110"));

        arch.agregar(new Niño("Ana", "Quispe", "Lopez", 456,
                8, "alto", "120"));

        arch.agregar(new Niño("Mario", "Choque", "Vera", 789,
                3, "bajo", "130"));

        System.out.println("LISTA:");
        arch.listar();

        System.out.println("Niños con peso adecuado: " + arch.pesoAdecuado());

        System.out.println("Niños NO adecuados:");
        arch.noAdecuados();

        System.out.println("Promedio edad: " + arch.promedioEdad());

        System.out.println("Buscar CI 456:");
        System.out.println(arch.buscarCarnet(456));

        System.out.println("Niños con la talla más alta:");
        arch.tallaMasAlta();
    }
}

