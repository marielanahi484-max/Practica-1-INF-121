public class UsuarioSeguro {
    private String usuario;
    private String password; 

    public UsuarioSeguro(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public String getUsuario() { return usuario; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return usuario + "," + password;
    }

    public static UsuarioSeguro fromString(String linea) {
        String[] p = linea.split(",");
        return new UsuarioSeguro(p[0], p[1]);
    }
}
