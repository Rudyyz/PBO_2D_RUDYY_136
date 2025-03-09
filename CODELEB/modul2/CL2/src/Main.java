//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Hewan{
    private String nama;
    private String jenis;
    private String suara;

    public Hewan(String nama, String jenis, String suara){
        this.nama =nama;
        this.jenis =jenis;
        this.suara =suara;
    }
    public void tampilkaninfo(){
        System.out.println("Nama: "+this.nama);
        System.out.println("Jenis: "+this.jenis);
        System.out.println("Suara: "+this.suara);
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        Hewan hewan1 = new Hewan("Kucing","Mamalia","Nyann~~");
        Hewan hewan2 = new Hewan("Anjing","Mamalia","Woof-Woof!!");

        hewan1.tampilkaninfo();
        hewan2.tampilkaninfo();

    }
}