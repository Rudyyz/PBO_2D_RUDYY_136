class User {
    protected String nama;
    protected long nim;

    public User(String nama, long nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }
    public long getNim() {
        return nim;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setNim(long nim) {
        this.nim = nim;
    }

    public void displayInfo() {
        System.out.println("==== Informasi Pengguna ====");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}