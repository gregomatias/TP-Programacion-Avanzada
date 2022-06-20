package servicio;

import java.util.ArrayList;

import usuario.Usuario;

public class BaseDeDatos {
    
    private static ArrayList<Usuario> baseDeDatos = new ArrayList<Usuario>();

    public static void altaDeUsuario(Usuario nuevoUsuario) {

        baseDeDatos.add(nuevoUsuario);

    }

    public static void bajaDeUsuario(Usuario nuevoUsuario) {

        baseDeDatos.remove(nuevoUsuario);

    }

    public static Usuario obtieneUsuario(int numeroCuenta, int claveNIPI) {

        for (Usuario usuario : baseDeDatos) {

            if (usuario.getCuentaBancaria().getNumeroCuenta() == numeroCuenta) {

                if (usuario.getClaveNIP() == claveNIPI) {

                    return usuario;

                }
            }

        }

        return null;

    }

}
