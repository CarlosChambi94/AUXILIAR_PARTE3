package EJERCICIO7;

public class Niño extends Persona {
    private int edad;
    private String peso;
    private String talla;

    public Niño() {}

    public Niño(String nombre, String apP, String apM, int ci,
                int edad, String peso, String talla) {
        super(nombre, apP, apM, ci);
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    public int getEdad() { return edad; }
    public String getPeso() { return peso; }
    public String getTalla() { return talla; }

    @Override
    public String toString() {
        return getNombre() + " " + getApellidoPaterno() + " " + getApellidoMaterno() +
                " | CI: " + getCi() +
                " | Edad: " + edad +
                " | Peso: " + peso +
                " | Talla: " + talla;
    }
}
