public class Deposito extends MovimientoDinero {

    public void Transacciones(){
        System.out.print("Cuanto deseas depositar: ");
        Deposito();

        transacciones = getSaldo();
        setSaldo(transacciones + deposito);
        System.out.println("Depositaste: " + deposito);
        System.out.println("Tu saldo actual es: " + getSaldo());
    }
}