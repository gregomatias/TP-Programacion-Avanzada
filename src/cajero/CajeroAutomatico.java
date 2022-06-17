package cajero;

public class CajeroAutomatico {
    private double efectivoDelCajero;

    public CajeroAutomatico(double efectivoDelCajero) {
        this.efectivoDelCajero = efectivoDelCajero;
    }

    public CajeroAutomatico() {
        this(10000);
    }

    public String retirarEfectivo(double montoRetiro, Usuario usuario) {

        if (this.efectivoDelCajero >= montoRetiro) {

            if (usuario.getCuentaBancaria().getSaldo() > montoRetiro) {

                usuario.getCuentaBancaria().setSaldo(usuario.getCuentaBancaria().getSaldo() - montoRetiro);
                return "Retiro de Dinero exitoso, su saldo actual es: "+usuario.getCuentaBancaria().getSaldo();
            } else {
                return "El monto ingresado supera el saldo de su cuenta";
            }
        } else {
            return "Disculpe, el cajero no tiene fondos para procesar dicha operacion, intente con un monto menor";
        }

    }

    public String depositarFondos(double montoDeposito, Usuario usuario) {

        usuario.getCuentaBancaria().setSaldo(usuario.getCuentaBancaria().getSaldo() + montoDeposito);

        return "Se deposito con exito el saldo en su cuenta. Saldo actual: " + usuario.getCuentaBancaria().getSaldo();

    }

}
