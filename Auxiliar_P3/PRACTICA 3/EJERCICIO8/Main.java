package EJERCICIO8;

public class Main {
    public static void main(String[] args) {

        ArchRefri refri = new ArchRefri("refri.json");
        System.out.println("\n--- CARGANDO DATOS DE PRUEBA ---");

        refri.crear(new Alimento("Leche", "05/12/2025", 2));
        refri.crear(new Alimento("Yogurt", "01/12/2025", 0));
        refri.crear(new Alimento("Queso", "10/01/2026", 5));
        refri.crear(new Alimento("Tomate", "29/11/2025", 3));

        refri.modificar("Tomate", "30/11/2025", 4);

        refri.eliminar("Leche");

        System.out.println(" Alimentos caducados antes del 02/12/2025 ");
        refri.caducadosAntesDe("02/12/2025");

        System.out.println("Eliminando alimentos con cantidad ");
        refri.eliminarCantidadCero();

        System.out.println("Alimentos vencidos (hoy) ---");
        refri.alimentosVencidos();

        System.out.println("Alimento con más cantidad ");
        refri.mayorCantidad();

        System.out.println("FIN DE EJECUCIÓN.");
    }
}
