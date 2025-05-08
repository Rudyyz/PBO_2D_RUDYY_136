public class latihan2 {
    public static void main(String[] args) {
        for(int i=10;i >= 0; i--){
            System.out.println("indeks ke satu "+i);
        }

        System.out.println();

        for(int i=1; i<= 5; i++){
            int hasil = i * i;
            System.out.println(i+" * "+i+" = "+hasil);
        }

        System.out.println();

        for(int i=5; i >= 1; i--){
            for(int m=1; m<=i; m++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
