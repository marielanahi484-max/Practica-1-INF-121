import java.io.*;
import java.util.*;

public class ArchiLibro {
    private String nomArch;

    public ArchiLibro(String nomArch) {
        this.nomArch = nomArch;
    }

    public void agregarLibro(Libro l) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomArch, true))) {
            pw.println(l.toString());
        } catch (Exception e) {
            System.out.println("Error al guardar libro.");
        }
    }

    public List<Libro> leerTodos() {
        List<Libro> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomArch))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(";");
                lista.add(new Libro(
                        Integer.parseInt(p[0]),
                        p[1],
                        Float.parseFloat(p[2])));
            }
        } catch (Exception e) {
            System.out.println("Error al leer libros.");
        }
        return lista;
    }
}
