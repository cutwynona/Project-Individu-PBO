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

    
