import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        ArchZoo arch = new ArchZoo("zoologicos.dat");
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n===== MENÚ ZOOLÓGICOS =====");
            System.out.println("1. Crear zoológico (interactivo)");
            System.out.println("2. Modificar zoológico por ID");
            System.out.println("3. Eliminar zoológico por ID");
            System.out.println("4. Listar zoológicos");
            System.out.println("5. Listar zoológicos con mayor variedad de animales");
            System.out.println("6. Listar y eliminar zoológicos vacíos");
            System.out.println("7. Mostrar animales de especie X");
            System.out.println("8. Mover animales de un zoológico X a Y");
            System.out.println("0. Salir");
            System.out.print("Elija opción: ");

            // proteger contra inputs no numéricos
            while (!sc.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                sc.next();
            }
            op = sc.nextInt();
            sc.nextLine(); // consumir el salto de línea pendiente

            switch (op) {
                case 1:
                    // método crear() interactivo en ArchZoo
                    arch.crear();
                    break;

                case 2:
                    System.out.print("ID a modificar: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Ingrese un ID válido: ");
                        sc.next();
                    }
                    int idm = sc.nextInt();
                    sc.nextLine();
                    arch.modificar(idm);
                    break;

                case 3:
                    System.out.print("ID a eliminar: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Ingrese un ID válido: ");
                        sc.next();
                    }
                    int ide = sc.nextInt();
                    sc.nextLine();
                    arch.eliminar(ide);
                    break;

                case 4:
                    arch.listar();
                    break;

                case 5:
                    arch.listarMayorVariedad();
                    break;

                case 6:
                    arch.listarEliminarVacios();
                    break;

                case 7:
                    System.out.print("Ingrese especie a buscar: ");
                    String esp = sc.nextLine();
                    arch.mostrarPorEspecie(esp);
                    break;

                case 8:
                    System.out.print("Mover del Zoo ID: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Ingrese un ID válido: ");
                        sc.next();
                    }
                    int x = sc.nextInt();
                    System.out.print("Al Zoo ID: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Ingrese un ID válido: ");
                        sc.next();
                    }
                    int y = sc.nextInt();
                    sc.nextLine();
                    arch.moverAnimales(x, y);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida!");
            }

        } while (op != 0);
    }
}
