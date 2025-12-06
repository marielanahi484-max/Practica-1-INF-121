public class Niño extends Persona {
    private int edad;
    private float peso;
    private float talla;

    public Niño(String nombre, String apPat, String apMat, int ci,
                int edad, float peso, float talla) {
        super(nombre, apPat, apMat, ci);
        this.edad = edad;
        this.peso = peso;
        this.talla = talla;
    }

    public int getEdad() { return edad; }
    public float getPeso() { return peso; }
    public float getTalla() { return talla; }

    public void mostrar() {
        super.mostrar();
        System.out.println("Edad: " + edad);
        System.out.println("Peso: " + peso);
        System.out.println("Talla: " + talla);
    }
}
