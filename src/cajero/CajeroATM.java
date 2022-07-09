package cajero;

import transacciones.ConsultaSaldo;
import transacciones.Deposito;
import transacciones.Extraccion;
import transacciones.Transaccion;

public class CajeroATM {
    private double efectivoDelCajero;
    private TecladoATM teclado;
    private PantallaATM pantalla;
    private RanuraDeDepositoATM ranuraDeDeposito;
    private DispensadorDeEfectivoATM dispensadorDeEfectivo;

    // SINGLETON: Singleton, creo una instancia dentro de la propia clase, que va a
    // ser la
    // unica que se pueda crear:
    private static final CajeroATM instance = new CajeroATM();

    // SINGLETON: Se restringe el contructor para que no se creen otras instancias
    // de clases,
    // solo una.
    private CajeroATM() {
        this.teclado = new TecladoATM("ES", 100, 50);
        this.pantalla = new PantallaATM(1920, 1080, "AZUL");
        this.ranuraDeDeposito = new RanuraDeDepositoATM(100, 50, 100);
        this.dispensadorDeEfectivo = new DispensadorDeEfectivoATM("EX226", "ARG", 20);
        this.efectivoDelCajero = this.dispensadorDeEfectivo.cargaBilletes(500);

    }

    // SINGLETON: Geter que se utiliza para llamar a la unica instancia posible.
    // SINGLETON: El nombre instance es por convencion.
    public static CajeroATM getInstance() {
        return instance;
    }

    public String solicitudDeTransaccion(Transaccion transaccion) {
        if (transaccion instanceof Deposito) {
            return transaccion.ejecutarTransaccion();

        } else if (transaccion instanceof Extraccion) {
            Extraccion extraccion = (Extraccion) transaccion;
            double resto = extraccion.getMontoExtraccion() % this.dispensadorDeEfectivo.getDenominacion();

            if (this.efectivoDelCajero >= extraccion.getMontoExtraccion()) {

                if (!(resto > 0)) {

                    return extraccion.ejecutarTransaccion();

                } else {
                    return "2";
                }

            } else {
                return "3";

            }

        } else if (transaccion instanceof ConsultaSaldo) {
            return transaccion.ejecutarTransaccion();
        } else {
            return "Transaccion indeterminada";
        }

    }

    public void setEfectivoDelCajero(double efectivoDelCajero) {
        this.efectivoDelCajero = efectivoDelCajero;
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
