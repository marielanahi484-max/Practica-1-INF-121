import java.io.*;
import java.util.*;

public class ArchiPrestamo {
    private String nomArch;

    public ArchiPrestamo(String nomArch) {
        this.nomArch = nomArch;
    }

    public void agregarPrestamo(Prestamo p) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomArch, true))) {
            pw.println(p.toString());
        } catch (Exception e) {
            System.out.println("Error al guardar préstamo.");
        }
    }

    public List<Prestamo> leerTodos() {
        List<Prestamo> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomArch))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(";");
                lista.add(new Prestamo(
                        Integer.parseInt(p[0]),
                        Integer.parseInt(p[1]),
                        p[2],
                        Integer.parseInt(p[3])
                ));
            }
        } catch (Exception e) {
            System.out.println("Error al leer préstamos.");
        }
        return lista;
    }
}
