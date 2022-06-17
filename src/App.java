import java.util.Scanner;

import cajero.BaseDeDatos;
import cajero.CajeroAutomatico;
import cajero.CuentaBancaria;
import cajero.Usuario;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int intentosDeLogueo = 3;
        Usuario usuarioLogueado = null;

        /* ####Alta Usuario BD#### */
        CajeroAutomatico ATM = new CajeroAutomatico();

        CuentaBancaria cuenta1 = new CuentaBancaria(500, 12345);
        Usuario usuario1 = new Usuario(54321, cuenta1);
        BaseDeDatos.altaDeUsuario(usuario1);

        System.out.println("Bienvenido al Cajero Automatico ATM\n");

        //Valido 3 intentos de logueo del usuario
        while (intentosDeLogueo > 0 && usuarioLogueado == null) {
            intentosDeLogueo--;
            System.out.println("Ingrese su numero de cuenta Bancaria\n");
            int numeroCuentaIngresada = scanner.nextInt();

            System.out.println("Ingrese su clave NIP de 5 digitos\n");
            int claveNIPIngresada = scanner.nextInt();

            usuarioLogueado = BaseDeDatos.obtieneUsuario(numeroCuentaIngresada, claveNIPIngresada);

        }

         //Si el usuario esta logueado inicia el menu:
        if (!(usuarioLogueado==null)) {
            System.out.println("1-Depósito 2-Extracción 3-Consulta de Saldo 4-Deslogueo");

            
        }else{
            System.out.println("Ha superado el numero de intentos, por su seguridad retuvimos su tarjeta.");
        }




        scanner.close();
    }

}
