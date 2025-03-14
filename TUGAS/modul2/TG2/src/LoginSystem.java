import java.util.Scanner;

class Admin {
    private final String username = "RUDI";
    private final String PW = "123";

    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(PW);
    }
}

class Mahasiswa {
    private final String nama = "M Rudi Mustakim";
    private final long nim = 202410370110136L;

    public boolean login(String inputNama, long inputNim) {
        return inputNama.equals(nama) && inputNim == nim;
    }

    public void tampilanInfo() {
        System.out.println("Login Mahasiswa Berhasil!");
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
    }
}

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih opsi anda (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                if (admin.login(username, password)) {
                    System.out.println("Login Admin Berhasil!");
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
                break;

            case 2:
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                long nim = scanner.nextLong();

                if (mahasiswa.login(nama, nim)) {
                    mahasiswa.tampilanInfo();
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
                break;

            default:
                System.out.println("Input tidak valid!");
                break;
        }
        scanner.close();
    }
}
