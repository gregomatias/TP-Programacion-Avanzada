package cajero;

public class CajeroAutomatico {
    private int efectivoDelCajero;
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

    public String retirarEfectivo(double montoRetiro, Usuario usuario) {
        System.out.println("efectivoDelCajero funcion: " + this.efectivoDelCajero);
        if (this.efectivoDelCajero >= montoRetiro) {

            if (usuario.getCuentaBancaria().getSaldo() >= montoRetiro) {

                double resto = montoRetiro % this.dispensadorDeEfectivo.getDenominacion();
                System.out.println("Resto: " + resto);
                if (resto > 0) {

                    return "El monto a extraer debe ser multiplo de 20\n";
                }

                usuario.getCuentaBancaria().setSaldo(usuario.getCuentaBancaria().getSaldo() - montoRetiro);
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

        return "Se deposito con exito el saldo en su cuenta. Saldo actual: " + usuario.getCuentaBancaria().getSaldo();

    }

}
