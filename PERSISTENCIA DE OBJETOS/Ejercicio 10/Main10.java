import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorJugadores gestor = new GestorJugadores();
        int op;

        do {
            System.out.println("\n========= MENÚ JUGADORES =========");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Mostrar jugadores");
            System.out.println("3. Buscar jugador");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            op = sc.nextInt();
            sc.nextLine(); 

            switch (op) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Nivel: ");
                    int nivel = sc.nextInt();

                    System.out.print("Puntaje: ");
                    int puntaje = sc.nextInt();

                    gestor.guardarJugador(new Jugador(nombre, nivel, puntaje));
                    break;

                case 2:
                    gestor.mostrarTodos();
                    break;

                case 3:
                    System.out.print("Ingrese nombre a buscar: ");
                    String nb = sc.nextLine();
                    gestor.buscarJugador(nb);
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (op != 4);
    }
}
