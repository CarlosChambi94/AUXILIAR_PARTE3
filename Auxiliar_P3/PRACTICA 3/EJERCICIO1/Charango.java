package EJERCICIO1;

public class Charango {
    private String material;
    private int nroCuerdas;
    private boolean[] cuerdas;

    public Charango(String material, boolean[] cuerdas) {
        this.material = material;
        this.nroCuerdas = cuerdas.length ;
        this.cuerdas = cuerdas;
    }

    public int contarFalso(){
        int c = 0 ;
        for(boolean x : cuerdas ){
            if(!x){
                c++;
            }
        }
        return c  ;
    }

    @Override
    public String toString() {
        return "Charango{" +  "material='" + material + '\'' +  ", nroCuerdas=" + nroCuerdas +  ", cuerdas Falsas =" +  contarFalso() + '}';
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getNroCuerdas() {
        return nroCuerdas;
    }

    public void setNroCuerdas(int nroCuerdas) {
        this.nroCuerdas = nroCuerdas;
    }

    public boolean[] getCuerdas() {
        return cuerdas;
    }

    public void setCuerdas(boolean[] cuerdas) {
        this.cuerdas = cuerdas;
    }
}
