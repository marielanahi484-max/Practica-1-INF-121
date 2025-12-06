package Introduccion_a_POO.Ejercicio3;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void vender(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            System.out.println("Se vendieron " + cantidad + " productos.");
        } else {
            System.out.println("No hay suficiente stock.");
        }
    }

    public void reabastecer(int cantidad) {
        stock += cantidad;
        System.out.println("Se reabasteció el stock en " + cantidad);
    }

    public void mostrarStock() {
        System.out.println("Stock actual: " + stock);
    }
}
