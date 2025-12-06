// Interface untuk aturan pembayaran ongkos bus.
public interface Pembayaran {
    void bayar(int ongkos) throws SaldoTidakCukup;
}

