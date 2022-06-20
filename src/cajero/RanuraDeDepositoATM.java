package cajero;

public class RanuraDeDepositoATM {
    private double ancho;
    private double largo;
    private int capacidadBillete;

    public RanuraDeDepositoATM(double ancho, double largo, int cantidadDeBilletes) {
        this.ancho = ancho;
        this.largo = largo;
        this.capacidadBillete = cantidadDeBilletes;
    }

    public double getAncho() {
        return ancho;
    }

    public int getCapacidadDeBilletes() {
        return capacidadBillete;
    }

    public double getLargo() {
        return largo;
    }

    @Override
    public String toString() {

        return "Ranura Deposito: Capacidad Billetes: " + getCapacidadDeBilletes() + " Largo: " + getLargo()
                + " Ancho: " + getAncho()+"\n";
    }

}
