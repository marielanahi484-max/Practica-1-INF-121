import java.util.ArrayList;
import java.util.List;

public class Farmacia {

    private String nombreFarmacia;
    private String sucursal;
    private String direccion;
    private List<Medicamento> medicamentos;

    public Farmacia(String nombreFarmacia, String sucursal, String direccion) {
        this.nombreFarmacia = nombreFarmacia;
        this.sucursal = sucursal;
        this.direccion = direccion;
        this.medicamentos = new ArrayList<>();
    }

    public String getNombreFarmacia() { return nombreFarmacia; }
    public String getSucursal() { return sucursal; }
    public String getDireccion() { return direccion; }

    public List<Medicamento> getMedicamentos() { return medicamentos; }

    public void agregarMedicamento(Medicamento m) {
        medicamentos.add(m);
    }

    public boolean eliminarMedicamento(Medicamento m) {
        return medicamentos.remove(m);
    }

    public List<Medicamento> buscarMedicamentosPorTipo(String tipo) {
        List<Medicamento> res = new ArrayList<>();
        for (Medicamento m : medicamentos) {
            if (m.getTipo().equalsIgnoreCase(tipo)) res.add(m);
        }
        return res;
    }

    public List<Medicamento> buscarMedicamentosPorNombre(String nombre) {
        List<Medicamento> res = new ArrayList<>();
        for (Medicamento m : medicamentos) {
            if (m.getNombre().equalsIgnoreCase(nombre)) res.add(m);
        }
        return res;
    }

    public void mostrarMedicamentos() {
        System.out.println("Farmacia " + nombreFarmacia + " (Sucursal " + sucursal + ") - " + direccion);
        if (medicamentos.isEmpty()) {
            System.out.println("  No hay medicamentos.");
            return;
        }
        for (Medicamento m : medicamentos) {
            System.out.println("  " + m);
        }
    }

    @Override
    public String toString() {
        return String.format("Farmacia[nombre=%s, sucursal=%s, direccion=%s]",
                nombreFarmacia, sucursal, direccion);
    }
}
