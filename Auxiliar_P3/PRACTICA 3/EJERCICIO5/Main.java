package EJERCICIO5;

public class Main {
    public static void main(String[] args) {
        ArchFarmacia arch = new ArchFarmacia();
        Medicamentos m1 = new Medicamentos("Tapsin", 101, "resfrio", 12.5);
        Medicamentos m2 = new Medicamentos("Bisolvon", 102, "tos", 15.0);
        Medicamentos m3 = new Medicamentos("FluStop", 103, "resfrio", 9.8);
        Medicamentos m4 = new Medicamentos("ExpectoranteX", 104, "tos", 11.3);
        Medicamentos m5 = new Medicamentos("Panadol", 105, "dolor", 7.0);
        Farmacia f1 = new Farmacia("Farmacia Central", 1, "ZAv. Siempre Viva 123", 1000);
        f1.agregarMedicamento(m1);
        f1.agregarMedicamento(m2);

        Farmacia f2 = new Farmacia("Farmacia Salud", 2, "Calle Sol 456", 1000);
        f2.agregarMedicamento(m3);
        f2.agregarMedicamento(m4);
        f2.agregarMedicamento(m5);

        Farmacia f3 = new Farmacia("Farmacia Popular", 3, "Av. 6 de agosto 789", 1000);
        f3.agregarMedicamento(m2);
        f3.agregarMedicamento(m1);
        arch.adicionar(f1);
        arch.adicionar(f2);
        arch.adicionar(f3);

        System.out.println("\nMedicamentos para la tos de sucursal ");
        arch.mostrarTosSucursal(2);

        System.out.println("\n Sucursal y dirección donde se encuentra Tapsin ");
        arch.buscarTapsin();

        System.out.println("\nBuscar medicamentos del tipo 'resfrio' ");
        arch.buscarPorTipo("resfrio");

        System.out.println("\nOrdenar farmacias por dirección ");
        arch.ordenarPorDireccion();
        arch.listar();

        System.out.println("\nMover los medicamentos ");
        arch.moverMedicamentos("tos", 1, 3);
        arch.listar();
        arch.guardarArchivo();
    }
}
