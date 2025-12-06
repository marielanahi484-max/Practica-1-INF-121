public class Main9 {
    public static void main(String[] args) {

        ArchZoo arch = new ArchZoo();

   
        Zoologico z1 = new Zoologico(1, "Zoo La Paz");
        Zoologico z2 = new Zoologico(2, "Zoo Santa Cruz");

        arch.crear(z1);
        arch.crear(z2);

        z1.agregarAnimal(new Animal("Tigre", "Bengala", 2));
        z1.agregarAnimal(new Animal("Mono", "Capuchino", 4));

        z2.agregarAnimal(new Animal("Tigre", "Siberiano", 1));

        System.out.println("Listado inicial:");
        arch.mostrarTodo();

        arch.listarMayorVariedad();

        arch.mostrarEspecie("tigre");

        arch.moverAnimales(1, 2);

        System.out.println("\nLuego de mover:");
        arch.mostrarTodo();

        arch.eliminarVacios();
    }
}
