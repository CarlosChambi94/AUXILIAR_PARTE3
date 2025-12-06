package EJERCICIO6;

public class Cliente {
    private int ci;
    private String nombre;
    private String apellido;

    public Cliente(int ci, String nombre, String apellido) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
