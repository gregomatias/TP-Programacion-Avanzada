package cajero;

public class TecladoATM {
    private String idioma;
    private double ancho;
    private double largo;


    public TecladoATM(String idioma, double ancho, double largo) {
        this.idioma = idioma;
        this.ancho = ancho;
        this.largo = largo;


    }
    public String getIdioma() {
        return idioma;
    }
    public double getAncho() {
        return ancho;
    }
    public double getLargo() {
        return largo;
    }

    @Override
    public String toString() {
        
        return "Teclado: Idioma: "+getIdioma()+ " Ancho: "+getAncho()+" Largo: "+getLargo()+"\n";
    }

}
