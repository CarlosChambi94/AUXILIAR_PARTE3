package EJERCICIO7;

public class Persona {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int ci;

    public Persona() {}

    public Persona(String nombre, String apP, String apM, int ci) {
        this.nombre = nombre;
        this.apellidoPaterno = apP;
        this.apellidoMaterno = apM;
        this.ci = ci;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCi() {
        return ci;
    }
}
