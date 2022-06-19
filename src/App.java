import java.util.Scanner;

import cajero.BaseDeDatos;
import cajero.CajeroAutomatico;
import cajero.Usuario;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Usuario usuarioLogueado = null;

        CajeroAutomatico ATM = new CajeroAutomatico();
        boolean apagarSistema = false;

        /* ####Alta Usuario BD#### */

        BaseDeDatos.altaDeUsuario(new Usuario(54321, 500, 12345, "comun"));
        BaseDeDatos.altaDeUsuario(new Usuario(54321, 10000, 99999, "admin"));

        while (apagarSistema == false) {

            /* ####Resetea el sistema cuendo entra un usuario nuevo:#### */
            int intentosDeLogueo = 3;
            boolean desloguearse = false;
            usuarioLogueado = null;

            System.out.println("Bienvenido al Cajero Automatico ATM\n");

            /* ####Valida logueo de usuario por 3 intentos#### */
            while (intentosDeLogueo > 0 && usuarioLogueado == null) {
                intentosDeLogueo--;
                System.out.println("Ingrese su numero de cuenta Bancaria\n");
                int numeroCuentaIngresada = scanner.nextInt();

                System.out.println("Ingrese su clave NIP de 5 digitos\n");
                int claveNIPIngresada = scanner.nextInt();

                usuarioLogueado = BaseDeDatos.obtieneUsuario(numeroCuentaIngresada, claveNIPIngresada);

            }

            /* ####Si el usuario fue logueado procede con el Menu de Opciones#### */

            if (!(usuarioLogueado == null)) {// Si no esta logueado,null le retiene la tarjeta.

                while (desloguearse == false) {

                    int menuOpciones = 0;

                    if (!usuarioLogueado.getTipoDeUsuario().equalsIgnoreCase("admin")) {

                        System.out.println("1-Depósito 2-Extracción 3-Consulta de Saldo 4-Deslogueo\n");
                        menuOpciones = scanner.nextInt();

                    } else {
                        System.out
                                .println("1-Depósito 2-Extracción 3-Consulta de Saldo 4-Deslogueo 5-Apagar Sistema\n");
                        menuOpciones = scanner.nextInt();
                    }

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
                                    .println("El saldo de su cuenta es: "
                                            + usuarioLogueado.getCuentaBancaria().getSaldo() + "\n");
                            break;
                        case 4:
                            System.out.println(
                                    "Por favor, retire su tarjeta.\n Muchas gracias por operar con cajeros ATM\n");
                            desloguearse = true;
                            break;
                        case 5:
                            System.out.println("El sistema se esta apagando...\n");
                            desloguearse = true;
                            apagarSistema = true;
                            break;
                    }

                }

            } else {
                System.out.println("Ha superado el numero de intentos, por su seguridad retuvimos su tarjeta.");
            } // If Usuario logueado

        } // While apagarSistema
        scanner.close();
    }// Main

}// Clase App
