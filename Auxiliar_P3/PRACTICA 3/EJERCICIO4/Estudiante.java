package EJERCICIO4;

public class Estudiante {
    private String nombre, paterno , materno;
    private int edad, ru;

    public Estudiante(int ru, String nombre, String paterno, String materno, int edad) {
        this.ru = ru;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Estudiante:" + "nombre='" + nombre + '\'' + ", paterno='" + paterno + '\'' + ", materno='" + materno + '\'' + ", edad=" + edad + ", ru=" + ru ;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public int getEdad() {
        return edad;
    }

    public String getMaterno() {
        return materno;
    }

    public int getRu() {
        return ru;
    }
}
