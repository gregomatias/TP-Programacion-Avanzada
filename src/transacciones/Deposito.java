package transacciones;

import usuario.Usuario;

public class Deposito extends Transaccion {
    private double montoDeposito;

    public Deposito(Usuario usuario, double montoDeposito) {
        super(usuario);
        this.montoDeposito = montoDeposito;

    }

    @Override
    public String ejecutarTransaccion() {
        if (this.montoDeposito > 0) {
            getUsuario().getCuentaBancaria().setSaldo(getUsuario().getCuentaBancaria().getSaldo() + this.montoDeposito);

            return "Se deposito con exito el saldo en su cuenta. Saldo actual: "
                    + getUsuario().getCuentaBancaria().getSaldo()
                    + "\n";

        } else {
            return "El monto ingresado debe ser mayor a cero\n";
        }

    }

}
