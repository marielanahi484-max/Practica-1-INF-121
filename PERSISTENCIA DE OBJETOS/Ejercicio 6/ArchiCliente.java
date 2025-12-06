import java.io.*;
import java.util.*;

public class ArchiCliente {
    private String nomArch;

    public ArchiCliente(String nomArch) {
        this.nomArch = nomArch;
    }

    public void agregarCliente(Cliente c) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomArch, true))) {
            pw.println(c.toString());
        } catch (Exception e) {
            System.out.println("Error al guardar cliente.");
        }
    }

    public List<Cliente> leerTodos() {
        List<Cliente> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomArch))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(";");
                lista.add(new Cliente(
                        Integer.parseInt(p[0]),
                        Integer.parseInt(p[1]),
                        p[2], p[3]
                ));
            }
        } catch (Exception e) {
            System.out.println("Error al leer clientes.");
        }
        return lista;
    }
}
