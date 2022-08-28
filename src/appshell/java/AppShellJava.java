
package appshell.java;

import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class AppShellJava {

    public static void main(String[] args) {

        Scanner escaner = new Scanner(System.in);
        boolean seguir = false;
        do {
            System.out.println("Escoja la opción correspondiente");
            System.out.println("1.Iniciar sesión");
            System.out.println("2.Registrarse ");
            String opRegistro = escaner.nextLine();

            if (opRegistro.equalsIgnoreCase("1")) {
                System.out.println("\n\n");
                System.out.println("Desea continuar con el proceso \n digite la opción correspondiente \n 1. si,continuar con el proceso \n 2. no, devolver al menu");
                String respuesta = escaner.nextLine();
                if (respuesta.equalsIgnoreCase("1")) {
                    System.out.println("Ingrese correo");
                    String correo = escaner.nextLine();
                    System.out.println("Ingrese contraseña");
                    String contraseña = escaner.nextLine();
                    System.out.println("Ha iniciado sesión con exito");
                    seguir = false;
                } else {
                    seguir = true;
                }

            } else if (opRegistro.equalsIgnoreCase("2")) {
                System.out.println("Desea continuar con el proceso \n digite la opción correspondiente \n 1. si,continuar con el proceso \n 2. no, devolver al menu");
                String respuesta = escaner.nextLine();
                if (respuesta.equalsIgnoreCase("1")) {
                    System.out.println("Ingrese correo");
                    String correo = escaner.nextLine();
                    System.out.println("Ingrese contraseña");
                    String contraseña = escaner.nextLine();
                    System.out.println("Se ha registrado con exito");
                    seguir = false;
                } else {
                    seguir = true;
                }
            } else {
                System.out.println("Digite una opción valida");
                seguir = true;
            }
        } while (seguir);
        
        try{
        
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

}
