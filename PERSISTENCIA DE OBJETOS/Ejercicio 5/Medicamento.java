public class Medicamento {

    private String nombre;
    private int codMedicamento;
    private String tipo;
    private double precio;

    public Medicamento(String nombre, int codMedicamento, String tipo, double precio) {
        this.nombre = nombre;
        this.codMedicamento = codMedicamento;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public int getCodMedicamento() { return codMedicamento; }
    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCodMedicamento(int codMedicamento) { this.codMedicamento = codMedicamento; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return String.format("Medicamento[nombre=%s, cod=%d, tipo=%s, precio=%.2f]",
                nombre, codMedicamento, tipo, precio);
    }
}
