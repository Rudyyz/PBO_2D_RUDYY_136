import java.util.Date;

public class Main {
    public static void main(String [] args){
        Farmer farmer1 = new Farmer();
        Farmer farmer2 = new Farmer();
        Plant plant1 = new Plant();
        Plant plant2 = new Plant();

        farmer1.nama ="Cruse dave";
        farmer2.nama ="Suber dave";

        plant1.nama ="Sunflower";
        plant2.nama ="Musroom";

        farmer1.favorite = plant1.nama;
        farmer2.favorite = plant2.nama;

        System.out.println("Helo World!");
        System.out.println("Tanggal dan waktu:"+new Date());

        farmer1.talk();
        farmer2.talk();
    }
}
