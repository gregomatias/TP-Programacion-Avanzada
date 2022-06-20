package cajero;

public class PantallaATM {

    private double ancho;
    private double largo;
    private String colorPantalla;

    public PantallaATM(double ancho, double largo, String colorPantalla) {
        this.ancho = ancho;
        this.largo = largo;
        this.colorPantalla = colorPantalla;

    }

    public void imprimir(String textoAImprimir) {
        System.out.println(textoAImprimir);
    }

    public void imprimir(Object textoAImprimir) {
        System.out.println(textoAImprimir);
    }

    public double getAncho() {
        return ancho;
    }

    public double getLargo() {
        return largo;
    }

    public String getColorPantalla() {
        return colorPantalla;
    }

    @Override
    public String toString() {

        return "Pantalla: Color: " + getColorPantalla() + " Largo: " + getLargo() + " Ancho: " + getAncho()+"\n";
    }

}
