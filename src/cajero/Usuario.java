package cajero;
public class Usuario {
    private int claveNIP;
    private CuentaBancaria cuentaBancaria;
    String tipoDeUsuario;

    public Usuario( int claveNIP,double saldo,int numeroCuenta,String tipoDeUsuario) {
        this.claveNIP = claveNIP;
        this.cuentaBancaria = new CuentaBancaria(saldo,numeroCuenta);
        this.tipoDeUsuario=tipoDeUsuario.toLowerCase();

    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public int getClaveNIP() {
        return claveNIP;
    }
    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

}
