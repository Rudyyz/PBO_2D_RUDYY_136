public class lingkaran extends shape{
    double jarijari;

    lingkaran (double jarijari){
        this.jarijari=jarijari;
    }
    @Override
    public double luas() {
        return 3.14 * jarijari * jarijari;
    }
    public void hasil(){
        System.out.println("Luas lingkaran dengan Jari-jari "+jarijari+": "+luas());
    }
}
