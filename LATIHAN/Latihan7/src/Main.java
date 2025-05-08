abstract class staf
{
    public int masa_kerja;
    abstract void bayarGaji();
}

class programmer extends staf {
    programmer (int masa_kerja){
        this.masa_kerja=masa_kerja;
    }
    void bayarGaji(){
        if(masa_kerja < 2){
            System.out.println("Gaji programer : 2 juta");
        }else{
            System.out.println("Gaji programer : 4 juta");
        }
    }
}

class sistemAnalis extends staf {
    sistemAnalis (int masa_kerja){
        this.masa_kerja=masa_kerja;
    }
    void bayarGaji(){
        if(masa_kerja < 2){
            System.out.println("Gaji programer : 2 juta");
        }else{
            System.out.println("Gaji programer : 4 juta");
        }
    }
}

public class Main{
    public static void main(String[] args) {
        programmer p = new programmer(1);
        sistemAnalis s = new sistemAnalis(3);

        p.bayarGaji();
        s.bayarGaji();
    }
}
