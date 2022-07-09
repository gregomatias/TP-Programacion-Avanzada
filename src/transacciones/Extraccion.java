package transacciones;

import usuario.Usuario;

public class Extraccion extends Transaccion {
    private double montoExtraccion;

    public Extraccion(Usuario usuario, double montoExtraccion) {
        super(usuario);
        this.montoExtraccion = montoExtraccion;
    }

    @Override
    public String ejecutarTransaccion() {
        if (getUsuario().getCuentaBancaria().getSaldo() >= this.montoExtraccion) {

            getUsuario().getCuentaBancaria()
                    .setSaldo(getUsuario().getCuentaBancaria().getSaldo() - this.montoExtraccion);


            return "0";
                    
        } else {

            /* "El monto ingresado supera el saldo de su cuenta\n"; */
            return "1";
        }
    }

    public double getMontoExtraccion() {
        return montoExtraccion;
    }

}
