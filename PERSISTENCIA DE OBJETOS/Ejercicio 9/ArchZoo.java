public class ArchZoo {

    private String nombre;  
    private Zoologico zoos[] = new Zoologico[50];
    private int n = 0;

    public ArchZoo(String nombre) {
        this.nombre = nombre;
    }

    public void crear(Zoologico z) {
        zoos[n] = z;
        n++;
    }

    public void modificar(int id) {
        for (int i = 0; i < n; i++) {
            if (zoos[i].getId() == id) {
                zoos[i] = new Zoologico(id, "Modificado");
            }
        }
    }

    public void eliminar(int id) {
        for (int i = 0; i < n; i++) {
            if (zoos[i].getId() == id) {
                zoos[i] = zoos[n - 1];
                n--;
            }
        }
    }

    public void listarMaxVariedad() {
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (zoos[i].getNroAnimales() > max)
                max = zoos[i].getNroAnimales();
        }

        for (int i = 0; i < n; i++) {
            if (zoos[i].getNroAnimales() == max) {
                System.out.println("Zoo: " + zoos[i].getNombre());
            }
        }
    }


    public void eliminarVacios() {
        for (int i = 0; i < n; i++) {
            if (zoos[i].getNroAnimales() == 0) {
                zoos[i] = zoos[n - 1];
                n--;
                i--;
            }
        }
    }

    public void mostrarEspecie(String esp) {
        for (int i = 0; i < n; i++) {
            for (Animal a : zoos[i].getAnimales()) {
                if (a != null && a.getEspecie().equalsIgnoreCase(esp)) {
                    System.out.println(a.getNombre() + " (" + zoos[i].getNombre() + ")");
                }
            }
        }
    }

    public void moverAnimales(int X, int Y) {
        Zoologico a = null, b = null;

        for (int i = 0; i < n; i++) {
            if (zoos[i].getId() == X) a = zoos[i];
            if (zoos[i].getId() == Y) b = zoos[i];
        }

        if (a != null && b != null) {
            for (Animal x : a.getAnimales()) {
                if (x != null) b.agregar(x);
            }
            a = new Zoologico(X, "Vacio");
        }
    }

    void mostrarPorEspecie(String esp) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void listarEliminarVacios() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void listarMayorVariedad() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void listar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
