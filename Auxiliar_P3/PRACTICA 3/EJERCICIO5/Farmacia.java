package EJERCICIO5;

public class Farmacia {
    private String nombreFarmacia, direccion;
    private int sucursal;
    private int nroMedicamentos;
    private Medicamentos[] m;

    public Farmacia(String nombreFarmacia, int sucursal, String direccion,  int capacidad) {
        this.nombreFarmacia = nombreFarmacia;
        this.direccion = direccion;
        this.sucursal = sucursal;
        this.nroMedicamentos = 0;
        this.m = new Medicamentos[capacidad];
    }
    public void agregarMedicamento(Medicamentos x) {
        if (nroMedicamentos < m.length) {
            m[nroMedicamentos++] = x;
        }
    }

    public int getSucursal() {
        return sucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void mostrarMedicamentos(String tipo) {
        System.out.println("Medicamentos tipo: " + tipo);
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getTipo().equalsIgnoreCase(tipo)) {
                m[i].mostrar();
            } else {
                System.out.println("NO encontrado");
            }
        }
    }

    public Medicamentos buscaMedicamento(String nombre) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getNombre().equalsIgnoreCase(nombre)) {
                return m[i];
            }
        }
        return null;
    }

    public void mostrar() {
        System.out.println("Farmacia: " + nombreFarmacia +
                ", Sucursal: " + sucursal +
                ", Dirección: " + direccion);
    }

    public int getNroMedicamentos() {
        return nroMedicamentos;
    }

    public Medicamentos[] getMedicamentos() {
        return m;
    }
}
