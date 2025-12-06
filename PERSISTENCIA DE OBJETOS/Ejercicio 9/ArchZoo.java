public class ArchZoo {
    private Zoologico lista[] = new Zoologico[10];
    private int n = 0;

 
    public void crear(Zoologico z){
        if(n < 10){
            lista[n] = z;
            n++;
        }
    }

    public void modificar(int id, String nuevoNombre){
        for(int i=0;i<n;i++){
            if(lista[i].getId() == id){
                lista[i] = new Zoologico(id, nuevoNombre);
            }
        }
    }


    public void eliminar(int id){
        for(int i=0;i<n;i++){
            if(lista[i].getId() == id){
                for(int j=i; j<n-1; j++){
                    lista[j] = lista[j+1];
                }
                n--;
                break;
            }
        }
    }

    public void listarMayorVariedad(){
        int max = 0;
        for(int i=0;i<n;i++){
            if(lista[i].getVariedad() > max)
                max = lista[i].getVariedad();
        }

        System.out.println("\nZoológicos con mayor variedad (" + max + "):");
        for(int i=0;i<n;i++){
            if(lista[i].getVariedad() == max){
                System.out.println(lista[i]);
            }
        }
    }

    public void eliminarVacios(){
        for(int i=0;i<n;i++){
            if(lista[i].estaVacio()){
                System.out.println("Eliminando zoológico vacío: " + lista[i].getNombre());
                eliminar(lista[i].getId());
                i--;
            }
        }
    }

    public void mostrarEspecie(String especie){
        System.out.println("\nAnimales de la especie " + especie + ":");
        for(int i=0;i<n;i++){
            Animal[] a = lista[i].getAnimales();
            for(int j=0;j<lista[i].getNroAnimales(); j++){
                if(a[j].getEspecie().equalsIgnoreCase(especie)){
                    System.out.println(a[j] + " - En zoológico: " + lista[i].getNombre());
                }
            }
        }
    }

    public void moverAnimales(int idX, int idY){
        Zoologico zx = null, zy = null;

        for(int i=0;i<n;i++){
            if(lista[i].getId() == idX) zx = lista[i];
            if(lista[i].getId() == idY) zy = lista[i];
        }

        if(zx == null || zy == null){
            System.out.println("Error: zoológicos no encontrados");
            return;
        }

        Animal[] ax = zx.getAnimales();
        for(int i=0;i<zx.getNroAnimales();i++){
            zy.agregarAnimal(ax[i]);
        }

        zx = new Zoologico(idX, zx.getNombre());
        System.out.println("Animales movidos de " + idX + " a " + idY);
    }

    public void mostrarTodo(){
        for(int i=0;i<n;i++){
            System.out.println(lista[i]);
        }
    }
}
