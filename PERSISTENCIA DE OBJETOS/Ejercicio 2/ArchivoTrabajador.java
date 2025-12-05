import java.io.*;
import java.util.*;

public class ArchivoTrabajador {
    private String nombreArch;

    public ArchivoTrabajador(String nombreArch) {
        this.nombreArch = nombreArch;
    }

    public void crearArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArch))) {
            System.out.println("Archivo creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Trabajador> leerTodo() {
        ArrayList<Trabajador> lista = new ArrayList<>();
        try (
            FileInputStream fis = new FileInputStream(nombreArch);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            while (true) {
                Trabajador t = (Trabajador) ois.readObject();
                lista.add(t);
            }
        } catch (EOFException eof) {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void guardarTodo(List<Trabajador> lista) {
        try (
            FileOutputStream fos = new FileOutputStream(nombreArch);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            for (Trabajador t : lista) {
                oos.writeObject(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardarTrabajador(Trabajador t) {
        try (
            FileOutputStream fos = new FileOutputStream(nombreArch, true);
            AppendableObjectOutputStream oos = new AppendableObjectOutputStream(fos);
        ) {
            oos.writeObject(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aumentaSalario(int a, Trabajador t) {
        ArrayList<Trabajador> lista = leerTodo();

        for (Trabajador tr : lista) {
            if (tr.getCarnet() == t.getCarnet()) {
                double nuevo = tr.getSalario() + a;
                tr.setSalario(nuevo);
            }
        }

        guardarTodo(lista);
    }

    public Trabajador buscarMayorSalario() {
        ArrayList<Trabajador> lista = leerTodo();

        if (lista.isEmpty()) return null;

        Trabajador mayor = lista.get(0);

        for (Trabajador t : lista) {
            if (t.getSalario() > mayor.getSalario())
                mayor = t;
        }

        return mayor;
    }

    public void ordenarPorSalario() {
        ArrayList<Trabajador> lista = leerTodo();

        lista.sort(Comparator.comparingDouble(Trabajador::getSalario));

        guardarTodo(lista);
    }
}

