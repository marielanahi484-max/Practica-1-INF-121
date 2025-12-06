import java.io.*;
import java.util.*;

public class GestorJugadores {

    private String archivo = "jugadores.txt";

    public void guardarJugador(Jugador j) {
        try (FileWriter fw = new FileWriter(archivo, true)) {
            fw.write(j.toString() + "\n");
            System.out.println("✔ Jugador guardado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al guardar jugador.");
        }
    }

    public List<Jugador> leerJugadores() {
        List<Jugador> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(Jugador.fromString(linea));
            }
        } catch (Exception e) {
            System.out.println("No se pudo leer archivo (aún no existe).");
        }
        return lista;
    }
    public void mostrarTodos() {
        List<Jugador> lista = leerJugadores();
        if (lista.isEmpty()) {
            System.out.println("No hay jugadores registrados.");
            return;
        }

        System.out.println("\n📌 LISTA DE JUGADORES");
        for (Jugador j : lista) {
            System.out.println("Nombre: " + j.getNombre() +
                    " | Nivel: " + j.getNivel() +
                    " | Puntaje: " + j.getPuntaje());
        }
    }

    public void buscarJugador(String nombre) {
        List<Jugador> lista = leerJugadores();
        for (Jugador j : lista) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\n✔ RESULTADO DE LA BÚSQUEDA:");
                System.out.println("Nombre: " + j.getNombre());
                System.out.println("Nivel: " + j.getNivel());
                System.out.println("Puntaje: " + j.getPuntaje());
                return;
            }
        }
        System.out.println("✘ No se encontró al jugador.");
    }
}
