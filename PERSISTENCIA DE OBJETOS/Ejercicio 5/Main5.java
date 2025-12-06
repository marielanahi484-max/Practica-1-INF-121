public class Main5 {

    public static void main(String[] args) {

        Medicamento m1 = new Medicamento("Tapsin", 101, "tos", 12.5);
        Medicamento m2 = new Medicamento("BroncoStop", 102, "tos", 9.0);
        Medicamento m3 = new Medicamento("Aspirina", 201, "analgesico", 4.5);
        Medicamento m4 = new Medicamento("Tapsin", 103, "tos", 12.5);
        Medicamento m5 = new Medicamento("AntiFiebre", 301, "antipiretico", 7.2);
        Medicamento m6 = new Medicamento("JarabeX", 401, "tos", 15.0);

        Farmacia f1 = new Farmacia("SaludPlus", "1", "Av. Bolivia 100");
        f1.agregarMedicamento(m1);
        f1.agregarMedicamento(m3);

        Farmacia f2 = new Farmacia("FarmaciaVida", "2", "Calle Sucre 55");
        f2.agregarMedicamento(m2);
        f2.agregarMedicamento(m5);

        Farmacia f3 = new Farmacia("SaludPlus", "3", "Av. La Paz 20");
        f3.agregarMedicamento(m4);
        f3.agregarMedicamento(m6);

        ArchFarmacia arch = new ArchFarmacia("archivoFarmacias.dat");

        arch.agregar(f1);
        arch.agregar(f2);
        arch.agregar(f3);

        System.out.println("=== a) Medicamentos para la tos en sucursal 1 ===");
        arch.mostrarMedicamentosParaTosEnSucursal("1");

        System.out.println("\n=== b) Sucursales con Tapsin ===");
        arch.mostrarSucursalesConMedicamento("Tapsin");

        System.out.println("\n=== c) Buscar medicamentos tipo 'tos' ===");
        arch.buscarMedicamentosPorTipo("tos");

        System.out.println("\n=== d) Ordenar farmacias por dirección ===");
        arch.ordenarFarmaciasPorDireccion();

        System.out.println("\n=== e) Mover medicamentos tipo 'tos' de sucursal 3 a 2 ===");
        arch.moverMedicamentosTipo("tos", "3", "2");

        System.out.println("\n=== Estado final ===");
        arch.mostrarTodo();
    }
}
