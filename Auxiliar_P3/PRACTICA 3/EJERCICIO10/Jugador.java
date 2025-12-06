package EJERCICIO10;

class Jugador {
    String nombre;
    int nivel;
    int puntaje;

    public Jugador(String nombre, int nivel, int puntaje) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntaje() {
        return puntaje;
    }

    @Override
    public String toString(){
        return nombre + "," + nivel + "," + puntaje;
    }
}