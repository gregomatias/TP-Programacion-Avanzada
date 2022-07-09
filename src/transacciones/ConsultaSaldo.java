package transacciones;

import usuario.Usuario;

public class ConsultaSaldo extends Transaccion {

    public ConsultaSaldo(Usuario usuario) {
        super(usuario);

    }

    @Override
    public String ejecutarTransaccion() {

        return "El saldo de su cuenta es: " + super.getUsuario().getCuentaBancaria().getSaldo() + "\n";
    }

}
