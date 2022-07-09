import java.util.Scanner;

import banco.Banco;
import cajero.CajeroATM;
import transacciones.ConsultaSaldo;
import transacciones.Deposito;
import transacciones.Extraccion;
import usuario.Usuario;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Usuario usuarioLogueado = null;

        // Patron Singleton, llamo a la unica instancia creada dentro de la propia clase
        // CajeroATM
        CajeroATM ATM = CajeroATM.getInstance();
        boolean apagarSistema = false;

        /* ####Alta Usuario BD del Banco#### */

        Banco.altaDeUsuario(new Usuario(54321, 500, 12345, "comun"));
        Banco.altaDeUsuario(new Usuario(54321, 10000, 99999, "admin"));

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

                usuarioLogueado = Banco.obtieneUsuario(numeroCuentaIngresada, claveNIPIngresada);
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
                            Deposito solicitudDeDeposito = new Deposito(usuarioLogueado, montoDeposito);
                            ATM.getPantalla().imprimir(ATM.solicitudDeTransaccion(solicitudDeDeposito));
                            break;
                        case 2:
                            ATM.getPantalla().imprimir("Ingrese el monto a extraer\n");
                            double montoRetiro = scanner.nextDouble();
                            Extraccion solicitudDeExtraccion = new Extraccion(usuarioLogueado, montoRetiro);

                            String codigoResultado = ATM.solicitudDeTransaccion(solicitudDeExtraccion);

                            if (codigoResultado.equalsIgnoreCase("0")) {

                                ATM.getPantalla().imprimir("Retiro de Dinero exitoso, su saldo actual es: "
                                        + usuarioLogueado.getCuentaBancaria().getSaldo() + "\n");

                                ATM.setEfectivoDelCajero(ATM.getEfectivoDelCajero() - montoRetiro);

                            } else if (codigoResultado.equalsIgnoreCase("1")) {

                                ATM.getPantalla().imprimir("El monto ingresado supera el saldo de su cuenta\n");

                            } else if (codigoResultado.equalsIgnoreCase("2")) {
                                ATM.getPantalla()
                                        .imprimir("El monto a extraer debe ser multiplo de "
                                                + ATM.getDispensadorDeEfectivo().getDenominacion()
                                                + "\n");

                            } else if (codigoResultado.equalsIgnoreCase("3")) {
                                ATM.getPantalla().imprimir(
                                        "Disculpe, el cajero no tiene fondos para procesar dicha operacion, intente con un monto menor\n");

                            } else {
                                ATM.getPantalla().imprimir("Error indeterminado\n");
                            }

                            break;
                        case 3:
                            ConsultaSaldo solicitudDeSaldo = new ConsultaSaldo(usuarioLogueado);
                            ATM.getPantalla().imprimir(ATM.solicitudDeTransaccion(solicitudDeSaldo));
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
