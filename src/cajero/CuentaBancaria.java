package cajero;

public class CuentaBancaria {
    private double saldo;
   private int  numeroCuenta;

   public CuentaBancaria(double saldo,int numeroCuenta){
    this.saldo=saldo;
    this.numeroCuenta=numeroCuenta;
   }

   public int getNumeroCuenta() {
       return numeroCuenta;
   }
   public double getSaldo() {
       return saldo;
   }
   
   public void setSaldo(double saldo) {
       this.saldo = saldo;
   }
    
}
