import java.util.Scanner;

public class Roles {
    private String sesion;

    public Roles() {
    }
    public void tipoUsuario() {
        Scanner type_user = new Scanner(System.in);
        System.out.println("Digite el tipo de usuario: Administrador / Operario");
        String usuario = type_user.nextLine();
        if (usuario.equalsIgnoreCase("Operario")) {
            sesion="Operario";
            System.out.println("La sesión es : "+sesion);
        }
        else if (usuario.equalsIgnoreCase("Administrador")) {
            sesion="Administrador";
            System.out.println("La sesion es: "+sesion);
        } else {
            System.out.println("No tiene sesión iniciada ");
            sesion=null;
            System.exit(0);
        }
    }
}
