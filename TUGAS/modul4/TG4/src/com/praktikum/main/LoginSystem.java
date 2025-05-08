package com.praktikum.main;
import java.util.ArrayList;
import java.util.Scanner;
import com.praktikum.users.*;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Admin> daftarAdmin = new ArrayList<>();
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        daftarAdmin.add(new Admin("Admin Satu", "123456", "admin", "admin123"));
        daftarMahasiswa.add(new Mahasiswa("M. Rudi Mustakim", "202410370110136"));
        daftarMahasiswa.add(new Mahasiswa("Masdar helmi", "202410370110133"));

        boolean loginSukses = false;

        while (!loginSukses) {
            System.out.println("\n===== Pilih jenis login =====");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.print("Pilih opsi Anda (1/2): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();

                    for (Admin admin : daftarAdmin) {
                        if (admin.login(username, password)) {
                            System.out.println("Login Admin Berhasil!");
                            admin.displayAppMenu(scanner);
                            loginSukses = true;
                            break;
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

                    for (Mahasiswa mahasiswa : daftarMahasiswa) {
                        if (mahasiswa.login(namaMahasiswa, nimMahasiswa)) {
                            System.out.println("Login Mahasiswa Berhasil!");
                            mahasiswa.displayAppMenu(scanner);
                            loginSukses = true;
                            break;
                        }
                    }

                    if (!loginSukses) {
                        System.out.println("Login gagal! Nama atau NIM salah.");
                    }
                    break;

                default:
                    System.out.println("Input tidak valid!");
                    break;
            }
        }

        scanner.close();
    }
}