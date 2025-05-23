package com.latihan;
import java.util.Collections;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

class NegatifNumberException extends Exception{
    public NegatifNumberException(String messeage){
        super(messeage);
    }
}
class DeretInteger {
    private int[] deret;
    private int jumlah;

    public DeretInteger(int jumlah) {
        this.jumlah = jumlah;
        deret = new int[jumlah];
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < jumlah; i++) {
            while (true) {
                try {
                    System.out.print("Masukan elemen ke-" + (i + 1) + ": ");
                    int nilai = scanner.nextInt();
                    if (nilai < 0) {
                        throw new NegatifNumberException("Bilangan Megatif Tidak Boleh!!");
                    }
                    if (nilai == 0) {
                        throw new ArithmeticException("Bilangan 0 Tidak diperbolehkan!!");
                    }
                    deret[i] = nilai;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Inputan Bukan Bilangan Bulat.");
                    scanner.next();
                } catch (NegatifNumberException | ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
    public void sortAscending() {
        try {
            if (deret.length == 0) throw new Exception("Array kosong!");
            Arrays.sort(deret);
            System.out.println("Deret ascending: " + Arrays.toString(deret));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void sortDescending() {
        try {
            if (deret.length == 0) throw new Exception("Array kosong!");
            Integer[] temp = Arrays.stream(deret).boxed().toArray(Integer[]::new);
            Arrays.sort(temp, Collections.reverseOrder());
            System.out.println("Deret descending: " + Arrays.toString(temp));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void findMaxMin() {
        try {
            if (deret.length == 0) throw new Exception("Array kosong!");
            int max = deret[0];
            int min = deret[0];
            for (int n : deret) {
                if (n > max) max = n;
                if (n < min) min = n;
            }
            System.out.println("Nilai Maksimum: " + max);
            System.out.println("Nilai Minimum: " + min);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}


public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah elemen deret: ");
        int jumlah = scanner.nextInt();

        DeretInteger deret = new DeretInteger(jumlah);
        deret.input();

        int pilihan;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan deret ascending");
            System.out.println("2. Tampilkan deret descending");
            System.out.println("3. Tampilkan nilai maksimum dan minimum");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    deret.sortAscending();
                    break;
                case 2:
                    deret.sortDescending();
                    break;
                case 3:
                    deret.findMaxMin();
                    break;
                case 4:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 4);
    }
}
