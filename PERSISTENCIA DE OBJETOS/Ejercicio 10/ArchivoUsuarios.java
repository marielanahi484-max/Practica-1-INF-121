import java.io.*;
import java.util.ArrayList;

public class ArchivoUsuarios {
    private String archivo = "usuarios_seguro.txt";

    public void guardar(UsuarioSeguro u) {
        try (FileWriter fw = new FileWriter(archivo, true)) {
            fw.write(u.toString() + "\n");
        } catch (Exception e) {}
    }

    public ArrayList<UsuarioSeguro> leerTodos() {
        ArrayList<UsuarioSeguro> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String l;
            while ((l = br.readLine()) != null) {
                lista.add(UsuarioSeguro.fromString(l));
            }
        } catch (Exception e) {}
        return lista;
    }

    public UsuarioSeguro buscar(String usuario) {
        for (UsuarioSeguro u : leerTodos()) {
            if (u.getUsuario().equalsIgnoreCase(usuario)) return u;
        }
        return null;
    }
}
