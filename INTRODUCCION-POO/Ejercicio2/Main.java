package Introduccion_a_POO.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(30);
        bus.subirPasajeros(10);
        bus.mostrarAsientosDisponibles();
        bus.cobrarPasaje();
    }
}
