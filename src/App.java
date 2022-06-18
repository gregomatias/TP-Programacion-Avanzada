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
        boolean desloguearse = false;

        /* ####Alta Usuario BD#### */
        CajeroAutomatico ATM = new CajeroAutomatico();

        CuentaBancaria cuenta1 = new CuentaBancaria(500, 12345);
        Usuario usuario1 = new Usuario(54321, cuenta1);
        BaseDeDatos.altaDeUsuario(usuario1);

        System.out.println("Bienvenido al Cajero Automatico ATM\n");

        // Valido 3 intentos de logueo del usuario
        while (intentosDeLogueo > 0 && usuarioLogueado == null) {
            intentosDeLogueo--;
            System.out.println("Ingrese su numero de cuenta Bancaria\n");
            int numeroCuentaIngresada = scanner.nextInt();

            System.out.println("Ingrese su clave NIP de 5 digitos\n");
            int claveNIPIngresada = scanner.nextInt();

            usuarioLogueado = BaseDeDatos.obtieneUsuario(numeroCuentaIngresada, claveNIPIngresada);

        }

        // Si el usuario esta logueado inicia el menu:
        if (!(usuarioLogueado == null)) {

            while (desloguearse == false) {

                System.out.println("1-Depósito 2-Extracción 3-Consulta de Saldo 4-Deslogueo\n");
                int menuOpciones = scanner.nextInt();

                switch (menuOpciones) {
                    case 1:
                        System.out.println("Ingrese el monto a depositar\n");
                        double montoDeposito = scanner.nextDouble();
                        System.out.println(ATM.depositarFondos(montoDeposito, usuarioLogueado));
                        break;
                    case 2:
                        System.out.println("Ingrese el monto a extraer\n");
                        double montoRetiro = scanner.nextDouble();
                        System.out.println(ATM.retirarEfectivo(montoRetiro, usuarioLogueado));
                        break;
                    case 3:
                        System.out
                                .println("El saldo de su cuenta es: " + usuarioLogueado.getCuentaBancaria().getSaldo()+"\n");
                        break;
                    case 4:
                        System.out.println("Por favor, retire su tarjeta.\n Muchas gracias por operar con cajeros ATM\n");
                        desloguearse = true;
                        break;
                }

            }

        } else {
            System.out.println("Ha superado el numero de intentos, por su seguridad retuvimos su tarjeta.");
        }

        scanner.close();
    }

}
