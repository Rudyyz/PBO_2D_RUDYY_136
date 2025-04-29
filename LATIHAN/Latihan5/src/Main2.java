interface Kucing {
    void berjalan(boolean jalan);
}

interface Manusia {
    void berbicara(Boolean suara);
}

class Doraemon implements Kucing, Manusia {
    boolean suara;
    boolean balingBaling;
    String warna;
    String ekor;

    public Doraemon(String warna, String ekor) {
        this.warna = warna;
        this.ekor = ekor;
    }

    public void getTerbang() {
        this.balingBaling = true;
        berjalan(false);
    }

    public void getInfo() {
        System.out.println("Warna: " + this.warna);
        System.out.println("Ekor: " + this.ekor);
        System.out.println("Jumlah kaki: 2");
    }

    public void berjalan(boolean jalan) {
        this.balingBaling = false;
        System.out.println("Berjalan: " + jalan);
    }

    public void berbicara(Boolean suara) {
        this.suara = suara;
        System.out.println("Berbicara: " + suara);
    }
}

class Doramona extends Doraemon {

    public Doramona() {
        super("pink", "panjang");
    }


    public void berbicara(Boolean suara) {
        super.suara = suara;
        System.out.println("Doramona sedang berbicara: " + suara);
    }
}


public class Main2 {
    public static void main(String[] args) {
        System.out.println("==DORAEMON==");
        Doraemon d = new Doraemon("biru", "pendek");
        d.getInfo();
        d.berbicara(true);
        d.berjalan(true);
        d.getTerbang();

        System.out.println("\n==DORAMONA==");
        Doramona dm = new Doramona();
        dm.getInfo();
        dm.berbicara(true);
        dm.berjalan(true);
        dm.getTerbang();
    }
}