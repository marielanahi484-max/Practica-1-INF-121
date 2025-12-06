public class MainSeguridad {
    public static void main(String[] args) {

        ArchivoUsuarios arch = new ArchivoUsuarios();

        arch.guardar(new UsuarioSeguro("mariel", "abc123"));
        arch.guardar(new UsuarioSeguro("admin", "root456"));

        System.out.println("USUARIOS GUARDADOS:");
        for (UsuarioSeguro u : arch.leerTodos()) {
            System.out.println(u.getUsuario() + " - " + u.getPassword());
        }

        UsuarioSeguro u = arch.buscar("admin");
        if (u != null) System.out.println("\nEncontrado: " + u.getUsuario());
    }
}

