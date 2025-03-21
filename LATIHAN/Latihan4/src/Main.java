import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

class staf{
    String nama;
    String alamat;
    double gajiPokok;
    double tunjangan;
    int level;

    public staf(String nama, String alamat, double gajiPokok, double tunjangan, int level){
        this.alamat = alamat;
        this.nama = nama;
        this.gajiPokok = gajiPokok;
        this.tunjangan = tunjangan;
        this.level = level;
    }

    public String getNama(){
        return nama;
    }
    public String getAlamat(){
        return alamat;
    }
    public int getLevel(){
        return level;
    }
    double bayarGaji(){
        return gajiPokok + tunjangan;
    }

    public String formatRp(double nilai){
        Locale localeID = new Locale("id", "ID");
        NumberFormat formatRp = NumberFormat.getCurrencyInstance(localeID);
        return formatRp.format(nilai);
    }
}

class meneger extends staf{
    meneger(String nama, String alamat, double gajiPokok, double tunjangan, int level){
        super(nama, alamat, gajiPokok, tunjangan, level);
    }

    double bayarMeneger(){
        double totalGaji = bayarGaji();
        if (level == 1){
            totalGaji += 300;
        }else if (level == 2){
            totalGaji += 400;
        }else if (level == 3){
            totalGaji += 500;
        }
        return totalGaji;
    }

    public void cetakInfo(){
        System.out.println("Meneger "+nama+ ", Alamat "+alamat);
        System.out.print("Gaji yang diterima "+formatRp(bayarMeneger()));
    }
}

class direktur extends staf{
    private char kodeDir;
    direktur(String nama, String alamat, double gajiPokok, double tunjangan, char kodeDir) {
        super(nama, alamat, gajiPokok, tunjangan, 0);
        this.kodeDir = kodeDir;
    }
    public char getKodeDir(){
        return kodeDir;
    }
    double bonus(){
        if (kodeDir == 'A'){
            return  1000;
        } else if (kodeDir == 'B') {
            return  2000;
        } else if (kodeDir == 'C') {
            return  3000;
        }else {
            return 0;
        }
    }
    double bayarDirektur(){
        return bayarGaji() + bonus();
    }

    public void cetakInfo(){
        System.out.println("Direktur Keuangan " + nama + ", Alamat: " + alamat);
        System.out.print("Gaji diterima " + formatRp(bayarDirektur()));
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n=== Input Data Manager ===");
        System.out.print("nama :");
        String namaM = input.nextLine();
        System.out.print("alamat :");
        String alamatM = input.nextLine();
        System.out.print("Gaji Pokok :");
        double gajiM = input.nextDouble();
        System.out.print("Tunjangan :");
        double tunjanganM = input.nextDouble();
        System.out.print("Level (1-3) :");
        int levelM = input.nextInt();

        meneger menegerObj = new meneger(namaM, alamatM, gajiM, tunjanganM, levelM);
        menegerObj.cetakInfo();

        System.out.println("\n=== Input Data Direktur ===");
        System.out.print("nama :");
        input.nextLine();
        String namaD = input.nextLine();
        System.out.print("alamat :");
        String alamatD = input.nextLine();
        System.out.print("Gaji Pokok :");
        double gajiD = input.nextDouble();
        System.out.print("Tunjangan :");
        double tunjanganD = input.nextDouble();
        System.out.print("kode Direktur A/B/C :");
        char kodeDir = input.next().charAt(0);

        direktur direkturObj = new direktur(namaD, alamatD, gajiD, tunjanganD, kodeDir);
        direkturObj.cetakInfo();
    }
}