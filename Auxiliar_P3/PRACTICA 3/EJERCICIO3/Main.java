package EJERCICIO3;

public class Main {
    public static void main(String[] args) {
        ArchivoProducto gestor = new ArchivoProducto(100);
        Producto p1= new Producto(12, "Pelota", 100);
        Producto p2= new Producto(123, "Folder", 15);
        Producto p3= new Producto(124, "Audifono", 25);

        gestor.GuardarProducto(p1);
        gestor.GuardarProducto(p2);
        gestor.GuardarProducto(p3);
        gestor.mostrar();
        gestor.buscarProducto(124);
        gestor.promedioProductos();
        gestor.productoCaro();
        gestor.guardarArchivo();
    }
}
