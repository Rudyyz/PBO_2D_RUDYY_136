class Mahasiswa extends User {
    public Mahasiswa(String nama, long nim) {
        super(nama, nim);
    }

    public boolean login(String nama, long nim) {
        return this.nama.equalsIgnoreCase(nama) && this.nim == nim;
    }

    @Override
    public void displayInfo() {
        System.out.println("==== Informasi Pengguna ====");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}