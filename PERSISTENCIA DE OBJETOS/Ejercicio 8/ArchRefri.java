import java.util.ArrayList;
import java.util.Scanner;

public class ArchRefri {
    private String nombre;
    private ArrayList<Alimento> alimentos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void crear() {
        System.out.print("Cuántos alimentos desea registrar: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Alimento " + (i+1) + " ---");

            System.out.print("Nombre: ");
            String nom = sc.next();

            System.out.print("Fecha de vencimiento (YYYY-MM-DD): ");
            String fv = sc.next();

            System.out.print("Cantidad: ");
            int cant = sc.nextInt();

            alimentos.add(new Alimento(nom, fv, cant));
        }
    }

    public void modificarPorNombre() {
        System.out.print("Nombre del alimento a modificar: ");
        String nom = sc.next();
        boolean encontrado = false;

        for (Alimento a : alimentos) {
            if (a.getNombre().equalsIgnoreCase(nom)) {
                System.out.print("Nueva fecha de vencimiento: ");
                a.setFechaVenc(sc.next());

                System.out.print("Nueva cantidad: ");
                a.setCantidad(sc.nextInt());

                encontrado = true;
                break;
            }
        }

        if (!encontrado) System.out.println("No existe ese alimento.");
    }

    public void eliminarPorNombre() {
        System.out.print("Nombre del alimento a eliminar: ");
        String nom = sc.next();

        alimentos.removeIf(a -> a.getNombre().equalsIgnoreCase(nom));
    }

    public void mostrarCaducadosAntes() {
        System.out.print("Ingresar fecha límite (YYYY-MM-DD): ");
        String fechaX = sc.next();

        System.out.println("\nAlimentos caducados antes de " + fechaX + ":");
        for (Alimento a : alimentos) {
            if (a.getFechaVenc().compareTo(fechaX) < 0) {
                a.mostrar();
                System.out.println("-------------------");
            }
        }
    }

    public void eliminarCantidadCero() {
        alimentos.removeIf(a -> a.getCantidad() == 0);
        System.out.println("Eliminados todos los alimentos con cantidad 0.");
    }

    public void buscarVencidos() {
        System.out.println("\n--- Alimentos Vencidos ---");
        String hoy = "2025-12-05"; 

        for (Alimento a : alimentos) {
            if (a.getFechaVenc().compareTo(hoy) < 0) {
                a.mostrar();
                System.out.println("-------------------");
            }
        }
    }

    public void mostrarMayorCantidad() {
        if (alimentos.isEmpty()) return;

        int max = 0;
        for (Alimento a : alimentos) {
            if (a.getCantidad() > max) max = a.getCantidad();
        }

        System.out.println("\nAlimentos con mayor cantidad (" + max + "):");
        for (Alimento a : alimentos) {
            if (a.getCantidad() == max) {
                a.mostrar();
                System.out.println("--------------------");
            }
        }
    }

    public void listar() {
        System.out.println("\n--- Lista de Alimentos ---");
        for (Alimento a : alimentos) {
            a.mostrar();
            System.out.println("------------------");
        }
    }
}
