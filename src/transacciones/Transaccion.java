package transacciones;

import usuario.Usuario;

public abstract class Transaccion {
    private Usuario usuario;

    public Transaccion(Usuario usuario) {
        this.usuario = usuario;
    }

    public abstract String ejecutarTransaccion();

    public Usuario getUsuario() {
        return usuario;
    }

}
