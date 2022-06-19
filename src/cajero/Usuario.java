package cajero;
public class Usuario {
    private int claveNIP;
    private CuentaBancaria cuentaBancaria;

    public Usuario( int claveNIP,double saldo,int numeroCuenta) {
        this.claveNIP = claveNIP;
        this.cuentaBancaria = new CuentaBancaria(saldo,numeroCuenta);

    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public int getClaveNIP() {
        return claveNIP;
    }

}
