# Project-Individu-PBO
Cut Wynona Andromeda - 2408107010097

## **Deskripsi Project**

**Sistem Manajemen Penumpang Bus Nusa Ride**
Project ini merupakan simulasi sistem manajemen penumpang pada Bus Nusa Ride, yang dibangun menggunakan bahasa pemrograman Java. Program ini menerapkan konsep Object-Oriented Programming (OOP). Tujuan sistem ini adalah mengatur proses naik–turun penumpang, membedakan penumpang kursi prioritas dan biasa, serta menangani penumpang berdiri ketika kursi penuh. Sistem juga mengelola data penumpang dan saldo mereka untuk pembayaran ongkos, memastikan kapasitas bus tidak terlampaui, serta menghitung total pendapatan dari setiap penumpang yang berhasil naik.


### **Fitur Utama Program**

1. **Menambahkan Penumpang (Naik Bus)**

  * Sistem menentukan jenis penumpang secara otomatis: **Biasa** atau **Prioritas**.
  * Penempatan penumpang sesuai kategori dan kapasitas bus:
    * **Kursi Prioritas:** maksimal 4 penumpang prioritas. Hanya penumpang prioritas yang duduk di sini.
    * **Kursi Biasa:** maksimal 16 penumpang biasa. Penumpang prioritas bisa duduk di sini jika kursi prioritas penuh.
    * **Area Berdiri:** maksimal 20 penumpang berdiri, digunakan jika kursi penuh.
  * Sistem mengecek **saldo penumpang** sebelum naik, ongkos Rp 2.000 otomatis dipotong jika cukup.
  * Pendapatan bus bertambah sesuai ongkos penumpang yang berhasil naik.

2. **Menghapus Penumpang (Turun Bus)**

   * Mencari penumpang berdasarkan nama
   * Menghapus dari kursi prioritas, kursi biasa, atau area berdiri

3. **Menampilkan Kondisi Bus**

   * Daftar penumpang prioritas, biasa, dan berdiri
   * Total penumpang
   * Total pendapatan bus
   * Status kapasitas dan kursi

4. **Aturan Penumpang (Otomatis)**

   * Anak-anak (<10), lansia (>60), dan ibu hamil → otomatis prioritas
   * Penumpang biasa tidak bisa duduk di kursi prioritas
   * Penumpang prioritas boleh duduk di kursi biasa jika kursi prioritas penuh
   * Pembayaran ongkos bus otomatis dipotong dari saldo penumpang


5. **Top-Up Saldo Penumpang**

* Cari penumpang berdasarkan nama
* Tambahkan saldo sesuai jumlah yang diinginkan
* Saldo baru langsung tersimpan di objek penumpang


### **Konsep OOP yang Digunakan**

1. **Class** – `Penumpang`, `PenumpangBiasa`, `PenumpangPrioritas`, `Bus`, `AturanPenumpang`, `SaldoTidakCukup`, `SimulasiBus`.
2. **Object** – Setiap penumpang dibuat sebagai objek baru (`new PenumpangBiasa(...)` atau `new PenumpangPrioritas(...)`).
3. **Method** – Fungsi seperti `naikkan()`, `turunkanPenumpang()`, `tambahSaldo()`, `bayar()`.
4. **Encapsulation** – Atribut private di class `Penumpang` (`id`, `nama`, `umur`, `saldo`, `jenis`) dengan getter/setter (`getSaldo()`, `tambahSaldo()`).
5. **Inheritance** – `PenumpangBiasa` dan `PenumpangPrioritas` mewarisi class `Penumpang`.
6. **Polymorphism** – Objek `Penumpang` bisa merujuk ke `PenumpangBiasa` atau `PenumpangPrioritas`, method `prioritas()` berperilaku berbeda sesuai jenis.
7. **Interface** – `Pembayaran` diimplementasikan oleh class `Penumpang` (`bayar()`).
8. **Generics** – `Bus<T extends Penumpang>` untuk menampung berbagai jenis penumpang.
9. **Enum** – `JenisPenumpang` (`BIASA`, `PRIORITAS`) untuk membedakan tipe penumpang.
10. **Collection (ArrayList)** – `ArrayList<T>` digunakan untuk menyimpan penumpang prioritas, biasa, dan berdiri.
11. **Exception Handling** – Custom exception `SaldoTidakCukup` digunakan saat saldo penumpang tidak mencukupi.
    


### **Tampilan Output Program**
<img width="1733" height="651" alt="Screenshot 2025-12-08 181440" src="https://github.com/user-attachments/assets/667863ca-6535-4c0a-b799-221e6f387bd5" />

