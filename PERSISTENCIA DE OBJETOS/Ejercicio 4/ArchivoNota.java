import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoNota {
    private String nombreArchi;

    public ArchivoNota(String nombreArchi) {
        this.nombreArchi = nombreArchi;
    }

    public void crearArchivo() {
        try {
            File f = new File(nombreArchi);
            if (!f.exists()) {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.close();
            }
        } catch (Exception e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

    public void agregarNota(Nota n) {
        try {
            File f = new File(nombreArchi);
            FileOutputStream fos = new FileOutputStream(f, true);
            ObjectOutputStream oos;

            if (f.length() == 0) {
                oos = new ObjectOutputStream(fos);
            } else {
                oos = new ObjectOutputStream(fos) {
                    protected void writeStreamHeader() throws IOException {}
                };
            }

            oos.writeObject(n);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }


    public void agregarVariasNotas(List<Nota> lista) {
        for (Nota n : lista) {
            agregarNota(n);
        }
    }

    public List<Nota> listar() {
        List<Nota> lista = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(nombreArchi);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Nota n = (Nota) ois.readObject();
                lista.add(n);
            }

        } catch (EOFException e) {
         
        } catch (Exception e) {
            System.out.println("Error al leer: " + e.getMessage());
        }

        return lista;
    }

    public float promedioNotas() {
        List<Nota> lista = listar();
        if (lista.isEmpty()) return 0;

        float suma = 0;
        for (Nota n : lista) suma += n.getNotaFinal();

        return suma / lista.size();
    }

    public List<Nota> mejoresNotas() {
        List<Nota> lista = listar();
        List<Nota> mejores = new ArrayList<>();

        if (lista.isEmpty()) return mejores;

        float max = -1;
        for (Nota n : lista)
            if (n.getNotaFinal() > max)
                max = n.getNotaFinal();

        for (Nota n : lista)
            if (n.getNotaFinal() == max)
                mejores.add(n);

        return mejores;
    }

    public void eliminarMateria(String materia) {
        List<Nota> lista = listar();
        List<Nota> nuevas = new ArrayList<>();

        for (Nota n : lista) {
            if (!n.getMateria().equalsIgnoreCase(materia)) {
                nuevas.add(n);
            }
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchi));
            for (Nota n : nuevas) oos.writeObject(n);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error al reescribir archivo: " + e.getMessage());
        }
    }
}
