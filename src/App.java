import java.util.Scanner;

import cajero.CajeroAutomatico;
import servicio.BaseDeDatos;
import usuario.Usuario;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Usuario usuarioLogueado = null;

        CajeroAutomatico ATM = new CajeroAutomatico();
        boolean apagarSistema = false;

        /* ####Alta Usuario BD#### */

        BaseDeDatos.altaDeUsuario(new Usuario(54321, 500, 12345, "comun"));
        BaseDeDatos.altaDeUsuario(new Usuario(54321, 10000, 99999, "admin"));

        /* #####Informacions del sistema Inicio############ */
        ATM.getPantalla().imprimir("#########################");
        ATM.getPantalla().imprimir(ATM);
        ATM.getPantalla().imprimir("#########################");

        /* #####loop hasta que el Administrador apague el sistema############ */
        while (apagarSistema == false) {

            /* ####Reseteo de datos ante un usuario nuevo:#### */
            int intentosDeLogueo = 3;
            boolean desloguearse = false;
            usuarioLogueado = null;

            ATM.getPantalla().imprimir("\n¡¡Bienvenido al Cajero Automatico ATM!!\n");

            /* ####Valida logueo de usuario por 3 intentos#### */
            while (intentosDeLogueo > 0 && usuarioLogueado == null) {
                intentosDeLogueo--;
                ATM.getPantalla().imprimir("Ingrese su numero de cuenta Bancaria\n");

                int numeroCuentaIngresada = scanner.nextInt();

                ATM.getPantalla().imprimir("Ingrese su clave NIP de 5 digitos\n");
                int claveNIPIngresada = scanner.nextInt();

                usuarioLogueado = BaseDeDatos.obtieneUsuario(numeroCuentaIngresada, claveNIPIngresada);
                if (usuarioLogueado == null) {

                    ATM.getPantalla().imprimir("##Numero de cuenta o clave invalido##\n");

                }

            }

            /* ####Si el usuario fue logueado(<>NULL) procede con el Menu de Opciones#### */
            if (!(usuarioLogueado == null)) {

                while (desloguearse == false) {

                    int menuOpciones = 0;

                    if (!usuarioLogueado.getTipoDeUsuario().equalsIgnoreCase("admin")) {

                        ATM.getPantalla().imprimir("1-Depósito 2-Extracción 3-Consulta de Saldo 4-Deslogueo\n");

                        menuOpciones = scanner.nextInt();

                    } else {

                        ATM.getPantalla()
                                .imprimir("1-Depósito 2-Extracción 3-Consulta de Saldo 4-Deslogueo 5-Apagar Sistema\n");

                        menuOpciones = scanner.nextInt();
                    }

                    switch (menuOpciones) {
                        case 1:
                            ATM.getPantalla().imprimir("Ingrese el monto a depositar\n");
                            double montoDeposito = scanner.nextDouble();
                            ATM.getPantalla().imprimir(ATM.depositarFondos(montoDeposito, usuarioLogueado));
                            break;
                        case 2:
                            ATM.getPantalla().imprimir("Ingrese el monto a extraer\n");
                            double montoRetiro = scanner.nextDouble();
                            ATM.getPantalla().imprimir(ATM.retirarEfectivo(montoRetiro, usuarioLogueado));
                            break;
                        case 3:
                            ATM.getPantalla().imprimir("El saldo de su cuenta es: "
                                    + usuarioLogueado.getCuentaBancaria().getSaldo() + "\n");
                            break;
                        case 4:
                            ATM.getPantalla().imprimir(
                                    "Por favor, retire su tarjeta.\n Muchas gracias por operar con cajeros ATM\n");
                            desloguearse = true;
                            break;
                        case 5:
                            ATM.getPantalla().imprimir("El sistema se esta apagando...\n");
                            desloguearse = true;
                            apagarSistema = true;
                            break;
                    }

                }

            } else {// Si no esta logueado,null le retiene la tarjeta.
                ATM.getPantalla().imprimir("Ha superado el numero de intentos, por su seguridad retuvimos su tarjeta.");
            } // If Usuario logueado

        } // While apagarSistema
        scanner.close();
    }// Main

}// Clase App
