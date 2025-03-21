class mobil{
    String nama_mobil;
    int tahun;

    public mobil(String nama_mobil, int tahun){
        this.nama_mobil = nama_mobil;
        this.tahun = tahun;
    }

    public void tampil(){
        System.out.println("mobil saya "+nama_mobil+" tahun pembuatan "+tahun);
    }
}
class mobil_listrik extends mobil{
    int batre;

    public mobil_listrik(String nama_mobil, int tahun, int batre){
        super(nama_mobil, tahun);
        this.batre = batre;
    }

    public void tampil1(){
        System.out.println("Mobil saya "+nama_mobil+" Tahun pembuatan "+tahun+" kapasitas batre adalah "+batre+"MAH");
    }
}
public class Main {
    public static void main(String[] args)
    {
        mobil mobilobj = new mobil("rubicon", 2020);
        mobil_listrik mobil_listrikobj = new mobil_listrik("wuling", 2024, 30000);

        mobilobj.tampil();
        mobil_listrikobj.tampil1();
    }

}