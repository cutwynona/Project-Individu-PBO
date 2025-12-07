// Class SimulasiBus berfungsi sebagai program utama yang menampilkan menu,
// menerima input user, serta memanggil fungsi-fungsi pada class Bus.
import java.util.Scanner;

public class SimulasiBus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bus<Penumpang> bus = new Bus<>();

        // Tampilan judul 
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║        SISTEM BUS NUSA RIDE        ║");
        System.out.println("╚════════════════════════════════════╝");
        String welcome = "   Selamat datang di Bus Nusa Ride! ";
        for(char c : welcome.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(50); } catch(Exception e) {}
        }
        System.out.println("\n");

        // Perulangan utama untuk menampilkan menu dan memproses input
        while (true) {
            System.out.println("\nMENU :");
            System.out.println("1. Naikkan Penumpang");
            System.out.println("2. Turunkan Penumpang");
            System.out.println("3. Tambah Saldo Penumpang");
            System.out.println("4. Lihat Status Bus");
            System.out.println("5. Keluar");
            System.out.print("Pilihan (1-5): "); 
            int pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {

                // Proses menambah penumpang berdasarkan input pengguna
                case 1:
                    System.out.print("ID Penumpang: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nama: ");
                    String nama = sc.nextLine();

                    System.out.print("Umur: ");
                    int umur = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Hamil (y/n): ");
                    boolean hamil = sc.nextLine().equalsIgnoreCase("y");

                    // Menentukan apakah penumpang prioritas atau biasa
                    Penumpang p = AturanPenumpang.tentukan(umur, hamil) == JenisPenumpang.PRIORITAS ?
                            new PenumpangPrioritas(id, nama, umur, hamil) :
                            new PenumpangBiasa(id, nama, umur, hamil);

                    if (bus.naikkan(p))
                        System.out.println("Penumpang berhasil ditambahkan!");
                    else
                        System.out.println("Gagal menambahkan penumpang (bus penuh atau saldo kurang).");

                    System.out.println("------------------------------------");
                    break;

                // Proses menurunkan penumpang berdasarkan nama
                case 2:
                    System.out.print("Nama: ");
                    String namaTurun = sc.nextLine();

                    if (bus.turunkanPenumpang(namaTurun))
                        System.out.println("Penumpang berhasil turun.");
                    else
                        System.out.println("Penumpang tidak ditemukan.");

                    System.out.println("------------------------------------");
                    break;

                // Proses top up saldo penumpang
                case 3:
                    System.out.print("Nama: ");
                    String namaTopUp = sc.nextLine();

                    System.out.print("Jumlah top up: ");
                    int jumlah = sc.nextInt();
                    sc.nextLine();

                    boolean ditemukan = false;

                    // Mencari penumpang berdasarkan nama
                    for (Penumpang pen : bus.getAllPenumpang()) {
                        if (pen.getNama().equalsIgnoreCase(namaTopUp)) {
                            pen.tambahSaldo(jumlah);
                            System.out.println("Top-up berhasil. Saldo sekarang: " + pen.getSaldo());
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan)
                        System.out.println("Penumpang tidak ditemukan.");

                    System.out.println("------------------------------------");
                    break;

                // Menampilkan seluruh status bus 
                case 4:
                    System.out.println("\n===== STATUS BUS =====");
                    System.out.println(bus);
                    System.out.println("======================");
                    break;

                // Keluar dari program
                case 5:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    sc.close();
                    return;

                // Penanganan apabila input tidak valid
                default:
                    System.out.println("Pilihan tidak valid.");
                    System.out.println("------------------------------------");
                    break;
            }
        }
    }
}


