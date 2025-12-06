package EJERCICIO5;

public class Medicamentos {
    private String nombre, tipo;
    private int codMedicamento;
    private double precio;

    public Medicamentos(String nombre, int codMedicamento, String tipo, double precio) {
        this.nombre = nombre;
        this.codMedicamento = codMedicamento;
        this.tipo = tipo;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Medicamentos:" + "nombre='" + nombre + '\'' + ", tipo='" + tipo + '\'' + ", codMedicamento=" + codMedicamento + ", precio=" + precio + '}';
    }
    public void mostrar() {
        System.out.println("Medicamento: " + nombre +
                ", Tipo: " + tipo +
                ", Precio: " + precio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCodMedicamento() {
        return codMedicamento;
    }

    public void setCodMedicamento(int codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
