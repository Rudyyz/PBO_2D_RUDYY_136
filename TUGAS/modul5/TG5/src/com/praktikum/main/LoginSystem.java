package com.praktikum.main;
import java.util.ArrayList;
import java.util.Scanner;
import com.praktikum.users.*;
import com.praktikum.data.*;

public class LoginSystem {

    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        userList.add(new Admin("Admin1","123456","Admin","Admin123"));
        userList.add(new Mahasiswa("M. Rudi Mustakim","202410370110136"));
        userList.add(new Mahasiswa("Masdar helmi","202410370110133"));

        boolean loginSukses = false;

        while (!loginSukses) {
            System.out.println("\n==---== Pilih jenis login ==---==");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("0. log out");

            try {
                System.out.print("Pilih opsi Anda (1/2/0): ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan username: ");
                        String username = scanner.nextLine();
                        System.out.print("Masukkan password: ");
                        String password = scanner.nextLine();

                        for (User user : userList) {
                            if (user instanceof Admin) {
                                Admin admin = (Admin) user;
                                if (admin.login(username, password)) {
                                    System.out.println("Login Admin berhasil!!");
                                    boolean kembali = admin.displayAppMenu(scanner);
                                    if(kembali){
                                        continue;
                                    }else{
                                        return;
                                    }
                                }
                            }
                        }

                        if (!loginSukses) {
                            System.out.println("Login gagal! Username atau password salah.");
                        }
                        break;

                    case 2:
                        System.out.print("Masukkan Nama: ");
                        String namaMahasiswa = scanner.nextLine();
                        System.out.print("Masukkan NIM: ");
                        String nimMahasiswa = scanner.nextLine();

                        for (User user : userList) {
                            if (user instanceof Mahasiswa) {
                                Mahasiswa mahasiswa = (Mahasiswa) user;
                                if (mahasiswa.login(namaMahasiswa, nimMahasiswa)) {
                                    System.out.println("Login Admin berhasil!!");
                                    boolean kembali = mahasiswa.displayAppMenu(scanner);
                                    if(kembali){
                                        continue;
                                    }else{
                                        return;
                                    }
                                }
                            }
                        }

                        if (!loginSukses) {
                            System.out.println("Login gagal! Nama atau NIM salah.");
                        }
                        break;

                    case 0:
                        System.out.println("Keluar dari program. Terima kasih!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Input tidak valid!");
                }
            }catch (java.util.InputMismatchException e){
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}