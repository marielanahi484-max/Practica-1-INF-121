public class Cliente {
    private int codCliente;
    private int ci;
    private String nombre;
    private String apellido;

    public Cliente(int codCliente, int ci, String nombre, String apellido) {
        this.codCliente = codCliente;
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCodCliente() { return codCliente; }
    public String getNombreCompleto() { return nombre + " " + apellido; }

    public String toString() {
        return codCliente + ";" + ci + ";" + nombre + ";" + apellido;
    }
}
