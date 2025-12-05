public class Main {
    public static void main(String[] args) {
        ArchivoCharango arch = new ArchivoCharango("charangos.dat");

        boolean[] cuerdas = {true, false, true, true, false, true, false, true, false, true};
        Charango c1 = new Charango("Madera", 10, cuerdas);
        Charango c2 = new Charango("Metal", 10, new boolean[]{true,true,true,true,true,true,true,true,true,true});
        Charango c3 = new Charango("Madera", 8, new boolean[]{false,false,false,false,false,false,false,false,false,false});

     
        arch.adicionar(c1);
        arch.adicionar(c2);
        arch.adicionar(c3);

        System.out.println("---- LISTAR MATERIAL MADERA ----");
        arch.listarPorMaterial("Madera");

        System.out.println("---- BUSCAR CON 10 CUERDAS ----");
        arch.buscarCon10Cuerdas();

        System.out.println("---- ORDENAR POR MATERIAL ----");
        arch.ordenarPorMaterial();
        arch.listarPorMaterial("Madera"); 

        System.out.println("---- ELIMINAR +6 CUERDAS FALSE ----");
        arch.eliminarMasDe6CuerdasFalse();
        arch.listarPorMaterial("Madera"); 
    }
}
