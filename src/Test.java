import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //INstancio primer Scanner:
        Scanner scanner = new Scanner(System.in);

        System.out.println("Primer ingreso\n");
        int primerIngreso = scanner.nextInt();

        //Cierro el primer Scanner
        scanner.close();

        //Abro un nuevo Scanner:
        Scanner scanner2 = new Scanner(System.in);

        //Esto produece un error:
        System.out.println("Segundo ingreso\n");
        int segundoIngreso = scanner2.nextInt();
    }

}
