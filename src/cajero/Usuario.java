package cajero;
public class Usuario {
    private int claveNIP;
    private CuentaBancaria cuentaBancaria;

    public Usuario( int claveNIP, CuentaBancaria cuentaBancaria) {
        this.claveNIP = claveNIP;
        this.cuentaBancaria = cuentaBancaria;

    }

    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public int getClaveNIP() {
        return claveNIP;
    }

}
