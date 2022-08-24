public class Consulta extends MovimientoDinero {
    @Override
    public void Transacciones(){
        System.out.println("Tu saldo actual es: " + getSaldo());
    }
}
