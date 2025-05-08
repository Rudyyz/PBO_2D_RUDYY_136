import java.util.Arrays;

public class latihan {
    public static void main(String[] args) {
        int[] arr ={10,20,30,40,50,};

        System.out.println("satu");
        for(int i=0; i < 5; i++){
            System.out.println("index ke "+i+ "adalah : "+arr[i]);
        }

        System.out.println("dua");
        for(int i=0; i<arr.length;i++){
            System.out.println("index ke "+i+ "adalah : "+arr[i]);
        }

        System.out.println("tiga");
        for(int a : arr){
            System.out.println("index ke "+a+ "adalah : "+a);
        }
    }
}
