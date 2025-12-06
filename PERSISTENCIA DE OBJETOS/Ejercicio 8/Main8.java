public class Main8 {
    public static void main(String[] args) {
        ArchRefri refri = new ArchRefri();

        refri.crear();
        refri.listar();
        refri.modificarPorNombre();
        refri.eliminarPorNombre();
        refri.mostrarCaducadosAntes();
        refri.eliminarCantidadCero();
        refri.buscarVencidos();
        refri.mostrarMayorCantidad();
    }
}
