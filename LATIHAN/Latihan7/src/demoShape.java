abstract class shape{
   public abstract double luas();
   public abstract void hasil();
}

public class demoShape {
    public static void main(String[] args) {
        segiEmpat segiEmpat1 = new segiEmpat(4,5);
        segiTiga segiTiga1 = new segiTiga(3,7);
        lingkaran lingkaran1 = new lingkaran(7);

        segiEmpat1.hasil();
        segiTiga1.hasil();
        lingkaran1.hasil();
    }
}