import java.util.Scanner;

import cajero.BaseDeDatos;
import cajero.CajeroAutomatico;
import cajero.CuentaBancaria;
import cajero.Usuario;

public class App {

    public static void main(String[] args) throws Exception {

     
        // boolean esUsuarioValido =false;
       
        /* ####Alta Usuario BD#### */
        CajeroAutomatico ATM = new CajeroAutomatico();

        CuentaBancaria cuenta1 = new CuentaBancaria(500, 12345);
        Usuario usuario1 = new Usuario(54321, cuenta1);
        BaseDeDatos.altaDeUsuario(usuario1);

        System.out.println("Bienvenido al Cajero Automatico ATM\n");

        

        if (!(BaseDeDatos.retornaUsuarioValidado()==null)) {
            Scanner scanner = new Scanner(System.in);
         

            boolean usuarioLogueado=true;

            while (usuarioLogueado) {

                 System.out.println("1-Realizar Deposito 2- Retirar dinero 3 Consulta de Saldo\n");
                int menuOpciones = scanner.nextInt();
             //   System.out.println(menuOpciones);


                scanner.close();
                usuarioLogueado=false;
            }
     

        } else {
            System.out.println(
                    "Disculpe, ha superado la cantidad de intentos, por su seguridad su tarjeta ha sido retenida. llame al Banco");
        }

        //scanner.close();

    }
}
