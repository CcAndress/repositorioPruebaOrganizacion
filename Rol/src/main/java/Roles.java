import java.util.Scanner;

public class Roles {
    static String usuario;
    static String sesion;

    public Roles() {
    }
    public void tipoUsuario() {

        Scanner type_emp = new Scanner(System.in);
        System.out.println("Tipo usuario: ");
        Scanner type_usuario = new Scanner(System.in);
        String type_empleado = type_emp.nextLine();
        if (type_empleado.equalsIgnoreCase("Opera")) {
            sesion = "Operario";
            System.out.println("Digite el nombre de usuario: ");
            usuario = type_usuario.nextLine();
            System.out.println("La sesión es : " + sesion);
        } else if (type_empleado.equalsIgnoreCase("Admin")) {
            sesion = "Administrador";
            System.out.println("Digite el nombre de usuario: ");
            usuario = type_usuario.nextLine();
            System.out.println("La sesion es: " + sesion);
        } else {
            System.out.println("Debe iniciar sesion para continuar ");
            System.exit(0);
        }
    }
}
