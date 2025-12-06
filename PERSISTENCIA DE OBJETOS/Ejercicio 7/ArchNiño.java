import java.util.ArrayList;
import java.util.Scanner;

public class ArchNiño {
    private ArrayList<Niño> niños = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void crear() {
        System.out.print("Cantidad de niños: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Niño " + (i + 1) + " ---");

            System.out.print("Nombre: ");
            String nom = sc.next();

            System.out.print("Apellido Paterno: ");
            String apPat = sc.next();

            System.out.print("Apellido Materno: ");
            String apMat = sc.next();

            System.out.print("CI: ");
            int ci = sc.nextInt();

            System.out.print("Edad: ");
            int edad = sc.nextInt();

            System.out.print("Peso: ");
            float peso = sc.nextFloat();

            System.out.print("Talla: ");
            float talla = sc.nextFloat();

            niños.add(new Niño(nom, apPat, apMat, ci, edad, peso, talla));
        }
    }

    public void listar() {
        System.out.println("\n--- LISTA DE NIÑOS ---");
        for (Niño n : niños) {
            n.mostrar();
            System.out.println("---------------------");
        }
    }

    public void contarPesoAdecuado() {
        int cont = 0;

        for (Niño n : niños) {
            float pesoEsperado = n.getTalla() * 4;
            float min = pesoEsperado * 0.90f;
            float max = pesoEsperado * 1.10f;

            if (n.getPeso() >= min && n.getPeso() <= max) {
                cont++;
            }
        }

        System.out.println("\nNiños con peso adecuado: " + cont);
    }

    public void mostrarNoAdecuados() {
        System.out.println("\n--- Niños NO adecuados ---");
        for (Niño n : niños) {
            float pesoEsperado = n.getTalla() * 4;
            float min = pesoEsperado * 0.90f;
            float max = pesoEsperado * 1.10f;

            if (n.getPeso() < min || n.getPeso() > max) {
                n.mostrar();
                System.out.println("-------------------");
            }
        }
    }

    public void promedioEdad() {
        int suma = 0;

        for (Niño n : niños) {
            suma += n.getEdad();
        }

        float prom = (float) suma / niños.size();
        System.out.println("\nPromedio de edad: " + prom);
    }

    public void buscar() {
        System.out.print("\nCI a buscar: ");
        int x = sc.nextInt();
        boolean encontrado = false;

        for (Niño n : niños) {
            if (n.ci == x) {
                System.out.println("\n--- Encontrado ---");
                n.mostrar();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No existe ese CI.");
        }
    }

    public void mostrarMayorTalla() {
        float max = 0;

        for (Niño n : niños) {
            if (n.getTalla() > max) {
                max = n.getTalla();
            }
        }

        System.out.println("\n--- Niño(s) con la mayor talla ---");
        for (Niño n : niños) {
            if (n.getTalla() == max) {
                n.mostrar();
                System.out.println("---------------------");
            }
        }
    }
}
