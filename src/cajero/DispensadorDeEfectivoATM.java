package cajero;

public class DispensadorDeEfectivoATM {

    private String modelo;
    private String moneda;
    private int denominacion;

    DispensadorDeEfectivoATM(String modelo, String moneda,int denominacion) {
        this.modelo = modelo;
        this.moneda = moneda;
        this.denominacion=denominacion;
    }

    public int cargaBilletes(int cantidadDeBilletes) {

        return cantidadDeBilletes * this.denominacion;

    }
    public int getDenominacion() {
        return denominacion;
    }
}
