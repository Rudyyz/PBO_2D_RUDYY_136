import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.plaf.synth.SynthTableHeaderUI;

class RekeningBank{
    private String norek;
    private String napem;
    private double saldo;

    public RekeningBank(String norek, String napem, double saldoAwal){
        this.norek= norek;
        this.napem= napem;
        this.saldo= saldoAwal;
    }

    public void tampilkanInfo(){
        System.out.println("Nomor Rekening  : "+this.norek);
        System.out.println("Nama Pemilik    : "+this.napem);
        System.out.println("saldo           : Rp"+this.saldo);
        System.out.println();
    }

    public void setorUang(double jumlah){
        saldo += jumlah;
        System.out.println("Berhasil menyetor Rp"+jumlah);
        System.out.println("saldo sekarang :" +saldo);
        System.out.println();
    }

    public void tarikTunai(double jumlah){
        if(saldo >= jumlah){
            saldo -= jumlah;
            System.out.println("Berhasil Menarik Rp" +jumlah);
        }
        else{
            System.out.println("Saldo Tidak mencukupi. Saldo Saat ini: Rp" +saldo);
        }
        System.out.println("Saldo Sekarang :Rp" +saldo);
        System.out.println();
    }
}
public class Main2 {
    public static void main(String[] args){
        RekeningBank Rekening1 = new RekeningBank("202410370110137", "M.Rudi Mustakim", 5000000);
        RekeningBank Rekening2 = new RekeningBank("202410370110147", "Helmmi",3000000);

        Rekening1.tampilkanInfo();
        Rekening2.tampilkanInfo();

        Rekening1.setorUang(700000);
        Rekening1.tarikTunai(2000000);
        Rekening1.tarikTunai(300000);

        Rekening2.setorUang(500000);
        Rekening2.tarikTunai(200000);

    }
}
