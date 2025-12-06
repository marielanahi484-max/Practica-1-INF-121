import java.util.*;

public class Main6 {

    public static void main(String[] args) {

        ArchiLibro aL = new ArchiLibro("libros.txt");
        ArchiCliente aC = new ArchiCliente("clientes.txt");
        ArchiPrestamo aP = new ArchiPrestamo("prestamos.txt");

        aL.agregarLibro(new Libro(1, "Java", 100));
        aL.agregarLibro(new Libro(2, "Python", 150));
        aL.agregarLibro(new Libro(3, "C++", 200));

        aC.agregarCliente(new Cliente(1, 123, "Mariel", "Cayetano"));
        aC.agregarCliente(new Cliente(2, 456, "Aracely", "Chavez"));

        aP.agregarPrestamo(new Prestamo(1, 1, "10/10/2024", 2));
        aP.agregarPrestamo(new Prestamo(2, 1, "11/10/2024", 1));
        aP.agregarPrestamo(new Prestamo(1, 2, "12/10/2024", 3));

        System.out.println("a) Libros entre precio 90 y 160:");
        listarPorPrecio(90,160,aL);

        System.out.println("\nb) Ingreso total del libro 1:");
        System.out.println( ingresoPorLibro(1, aL, aP) );

        System.out.println("\nc) Libros nunca vendidos:");
        librosNoVendidos(aL, aP);

        System.out.println("\nd) Clientes que compraron el libro 1:");
        clientesQueCompraron(1, aC, aP);

        System.out.println("\ne) Libro más prestado:");
        System.out.println( libroMasPrestado(aL,aP) );

        System.out.println("\nf) Cliente con más préstamos:");
        System.out.println( clienteQueMasPresto(aC,aP).getNombreCompleto() );
    }

    public static void listarPorPrecio(float x, float y, ArchiLibro aL) {
        for (Libro l : aL.leerTodos()) {
            if (l.getPrecio() >= x && l.getPrecio() <= y) {
                System.out.println(l);
            }
        }
    }

    public static float ingresoPorLibro(int codLibro, ArchiLibro aL, ArchiPrestamo aP) {
        float precio = 0;
        for (Libro l : aL.leerTodos()) {
            if (l.getCodLibro() == codLibro) precio = l.getPrecio();
        }

        int total = 0;
        for (Prestamo p : aP.leerTodos()) {
            if (p.getCodLibro() == codLibro)
                total += p.getCantidad();
        }

        return total * precio;
    }

    public static void librosNoVendidos(ArchiLibro aL, ArchiPrestamo aP) {
        List<Libro> libros = aL.leerTodos();
        List<Prestamo> prest = aP.leerTodos();

        for (Libro l : libros) {
            boolean vendido = false;
            for (Prestamo p : prest) {
                if (p.getCodLibro() == l.getCodLibro()) vendido = true;
            }
            if (!vendido) System.out.println(l);
        }
    }

    public static void clientesQueCompraron(int codLibro, ArchiCliente aC, ArchiPrestamo aP) {
        List<Cliente> clientes = aC.leerTodos();

        for (Prestamo p : aP.leerTodos()) {
            if (p.getCodLibro() == codLibro) {
                for (Cliente c : clientes) {
                    if (c.getCodCliente() == p.getCodCliente())
                        System.out.println(c.getNombreCompleto());
                }
            }
        }
    }

    public static Libro libroMasPrestado(ArchiLibro aL, ArchiPrestamo aP) {
        Map<Integer, Integer> mapa = new HashMap<>();

        for (Prestamo p : aP.leerTodos()) {
            mapa.put(p.getCodLibro(),
                    mapa.getOrDefault(p.getCodLibro(), 0) + p.getCantidad());
        }

        int maxCod = -1, maxCant = -1;
        for (int cod : mapa.keySet()) {
            if (mapa.get(cod) > maxCant) {
                maxCant = mapa.get(cod);
                maxCod = cod;
            }
        }

        for (Libro l : aL.leerTodos()) {
            if (l.getCodLibro() == maxCod)
                return l;
        }
        return null;
    }


    public static Cliente clienteQueMasPresto(ArchiCliente aC, ArchiPrestamo aP) {
        Map<Integer, Integer> mapa = new HashMap<>();
for (Prestamo p : aP.leerTodos()) {
            mapa.put(p.getCodCliente(),
                    mapa.getOrDefault(p.getCodCliente(), 0) + p.getCantidad());
        }

        int maxCli = -1, maxCant = -1;
        for (int cod : mapa.keySet()) {
            if (mapa.get(cod) > maxCant) {
                maxCant = mapa.get(cod);
                maxCli = cod;
            }
        }

        for (Cliente c : aC.leerTodos()) {
            if (c.getCodCliente() == maxCli)
                return c;
        }
        return null;
    }
}
