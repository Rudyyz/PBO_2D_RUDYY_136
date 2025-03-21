//codingan saya tambahkan untuk user dapat mengimput data nama, kesehatan dan demek

import java.util.Scanner;

class KarakterGame{
    private String nama;
    private int kesehatan;

    public KarakterGame(String nama, int kesehatan){
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama(){
        return nama;
    }
    public int getKesehatan(){
        return kesehatan;
    }

    public void setNama(String nama){
        this.nama = nama;
    }public void setKesehatan(int kesehatan){
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target){
        System.out.println(this.nama +"Menyerang "+ target.getNama());
    }
    public void status(){
        System.out.println(nama+ " Memiliki Kesehatan : " +kesehatan);
    }

}
class pahlawan extends KarakterGame{
    private int demek;
    public pahlawan(String nama, int kesehatan, int demek){
        super(nama,kesehatan);
        this.demek = demek;
    }
    public void serang(KarakterGame target){
        System.out.println(getNama()+ " Menyertang "+target.getNama()+" Menggunakan Pedang");
        target.setKesehatan(target.getKesehatan() -demek);
        System.out.println("Kesehatan terbaru " +target.getKesehatan());
    }
    public void status(){
        System.out.println(getNama()+ " Memiliki Kesehatan : " +getKesehatan());
        System.out.println(getNama()+ " Kekuatan Serangan : " +demek);
    }

}

class Musuh extends KarakterGame{
    private int demek;
    public Musuh(String nama, int kesehatan, int demek){
        super(nama, kesehatan);
        this.demek = demek;
    }
    public void serang(KarakterGame target){
        System.out.println(getNama()+ " Menyerang "+ target.getNama()+ " Menggunkan sihir");
        target.setKesehatan(target.getKesehatan() -demek);
        System.out.println("Kesehatan Terbaru "+target.getKesehatan());
    }
    public void status(){
        System.out.println(getNama()+ " Memiliki Kesehatan : " +getKesehatan());
        System.out.println(getNama()+ " Kekuatan Serangan : " +demek);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan nama pahlawan : ");
        String namaPahlawan = input.nextLine();
        System.out.print("Masukan Kesehatan Pahlawan : ");
        int kesehatanPahlawan = input.nextInt();
        System.out.print("Demek dari pahlawan : ");
        int demekPahlawan = input.nextInt();
        input.nextLine();

        System.out.print("Masukan nama Musuh : ");
        String namaMusuh = input.nextLine();
        System.out.print("Masukan Kesehatan Musuh : ");
        int kesehatanMusuh = input.nextInt();
        System.out.print("Demek dari musuh : ");
        int demekMusuh = input.nextInt();

        pahlawan pahlawanObj = new pahlawan(namaPahlawan, kesehatanPahlawan, demekPahlawan);
        Musuh musuhObj = new Musuh(namaMusuh, kesehatanMusuh, demekMusuh);

        System.out.println("\n=== STATUS AWAL ===");
        pahlawanObj.status();
        musuhObj.status();

        System.out.println("\n=== PERTARUNGAN ===");
        pahlawanObj.serang(musuhObj);
        musuhObj.serang(pahlawanObj);

        System.out.println("\n=== STATUS AHIR ===");
        pahlawanObj.status();
        musuhObj.status();
    }
}