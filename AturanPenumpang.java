public class AturanPenumpang {
    // Menentukan jenis penumpang: 
    // PRIORITAS = lansia (>60), anak-anak (<10), atau ibu hamil
    // BIASA = selain kriteria di atas
    public static JenisPenumpang tentukan(int umur, boolean hamil) {
        if (umur < 10 || umur > 60 || hamil) {
            return JenisPenumpang.PRIORITAS;
        }
        return JenisPenumpang.BIASA;
    }
}

