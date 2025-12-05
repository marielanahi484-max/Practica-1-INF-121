import java.util.*;

public class Main3 {
    public static void main(String[] args) {

        ArchivoNota arch = new ArchivoNota("notas.dat");
        arch.crearArchivo();

        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar estudiante + nota");
            System.out.println("2. Agregar varios estudiantes");
            System.out.println("3. Promedio de notas");
            System.out.println("4. Mejor(es) nota(s)");
            System.out.println("5. Eliminar materia");
            System.out.println("6. Listar todo");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch(op) {

                case 1:
                    System.out.print("RU: "); int ru = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: "); String nom = sc.nextLine();
                    System.out.print("Paterno: "); String pat = sc.nextLine();
                    System.out.print("Materno: "); String mat = sc.nextLine();
                    System.out.print("Edad: "); int edad = sc.nextInt(); sc.nextLine();

                    System.out.print("Materia: "); String materia = sc.nextLine();
                    System.out.print("Nota Final: "); float notaF = sc.nextFloat(); sc.nextLine();

                    Estudiante e = new Estudiante(ru, nom, pat, mat, edad);
                    arch.agregarNota(new Nota(materia, notaF, e));
                    break;

                case 2:
                    List<Nota> varias = new ArrayList<>();
                    System.out.print("¿Cuántos estudiantes desea agregar?: ");
                    int n = sc.nextInt(); sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.println("\nEstudiante " + (i+1));

                        System.out.print("RU: "); ru = sc.nextInt(); sc.nextLine();
                        System.out.print("Nombre: "); nom = sc.nextLine();
                        System.out.print("Paterno: "); pat = sc.nextLine();
                        System.out.print("Materno: "); mat = sc.nextLine();
                        System.out.print("Edad: "); edad = sc.nextInt(); sc.nextLine();

                        System.out.print("Materia: "); materia = sc.nextLine();
                        System.out.print("Nota Final: "); notaF = sc.nextFloat(); sc.nextLine();

                        varias.add(new Nota(materia, notaF, 
                                   new Estudiante(ru, nom, pat, mat, edad)));
                    }

                    arch.agregarVariasNotas(varias);
                    break;

                case 3:
                    System.out.println("Promedio: " + arch.promedioNotas());
                    break;

                case 4:
                    System.out.println("Mejores notas:");
                    for (Nota no : arch.mejoresNotas())
                        System.out.println(no);
                    break;

                case 5:
                    System.out.print("Materia a eliminar: ");
                    materia = sc.nextLine();
                    arch.eliminarMateria(materia);
                    break;

                case 6:
                    System.out.println("Listado:");
                    for (Nota no : arch.listar())
                        System.out.println(no);
                    break;
            }

        } while (op != 7);
    }
}
