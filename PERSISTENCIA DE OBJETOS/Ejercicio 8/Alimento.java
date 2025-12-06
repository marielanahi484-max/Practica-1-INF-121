public class Alimento {
    private String nombre;
    private String fechaVencimiento;
    private int cantidad;

    public Alimento(String nombre, String fechaVenc, int cantidad) {
        this.nombre = nombre;
        this.fechaVencimiento = fechaVenc;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public String getFechaVenc() { return fechaVencimiento; }
    public int getCantidad() { return cantidad; }

    public void setFechaVenc(String f) { fechaVencimiento = f; }
    public void setCantidad(int c) { cantidad = c; }

    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Fecha Vencimiento: " + fechaVencimiento);
        System.out.println("Cantidad: " + cantidad);
    }
}
