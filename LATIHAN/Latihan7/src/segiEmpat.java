public class segiEmpat extends shape{
    double panjang;
    double lebar;
    segiEmpat(double panjang, double lebar){
        this.panjang=panjang;
        this.lebar=lebar;
    }
    @Override
    public double luas() {
        return panjang * lebar;
    }
    public void hasil(){
        System.out.println("Luas Segit Empat dengan panjang "+panjang+" dan lebar "+lebar+": "+luas());
    }
}
