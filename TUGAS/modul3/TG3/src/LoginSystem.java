import java.util.ArrayList;
import java.util.Scanner;

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

class Admin extends User {
    private String username;
    private String password;

    public Admin(String nama, long nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("==== Informasi Pengguna ====");
        System.out.println("Username: " + username);
    }
}

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

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Admin> daftarAdmin = new ArrayList<>();
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        daftarAdmin.add(new Admin("Admin Satu", 123456L, "admin", "admin123"));
        daftarMahasiswa.add(new Mahasiswa("M. Rudi Mustakim", 202410370110136L));
        daftarMahasiswa.add(new Mahasiswa("Masdar helmi", 202410370110133L));

        boolean loginSukses = false;

        while (!loginSukses) {
            System.out.println("\nPilih jenis login:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Pilih opsi Anda (1/2): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();

                    for (Admin admin : daftarAdmin) {
                        if (admin.login(username, password)) {
                            System.out.println("Login Admin Berhasil!");
                            admin.displayInfo();
                            loginSukses = true;
                            break;
                        }
                    }

                    if (!loginSukses) {
                        System.out.println("Login gagal! Username atau password salah.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan Nama: ");
                    String namaMahasiswa = scanner.nextLine();
                    System.out.print("Masukkan NIM: ");
                    long nimMahasiswa = scanner.nextLong();
                    scanner.nextLine();

                    for (Mahasiswa mahasiswa : daftarMahasiswa) {
                        if (mahasiswa.login(namaMahasiswa, nimMahasiswa)) {
                            System.out.println("Login Mahasiswa Berhasil!");
                            mahasiswa.displayInfo();
                            loginSukses = true;
                            break;
                        }
                    }

                    if (!loginSukses) {
                        System.out.println("Login gagal! Nama atau NIM salah.");
                    }
                    break;

                default:
                    System.out.println("Input tidak valid!");
                    break;
            }
        }

        scanner.close();
    }
}
