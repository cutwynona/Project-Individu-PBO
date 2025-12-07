// Class Penumpang mewakili data setiap penumpang bus, termasuk ID, nama, umur,
// status hamil, saldo, serta penentuan jenis penumpang (biasa/prioritas).
// Class ini juga menangani proses pembayaran ongkos dan pengecekan prioritas.
public class Penumpang implements Pembayaran {

    private int id;           // ID unik penumpang
    private String nama;      // Nama penumpang
    private int umur;         // Umur penumpang
    private boolean hamil;    // Status hamil
    private int saldo;        // Saldo kartu penumpang
    private JenisPenumpang jenis; // Jenis penumpang (PRIORITAS/BIASA)

    // Constructor: inisialisasi data penumpang dan saldo awal 10.000
    public Penumpang(int id, String nama, int umur, boolean hamil) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = 10000;
        this.jenis = AturanPenumpang.tentukan(umur, hamil);
    }

    // Getter
    public int getID() { return id; }
    public String getNama() { return nama; }
    public int getUmur() { return umur; }
    public boolean getHamil() { return hamil; }
    public int getSaldo() { return saldo; }
    public JenisPenumpang getJenis() { return jenis; }

    // Menambah saldo kartu penumpang
    public void tambahSaldo(int jumlah) {
        saldo += jumlah;
    }

    // Mengurangi saldo saat membayar ongkos
    public void kurangiSaldo(int ongkos) throws SaldoTidakCukup {
        bayar(ongkos);
    }

    // Override dari Pembayaran: memotong saldo, dan gagal jika saldo kurang.
    @Override
    public void bayar(int ongkos) throws SaldoTidakCukup {
        if (saldo < ongkos)
            throw new SaldoTidakCukup("Saldo tidak cukup!");
        saldo -= ongkos;
    }

    // Cek apakah penumpang termasuk prioritas
    public boolean prioritas() {
        return jenis == JenisPenumpang.PRIORITAS;
    }

    // Info singkat penumpang (nama + ID)
    public String info() {
        return nama + " (ID: " + id + ")";
    }
}

