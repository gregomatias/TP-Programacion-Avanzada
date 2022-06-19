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

}
