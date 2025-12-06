public class Jugador {
    private String nombre;
    private int nivel;
    private int puntaje;

    public Jugador(String nombre, int nivel, int puntaje) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntaje = puntaje;
    }

    public String getNombre() { return nombre; }
    public int getNivel() { return nivel; }
    public int getPuntaje() { return puntaje; }

    @Override
    public String toString() {
        return nombre + "," + nivel + "," + puntaje;
    }

    public static Jugador fromString(String linea) {
        String[] p = linea.split(",");
        return new Jugador(p[0], Integer.parseInt(p[1]), Integer.parseInt(p[2]));
    }
}
