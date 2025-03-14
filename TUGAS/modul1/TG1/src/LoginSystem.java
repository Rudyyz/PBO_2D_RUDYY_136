import java.util.Scanner;


class Admin{
    private final String username = "RUDI";
    private final String PW = "123";

    public boolean login(String inputUsername,String inputPW){
        return inputUsername.equals(username) && inputPW.equals(PW);
    }
}

class Mahasiswa{
    private final String nama = "M Rudi Mustakim";
    private final long nim = 202410370110136l;

    public boolean login(String inputNama, Long inputnim){
        return inputNama.equals(nama) && inputnim.equals(nim);
    }

    public void tampilkanInfo(){
        System.out.println("Login Mahasiswa Berhasil");
        System.out.println("Nama :"+nama);
        System.out.println("NIM  :"+nim);
    }
}
public class LoginSystem {
    public static void main(String[] args){
        Scanner objInput = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();


        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih opsi anda (1/2): ");
        int pilihan = objInput.nextInt();
        objInput.nextLine();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan username: ");
                String username = objInput.nextLine();
                System.out.print("Masukkan password: ");
                String PW = objInput.nextLine();

                if(admin.login(username,PW)){
                    System.out.println("Login anda berhasil");
                } else {
                    System.out.println("Login gagal! username atau password salah");
                } break;

            case 2:
                System.out.print("Masukkan Nama: ");
                String nama = objInput.nextLine();
                System.out.print("Masukkan NIM: ");
                long NIM = objInput.nextLong();

                if(mahasiswa.login(nama,NIM)){
                    System.out.println("Login Mahasiswa Berhasil!");
                    System.out.println("Nama: " + nama);
                    System.out.println("NIM: " + NIM);
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah");
                } break;


            default:
                System.out.println("Input tidak valid!");
                break;
        }
        objInput.close();
    }
}
