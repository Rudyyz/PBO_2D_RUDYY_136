package com.praktikum.users;
import com.praktikum.actions.*;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String input1, String input2) {
        return this.nama.equalsIgnoreCase(input1) && this.nim.equals(input2);
    }

    @Override
    public void displayAppMenu(Scanner scanner) {
        System.out.println("===== Informasi Pengguna =====");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);

        boolean keluar = false;
        while (!keluar) {
            System.out.println("\n===== Menu Mahasiswa =====");
            System.out.println("1. Lapor Barang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih opsi: ");
            int opsi = scanner.nextInt();
            scanner.nextLine();

            switch (opsi) {
                case 1:
                    reportItem(scanner);
                    break;
                case 2:
                    viewReportItems(scanner);
                    break;
                case 0:
                    keluar = true;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }

    @Override
    public void reportItem(Scanner scanner) {
        System.out.print("Masukkan nama barang yang ingin dilaporkan: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Masukkan deskripsi barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi terakhir ditemukan: ");
        String lokasi = scanner.nextLine();
        System.out.println();

        System.out.println("===== Barang Berhasil di Laporkan =====");
        System.out.println(nama + " telah melaporkan barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Lokasi terakhir: " + lokasi);
    }

    @Override
    public void viewReportItems(Scanner scanner) {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }
}