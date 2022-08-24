import java.util.Scanner;

public abstract class MovimientoDinero {
    protected int transacciones, retiro, deposito;
    private static int saldo;
    Scanner entrada = new Scanner(System.in);

    public void Operaciones() {
        int bandera = 0;
        int seleccion = 0;
        do {
            do {
                System.out.println("Porfavor seleccione una opción:");
                System.out.println("1. Consulta");
                System.out.println("2. Retiro");
                System.out.println("3. Deposito");
                System.out.println("4. Salir");
                seleccion = entrada.nextInt();

                if (seleccion >= 1 && seleccion <= 4) {
                    bandera = 1;
                } else {
                    System.out.println("Error de opcion.");
                }
            } while (bandera == 0);

            if(seleccion == 1){
                MovimientoDinero mensajero = new Consulta();
                mensajero.Transacciones();
            }else if(seleccion == 2){
                MovimientoDinero mensajero = new Retiro();
                mensajero.Transacciones();
            } else if(seleccion == 3){
                MovimientoDinero mensajero = new Deposito();
                mensajero.Transacciones();
            } else if(seleccion == 4){
                System.out.println("¡Gracias!");
                bandera = 2;
            }
        } while (bandera != 2);
    }

    public void Retiro(){
        retiro = entrada.nextInt();
    }

    public void Deposito(){
        deposito = entrada.nextInt();
    }

    public abstract void Transacciones();

    //setter y getter
    public int getSaldo(){
        return saldo;
    }

    public void setSaldo(int saldo){
        this.saldo = saldo;
    }
}
