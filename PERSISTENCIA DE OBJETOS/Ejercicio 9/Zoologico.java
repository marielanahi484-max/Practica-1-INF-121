public class Zoologico {
    private int id;
    private String nombre;
    private int nroAnimales;
    private Animal animales[] = new Animal[30];

    public Zoologico() {}

    public Zoologico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.nroAnimales = 0;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getNroAnimales() { return nroAnimales; }

    public Animal[] getAnimales() { return animales; }

    public void agregarAnimal(Animal a) {
        if(nroAnimales < 30){
            animales[nroAnimales] = a;
            nroAnimales++;
        }
    }

    public boolean estaVacio() {
        return nroAnimales == 0;
    }

    public int getVariedad() {
        int cont = 0;
        for (int i = 0; i < nroAnimales; i++) {
            cont++;
        }
        return cont;
    }

    @Override
    public String toString() {
        return "Zoologico{ id=" + id + ", nombre=" + nombre + ", nroAnimales=" + nroAnimales + " }";
    }
}
