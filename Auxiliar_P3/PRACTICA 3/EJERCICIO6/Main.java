package EJERCICIO6;

public class Main {
    public static void main(String[] args) {
        ArchLibro archL = new ArchLibro("libros.json");
        ArchCliente archC = new ArchCliente("clientes.json");
        ArchPrestamo archP = new ArchPrestamo("prestamos.json");

        archL.adicionar(new Libro(1, "Java Intro", 50));
        archL.adicionar(new Libro(2, "Estructuras", 70));
        archL.adicionar(new Libro(3, "Calculo I", 40));

        archC.adicionar(new Cliente(111, "Ana", "Lopez"));
        archC.adicionar(new Cliente(222, "Juan", "Perez"));
        archC.adicionar(new Cliente(333, "Luis", "Mamani"));

        archP.adicionar(new Prestamo(111, 1, 2));
        archP.adicionar(new Prestamo(333, 1, 3));
        archP.adicionar(new Prestamo(222, 2, 1));

        archL.guardar();
        archC.guardar();
        archP.guardar();

        archL.listarPorPrecio(40, 70);

        System.out.println("Ingreso libro 1: " +
                archP.ingresoPorLibro(1, archL));

        archL.librosNuncaVendidos(archP);

        archP.clientesPorLibro(1, archC);

        Libro mas = archP.libroMasPrestado(archL);
        System.out.println("Libro más prestado: " + mas.getTitulo());

        Cliente cli = archP.clienteMasPrestamos(archC);
        System.out.println("Cliente con más préstamos: " +
                cli.getNombre() + " " + cli.getApellido());
    }
}
