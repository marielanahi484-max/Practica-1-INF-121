import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArchivoProducto arch = new ArchivoProducto("productos.dat");

        arch.crearArchivo();

        int op;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar producto");
            System.out.println("2. Buscar producto por codigo");
            System.out.println("3. Promedio de precios");
            System.out.println("4. Producto más caro");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            op = sc.nextInt();

            switch(op) {
                case 1:
                    System.out.print("Codigo: ");
                    int c = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Precio: ");
                    float p = sc.nextFloat();

                    arch.guardaProducto(new Producto(c, n, p));
                    break;

                case 2:
                    System.out.print("Codigo a buscar: ");
                    int cb = sc.nextInt();
                    Producto encontrado = arch.buscaProducto(cb);
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("No existe.");
                    }
                    break;

                case 3:
                    System.out.println("Promedio = " + arch.promedioPrecios());
                    break;

                case 4:
                    Producto caro = arch.productoMasCaro();
                    if (caro != null) System.out.println("Más caro: " + caro);
                    else System.out.println("No hay productos.");
                    break;
            }
        } while(op != 5);
    }
}
