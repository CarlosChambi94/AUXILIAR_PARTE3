package EJERCICIO6;

public class Prestamo {
    private int codCliente;
    private int codLibro;
    private int cantidad;

    public Prestamo(int codCliente, int codLibro, int cantidad) {
        this.codCliente = codCliente;
        this.codLibro = codLibro;
        this.cantidad = cantidad;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public int getCodLibro() {
        return codLibro;
    }

    public int getCantidad() {
        return cantidad;
    }
}
