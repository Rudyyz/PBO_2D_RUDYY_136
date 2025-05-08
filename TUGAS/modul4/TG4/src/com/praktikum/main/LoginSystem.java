package com.praktikum.main;

import java.util.ArrayList;
import java.util.Scanner;
import com.praktikum.users.*;
import com.praktikum.actions.*;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Admin> daftarAdmin = new ArrayList<>();
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

        daftarAdmin.add(new Admin("Admin Satu", 123456L, "admin", "admin123"));
        daftarMahasiswa.add(new Mahasiswa("M. Rudi Mustakim", 202410370110136L));
        daftarMahasiswa.add(new Mahasiswa("Masdar helmi", 202410370110133L));

        boolean loginSukses = false;

        while (!loginSukses) {
            System.out.println("\nPilih jenis login:");
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
                            admin.displayAppMenu();
                            loginSukses = true;

                            boolean keluar = false;
                            while (!keluar) {
                                System.out.println("\nMenu Admin:");
                                System.out.println("1. Kelola Barang");
                                System.out.println("2. Kelola Mahasiswa");
                                System.out.println("0. Logout");
                                System.out.print("Pilih opsi: ");
                                int opsi = scanner.nextInt();
                                scanner.nextLine();

                                switch (opsi) {
                                    case 1:
                                        admin.manageitem(scanner);
                                        break;
                                    case 2:
                                        admin.manageUser(scanner);
                                        break;
                                    case 0:
                                        keluar = true;
                                        break;
                                    default:
                                        System.out.println("Opsi tidak valid.");
                                }
                            }
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
                    long nimMahasiswa = scanner.nextLong();
                    scanner.nextLine();

                    for (Mahasiswa mahasiswa : daftarMahasiswa) {
                        if (mahasiswa.login(namaMahasiswa, nimMahasiswa)) {
                            System.out.println("Login Mahasiswa Berhasil!");
                            mahasiswa.displayAppMenu();
                            loginSukses = true;

                            boolean keluar = false;
                            while (!keluar) {
                                System.out.println("\nMenu Mahasiswa:");
                                System.out.println("1. Lapor Barang");
                                System.out.println("2. Lihat Daftar Laporan");
                                System.out.println("0. Logout");
                                System.out.print("Pilih opsi: ");
                                int opsi = scanner.nextInt();
                                scanner.nextLine();

                                switch (opsi) {
                                    case 1:
                                        mahasiswa.reportItem(scanner);
                                        break;
                                    case 2:
                                        mahasiswa.viewReportItems(scanner);
                                        break;
                                    case 0:
                                        keluar = true;
                                        break;
                                    default:
                                        System.out.println("Opsi tidak valid.");
                                }
                            }
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
