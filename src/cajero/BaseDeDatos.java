package cajero;

import java.util.ArrayList;
import java.util.Scanner;

public class BaseDeDatos {
    private static ArrayList<Usuario> baseDeDatos = new ArrayList<Usuario>();

    public static void altaDeUsuario(Usuario nuevoUsuario) {

        baseDeDatos.add(nuevoUsuario);

    }

    public static void bajaDeUsuario(Usuario nuevoUsuario) {

        baseDeDatos.remove(nuevoUsuario);

    }

    public static Usuario obtieneUsuario(int numeroCuenta) {

        for (Usuario usuario : baseDeDatos) {

            if (usuario.getCuentaBancaria().getNumeroCuenta() == numeroCuenta) {
                return usuario;
            }

        }

        return null;

    }

    public static Usuario retornaUsuarioValidado() {
        Scanner scanner = new Scanner(System.in);
        boolean esUsuarioValido = false;
        int intentosDeLogueo = 3;
        // Tres intentos de logueo
        while (intentosDeLogueo > 0 && esUsuarioValido == false) {

            intentosDeLogueo--;
            System.out.println("Ingrese su numero de cuenta Bancaria\n");
            int numeroCuentaIngresada = scanner.nextInt();

            System.out.println("Ingrese su clave NIP de 5 digitos\n");
            int claveNIPIngresada = scanner.nextInt();

            if (!(BaseDeDatos.obtieneUsuario(numeroCuentaIngresada) == null)) {
                Usuario usuarioBD = BaseDeDatos.obtieneUsuario(numeroCuentaIngresada);

                if (usuarioBD.getClaveNIP() == claveNIPIngresada) {

                    scanner.close();
                    return usuarioBD;

                } else {

                    System.out.println("Numero de cuenta o clave invalido");
                }

            } else {
                System.out.println("Numero de cuenta o clave invalido");
            }

        }

        scanner.close();
        return null;
    }

}
