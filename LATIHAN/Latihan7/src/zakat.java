abstract class zakat1 {
    int umur;
    abstract int hitungZakat();
}
class zakatKambing extends zakat1 {
    int banyak;

    zakatKambing(int umur, int banyak) {
        this.umur = umur;
        this.banyak = banyak;
    }
    @Override
    int hitungZakat() {
        if (umur > 2 && banyak > 100) {
            return (banyak / 100);
        } else {
            return 0;
        }
    }
}

class zakatSapi extends zakat1 {
    int banyak;

    zakatSapi(int umur, int banyak) {
        this.umur = umur;
        this.banyak = banyak;
    }
    @Override
    int hitungZakat() {
        if (umur > 5 && banyak > 2) {
            return (banyak / 2);
        } else {
            return 0;
        }
    }
}


public class zakat {
    public static void main(String[] args) {
        zakat1 z1 = new zakatKambing(3, 250);
        zakat1 z2 = new zakatSapi(6, 10);

        System.out.println("Zakat Kambing: " + z1.hitungZakat() + " ekor");
        System.out.println("Zakat Sapi: " + z2.hitungZakat() + " ekor");

    }
}
