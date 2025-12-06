package EJERCICIO4;

public class Nota {
    private String materia;
    private int notaFinal;
    private Estudiante estudiante;

    public Nota(String materno, int notaFina, Estudiante estudiante) {
        this.materia = materno;
        this.notaFinal = notaFina;
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Nota:" + "materia='" + materia + '\'' + ", notaFina=" + notaFinal + ", estudiante=" + estudiante;
    }

    public String getMateria() {
        return materia;
    }

    public int getNotaFina() {
        return notaFinal;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
}
