import java.io.*;
import java.util.*;

public class ArchivoCharango {
    private String nombreArchivo;

    public ArchivoCharango(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void adicionar(Charango c) {
        try {
            File file = new File(nombreArchivo);
            boolean append = file.exists();

            FileOutputStream fos = new FileOutputStream(nombreArchivo, true);
            ObjectOutputStream oos;

            if (append && file.length() > 0) {
                oos = new AppendableObjectOutputStream(fos);
            } else {
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(c);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarTodo(List<Charango> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            for (Charango c : lista) {
                oos.writeObject(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Charango> leerTodo() {
        ArrayList<Charango> lista = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            while (true) {
                Charango c = (Charango) ois.readObject();
                lista.add(c);
            }
        } catch (EOFException eof) {
     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    public void eliminarMasDe6CuerdasFalse() {
        ArrayList<Charango> lista = leerTodo();
        lista.removeIf(c -> c.cantidadCuerdasFalse() > 6);
        guardarTodo(lista);
    }

    public void listarPorMaterial(String x) {
        ArrayList<Charango> lista = leerTodo();
        for (Charango c : lista) {
            if (c.getMaterial().equalsIgnoreCase(x))
                System.out.println(c);
        }
    }

    public void buscarCon10Cuerdas() {
        ArrayList<Charango> lista = leerTodo();
        for (Charango c : lista) {
            if (c.getNroCuerdas() == 10)
                System.out.println(c);
        }
    }

    public void ordenarPorMaterial() {
        ArrayList<Charango> lista = leerTodo();
        lista.sort(Comparator.comparing(Charango::getMaterial));
        guardarTodo(lista);
    }

    public void escribir(Charango c) {
        adicionar(c);
    }
}
