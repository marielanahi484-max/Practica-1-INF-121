public class Zoologico {
    private int id;
    private String nombre;
    private int nroAnimales;
    private Animal animales[] = new Animal[30];

    public Zoologico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.nroAnimales = 0;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getNroAnimales() { return nroAnimales; }
    public Animal[] getAnimales() { return animales; }

    public void agregar(Animal a) {
        if (nroAnimales < 30) {
            animales[nroAnimales] = a;
            nroAnimales++;
        }
    }

    public void eliminarAnimal(String nombre) {
        for (int i = 0; i < nroAnimales; i++) {
            if (animales[i].getNombre().equalsIgnoreCase(nombre)) {
                animales[i] = animales[nroAnimales - 1];
                nroAnimales--;
            }
        }
    }

    public int contarEspecies() {
        int cont = 0;
        for (int i = 0; i < nroAnimales; i++) cont++;
        return cont;
    }
}
