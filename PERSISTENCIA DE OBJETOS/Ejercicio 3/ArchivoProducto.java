import java.io.*;
import java.util.ArrayList;

public class ArchivoProducto {
    private String nomA;

    public ArchivoProducto(String nA) {
        this.nomA = nA;
    }

    public void crearArchivo() {
        try {
            File f = new File(nomA);
            if (!f.exists()) {
                FileOutputStream fos = new FileOutputStream(nomA);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.close();
            }
        } catch (Exception e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

    public void guardaProducto(Producto p) {
        try {
      
            File f = new File(nomA);
            FileOutputStream fos = new FileOutputStream(f, true);

            ObjectOutputStream oos;

            if (f.length() == 0) {
                oos = new ObjectOutputStream(fos);
            } else {
          
                oos = new ObjectOutputStream(fos) {
                    protected void writeStreamHeader() throws IOException {}
                };
            }

            oos.writeObject(p);
            oos.close();
            System.out.println("Producto guardado.");
        } catch (Exception e) {
            System.out.println("Error al guardar producto: " + e.getMessage());
        }
    }

    public Producto buscaProducto(int c) {
        Producto encontrado = null;

        try {
            FileInputStream fis = new FileInputStream(nomA);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Producto p = (Producto) ois.readObject();
                if (p.getCodigo() == c) {
                    encontrado = p;
                    break;
                }
            }
        } catch (EOFException e) {
          
        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }

        return encontrado;
    }

    public float promedioPrecios() {
        float suma = 0;
        int cont = 0;

        try {
            FileInputStream fis = new FileInputStream(nomA);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Producto p = (Producto) ois.readObject();
                suma += p.getPrecio();
                cont++;
            }
        } catch (EOFException e) {
           
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        if (cont == 0) return 0;
        return suma / cont;
    }

    public Producto productoMasCaro() {
        Producto caro = null;

        try {
            FileInputStream fis = new FileInputStream(nomA);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Producto p = (Producto) ois.readObject();
                if (caro == null || p.getPrecio() > caro.getPrecio()) {
                    caro = p;
                }
            }
        } catch (EOFException e) {
           
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return caro;
    }
}
