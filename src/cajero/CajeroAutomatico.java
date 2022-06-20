package cajero;

import usuario.Usuario;

public class CajeroAutomatico {
    private double efectivoDelCajero;
    private TecladoATM teclado;
    private PantallaATM pantalla;
    private RanuraDeDepositoATM ranuraDeDeposito;
    private DispensadorDeEfectivoATM dispensadorDeEfectivo;

    public CajeroAutomatico() {
        this.teclado = new TecladoATM("ES", 100, 50);
        this.pantalla = new PantallaATM(1920, 1080, "AZUL");
        this.ranuraDeDeposito = new RanuraDeDepositoATM(100, 50, 100);
        this.dispensadorDeEfectivo = new DispensadorDeEfectivoATM("EX226", "ARG", 20);
        this.efectivoDelCajero = this.dispensadorDeEfectivo.cargaBilletes(500);

    }

    /* Valida efectivo del cajero */
    public String retirarEfectivo(double montoRetiro, Usuario usuario) {

        /* Valida efectivo del cajero */
        if (this.efectivoDelCajero >= montoRetiro) {

            /* Valida saldo del usuario */
            if (usuario.getCuentaBancaria().getSaldo() >= montoRetiro) {

                /*
                 * Valida si es multiplo de la denominacion que en este caso son billetes de $20
                 */
                double resto = montoRetiro % this.dispensadorDeEfectivo.getDenominacion();
                if (resto > 0) {

                    return "El monto a extraer debe ser multiplo de" + this.dispensadorDeEfectivo.getDenominacion()
                            + "\n";
                }

                usuario.getCuentaBancaria().setSaldo(usuario.getCuentaBancaria().getSaldo() - montoRetiro);

                this.efectivoDelCajero = this.efectivoDelCajero - montoRetiro;

                return "Retiro de Dinero exitoso, su saldo actual es: " + usuario.getCuentaBancaria().getSaldo() + "\n";
            } else {
                return "El monto ingresado supera el saldo de su cuenta\n";
            }
        } else {
            return "Disculpe, el cajero no tiene fondos para procesar dicha operacion, intente con un monto menor\n";
        }

    }

    public String depositarFondos(double montoDeposito, Usuario usuario) {

        usuario.getCuentaBancaria().setSaldo(usuario.getCuentaBancaria().getSaldo() + montoDeposito);

        return "Se deposito con exito el saldo en su cuenta. Saldo actual: " + usuario.getCuentaBancaria().getSaldo()
                + "\n";

    }

    public DispensadorDeEfectivoATM getDispensadorDeEfectivo() {
        return dispensadorDeEfectivo;
    }

    public double getEfectivoDelCajero() {
        return efectivoDelCajero;
    }

    public PantallaATM getPantalla() {
        return pantalla;
    }

    public RanuraDeDepositoATM getRanuraDeDeposito() {
        return ranuraDeDeposito;
    }

    public TecladoATM getTeclado() {
        return teclado;
    }

    @Override
    public String toString() {

        return "Cajero ATM Efectivo disponible: " + getEfectivoDelCajero() + "\n" + getPantalla()
                + getRanuraDeDeposito()
                + getTeclado()
                + getDispensadorDeEfectivo();
    }

}
