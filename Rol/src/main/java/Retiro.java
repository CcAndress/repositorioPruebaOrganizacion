<<<<<<< Updated upstream:src/main/java/Retiro.java
public class Retiro extends MovimientoDinero {
    @Override
=======
import java.util.Scanner;

public class Retiro extends MovimientoDinero {

>>>>>>> Stashed changes:Rol/src/main/java/Retiro.java
    public void Transacciones() {
        System.out.print("Cuanto deseas retirar: ");
        Retiro();
        if (retiro <= getSaldo()) {
            transacciones = getSaldo();
            setSaldo(transacciones - retiro);
            System.out.println("Retiraste : " + retiro);
            System.out.println("Tu saldo actual es: " + getSaldo());
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
<<<<<<< Updated upstream:src/main/java/Retiro.java
}
=======
}
>>>>>>> Stashed changes:Rol/src/main/java/Retiro.java
