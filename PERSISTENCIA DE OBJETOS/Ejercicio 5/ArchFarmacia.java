import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArchFarmacia {

    private String nombreArchivo;
    private List<Farmacia> farmacias;

    public ArchFarmacia(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.farmacias = new ArrayList<>();
    }

    public void agregar(Farmacia f) {
        farmacias.add(f);
    }

    public void agregarVarias(List<Farmacia> lista) {
        farmacias.addAll(lista);
    }

    public void mostrarTodo() {
        for (Farmacia f : farmacias) {
            f.mostrarMedicamentos();
            System.out.println();
        }
    }

    
    public void mostrarMedicamentosParaTosEnSucursal(String sucursalX) {
        System.out.println("Medicamentos tipo 'tos' en la sucursal " + sucursalX);
        boolean encontrado = false;

        for (Farmacia f : farmacias) {
            if (f.getSucursal().equalsIgnoreCase(sucursalX)) {
                List<Medicamento> lista = f.buscarMedicamentosPorTipo("tos");
                for (Medicamento m : lista) {
                    System.out.println("  " + m);
                    encontrado = true;
                }
            }
        }

        if (!encontrado)
            System.out.println("  No se encontraron medicamentos para la tos.");
    }

    
    public void mostrarSucursalesConMedicamento(String nombreMedicamento) {
        System.out.println("Farmacias que tienen el medicamento '" + nombreMedicamento + "'");
        boolean found = false;

        for (Farmacia f : farmacias) {
            if (!f.buscarMedicamentosPorNombre(nombreMedicamento).isEmpty()) {
                System.out.println("  Sucursal " + f.getSucursal() +
                        " - Dirección: " + f.getDireccion());
                found = true;
            }
        }

        if (!found)
            System.out.println("  Ninguna sucursal lo tiene.");
    }

    
    public void buscarMedicamentosPorTipo(String tipo) {
        System.out.println("Buscando medicamentos tipo '" + tipo + "'");
        boolean found = false;

        for (Farmacia f : farmacias) {
            List<Medicamento> lista = f.buscarMedicamentosPorTipo(tipo);
            if (!lista.isEmpty()) {
                System.out.println("  En " + f.getNombreFarmacia() +
                        " (sucursal " + f.getSucursal() + ")");
                for (Medicamento m : lista)
                    System.out.println("    " + m);
                found = true;
            }
        }

        if (!found)
            System.out.println("  No se encontraron medicamentos de ese tipo.");
    }

  
    public void ordenarFarmaciasPorDireccion() {
        farmacias.sort(Comparator.comparing(Farmacia::getDireccion, String.CASE_INSENSITIVE_ORDER));

        System.out.println("Farmacias ordenadas por dirección:");
        for (Farmacia f : farmacias)
            System.out.println("  " + f);
    }

    // e)
    public void moverMedicamentosTipo(String tipo, String sucursalFrom, String sucursalTo) {
        Farmacia from = null;
        Farmacia to = null;

        for (Farmacia f : farmacias) {
            if (f.getSucursal().equalsIgnoreCase(sucursalFrom)) from = f;
            if (f.getSucursal().equalsIgnoreCase(sucursalTo)) to = f;
        }

        if (from == null || to == null) {
            System.out.println("Error: una de las sucursales no existe.");
            return;
        }

        List<Medicamento> aMover = new ArrayList<>();
        for (Medicamento m : from.getMedicamentos()) {
            if (m.getTipo().equalsIgnoreCase(tipo))
                aMover.add(m);
        }

        if (aMover.isEmpty()) {
            System.out.println("No hay medicamentos de tipo '" + tipo + "' para mover.");
            return;
        }

        for (Medicamento m : aMover) {
            from.eliminarMedicamento(m);
            to.agregarMedicamento(m);
        }
System.out.println("Se movieron " + aMover.size() + " medicamentos tipo '" + tipo +
                "' de sucursal " + sucursalFrom + " a " + sucursalTo);
    }
}
