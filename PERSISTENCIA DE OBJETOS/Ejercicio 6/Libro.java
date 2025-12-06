public class Libro {
    private int codLibro;
    private String titulo;
    private float precio;

    public Libro(int codLibro, String titulo, float precio) {
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.precio = precio;
    }

    public int getCodLibro() { return codLibro; }
    public String getTitulo() { return titulo; }
    public float getPrecio() { return precio; }

    public String toString() {
        return codLibro + ";" + titulo + ";" + precio;
    }
}
