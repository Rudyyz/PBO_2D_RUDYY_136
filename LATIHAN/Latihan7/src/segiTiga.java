public class segiTiga extends shape{
    double alas;
    double tinggi;

    segiTiga(double alas, double tinggi){
        this.alas=alas;
        this.tinggi=tinggi;
    }
    @Override
    public double luas() {
        return 0.5 * alas * tinggi;
    }
    public void hasil(){
        System.out.println("Luas Segit Tiga dengan alas "+alas+" dan tinggi "+tinggi+": "+luas());
    }
}
