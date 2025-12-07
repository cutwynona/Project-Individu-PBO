import java.util.ArrayList;

// Class Bus mengelola penumpang: prioritas, biasa, dan berdiri.
// Termasuk pengecekan ID, pembayaran ongkos, pendapatan,
// serta proses naik dan turun penumpang.
public class Bus<T extends Penumpang> {

    private ArrayList<T> prioritas = new ArrayList<>();
    private ArrayList<T> biasa = new ArrayList<>();
    private ArrayList<T> berdiri = new ArrayList<>();

    public static final int ONGKOS = 2000;
    private int pendapatan = 0;

    // Mengecek apakah ID penumpang sudah ada di dalam bus
    private boolean idSudahAda(int id) {
        for (T p : prioritas) if (p.getID() == id) return true;
        for (T p : biasa) if (p.getID() == id) return true;
        for (T p : berdiri) if (p.getID() == id) return true;
        return false;
    }

    // Menambahkan penumpang ke bus (cek ID, cek saldo, pilih tempat duduk)
    public boolean naikkan(T p) {
        if (idSudahAda(p.getID())) {
            System.out.println("ID " + p.getID() + " sudah terdaftar. Gunakan ID lain.");
            return false;
        }

        // Pembayaran ongkos
        try {
            p.bayar(ONGKOS);
            pendapatan += ONGKOS;
        } catch (SaldoTidakCukup e) {
            System.out.println("Gagal naik: " + e.getMessage());
            return false;
        }

        // Logika penempatan kursi berdasarkan prioritas
        if (p.prioritas()) {
            if (prioritas.size() < 4) {
                prioritas.add(p);
            } else if (biasa.size() < 16) {
                biasa.add(p);
            } else if (berdiri.size() < 20) {
                berdiri.add(p);
            } else {
                System.out.println("Bus penuh!");
                return false;
            }
        } else {
            if (biasa.size() < 16) {
                biasa.add(p);
            } else if (berdiri.size() < 20) {
                berdiri.add(p);
            } else {
                System.out.println("Bus penuh!");
                return false;
            }
        }

        return true;
    }

    // Menurunkan penumpang berdasarkan nama
    public boolean turunkanPenumpang(String nama) {
        if (hapusNama(prioritas, nama)) return true;
        if (hapusNama(biasa, nama)) return true;
        return hapusNama(berdiri, nama);
    }

    // Menghapus penumpang dari suatu list
    private boolean hapusNama(ArrayList<T> list, String nama) {
        for (T p : list) {
            if (p.getNama().equalsIgnoreCase(nama)) {
                list.remove(p);
                return true;
            }
        }
        return false;
    }

    // Getter untuk kategori penumpang
    public ArrayList<T> getPenumpangBiasa() { return new ArrayList<>(biasa); }
    public ArrayList<T> getPenumpangPrioritas() { return new ArrayList<>(prioritas); }
    public ArrayList<T> getPenumpangBerdiri() { return new ArrayList<>(berdiri); }

    // Mendapatkan seluruh penumpang (untuk top-up saldo)
    public ArrayList<T> getAllPenumpang() {
        ArrayList<T> semua = new ArrayList<>();
        semua.addAll(prioritas);
        semua.addAll(biasa);
        semua.addAll(berdiri);
        return semua;
    }

    // Getter jumlah penumpang per kategori
    public int getJumlahPenumpangBiasa() { return biasa.size(); }
    public int getJumlahPenumpangPrioritas() { return prioritas.size(); }
    public int getJumlahPenumpangBerdiri() { return berdiri.size(); }
    public int getJumlahPenumpang() { return prioritas.size() + biasa.size() + berdiri.size(); }

    // Menampilkan daftar penumpang dan pendapatan
    @Override
    public String toString() {
        return "\n========================"
                + "\nDaftar Penumpang Prioritas : " + daftar(prioritas)
                + "\nDaftar Penumpang Biasa     : " + daftar(biasa)
                + "\nDaftar Penumpang Berdiri   : " + daftar(berdiri)
                + "\nJumlah Penumpang           : " + getJumlahPenumpang()
                + "\nTotal Pendapatan           : Rp " + pendapatan
                + "\n========================\n";
    }

    // Mengubah list penumpang menjadi string
    private String daftar(ArrayList<T> list) {
        if (list.isEmpty()) return "<kosong>";
        StringBuilder sb = new StringBuilder();
        for (T p : list) {
            sb.append(p.info()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}

