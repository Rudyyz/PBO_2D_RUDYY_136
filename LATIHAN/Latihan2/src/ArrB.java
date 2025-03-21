public class ArrB {
    // Atribut (Instance Variables)
    private int[] bilangan; // Array untuk menyimpan elemen bilangan bulat

    // Konstruktor (Constructor)
    private ArrB(int[] bilangan) {
        this.bilangan = bilangan.clone(); // Menghindari modifikasi langsung dari luar
    }

    // Method untuk menampilkan semua elemen array
    public void tampilkanArray() {
        System.out.print("Isi Array: ");
        for (int angka : bilangan) {
            System.out.print(angka + " "); // Menampilkan elemen array dengan spasi
        }
        System.out.println(); // Pindah ke baris baru setelah selesai menampilkan array
    }

    // Method untuk mendapatkan nilai pada indeks tertentu
    public int ambilElemen(int indeks) {
        // Cek apakah indeks valid
        if (indeks >= 0 && indeks < bilangan.length) {
            return bilangan[indeks]; // Mengembalikan nilai pada indeks yang diberikan
        } else {
            throw new IndexOutOfBoundsException("Indeks di luar batas array!"); // Error jika indeks tidak valid
        }
    }

    // Method untuk mengubah nilai pada indeks tertentu
    public void ubahElemen(int indeks, int nilaiBaru) {
        // Cek apakah indeks valid
        if (indeks >= 0 && indeks < bilangan.length) {
            bilangan[indeks] = nilaiBaru; // Mengubah nilai pada indeks yang diberikan
        } else {
            throw new IndexOutOfBoundsException("Indeks di luar batas array!"); // Error jika indeks tidak valid
        }
    }

    // Method utama (Main) untuk menguji class
    public static void main(String[] args) {
        // Membuat array awal
        int[] data = {10, 20, 30, 40, 50};

        // Membuat objek ArrayBilangan
        ArrB arrayObj = new ArrB(data);

        // Menampilkan array awal
        System.out.println("Array awal:");
        arrayObj.tampilkanArray();

        // Mengambil elemen di indeks 2
        System.out.println("Elemen di indeks 2: " + arrayObj.ambilElemen(2));

        // Mengubah elemen di indeks 2 menjadi 99
        arrayObj.ubahElemen(2, 99);

        // Menampilkan array setelah diubah
        System.out.println("Array setelah diubah:");
        arrayObj.tampilkanArray();
    }
}
