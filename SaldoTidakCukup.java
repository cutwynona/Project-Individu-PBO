// Exception khusus untuk menandai bahwa saldo tidak mencukupi
public class SaldoTidakCukup extends Exception {

    // Meneruskan pesan error ke superclass Exception
    public SaldoTidakCukup(String msg) {
        super(msg);
    }
}

