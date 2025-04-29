class Batman{
    Boolean suara;
    double jarak;
    double suhu;
    String posisiSayap;
    int performa;

    public Batman(){
        this.jarak = 0;
        this.performa = 1;
        this.suhu = 30;
    }

    public Batman(boolean suara, double jarak, double suhu, String posisiSayap, int performa){
        this.suara =suara;
        this.jarak =jarak;
        this.suhu =suhu;
        this.posisiSayap =posisiSayap;
        this.performa =performa;

    }
    public void berbicara(boolean suara){
        this.suara=suara;
    }
    public void setTerbang(double jarakNew){
        if (jarakNew > this.performa * 10) {
            System.out.println("performa tidak mendukung");
        } else {
            this.jarak = jarakNew;
        }
    }

    public double getJarak() {
        return jarak;
    }
    void setPerforma(int performa){
        this.performa = performa;
    }

    public void bergelantungan(){
        if (this.suhu >= 25){
            this.posisiSayap ="membuka";
        }else{
            this.posisiSayap ="menutup";
        }
    }
}


class BatmenJR extends Batman{
    int peluru;
    BatmenJR(Boolean suara, double jarak, double suhu, String posisiSayap, int performa, int peluru){
        super(suara, jarak, suhu, posisiSayap, performa);
        this.peluru = peluru;
    }

    public BatmenJR(){
        this.peluru =10;
    }
    public int getPeluru(){
        return peluru;
    }

    public void tembak(){
        if (getPeluru() == 0){
            System.out.println("Peluru dalam keadaan kosong");
        }else{
            peluru--;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        BatmenJR anakBatman = new BatmenJR(true, 0, 30, "menutup", 1, 5);

        anakBatman.berbicara(true);
        anakBatman.setPerforma(2);
        anakBatman.setTerbang(15);
        System.out.println("Jarak Setelah terbang: "+anakBatman.getJarak());

        anakBatman.bergelantungan();
        System.out.println("Jumlah peluru awal: "+anakBatman.getPeluru());

        anakBatman.tembak();
        anakBatman.tembak();

        System.out.println("Jumlah peluru setelah menembak: "+anakBatman.getPeluru());

        anakBatman.tembak();
        anakBatman.tembak();
        anakBatman.tembak();
        anakBatman.tembak();

        System.out.println("Peluru ahir: "+anakBatman.getPeluru());
    }
}