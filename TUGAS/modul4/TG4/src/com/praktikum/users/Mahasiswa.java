package com.praktikum.users;
import com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;
import java.util.ArrayList;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String nama, long nim) {
        super(nama, nim);
    }

    public boolean login(String nama, long nim) {
        return this.nama.equalsIgnoreCase(nama) && this.nim == nim;
    }

    @Override
    public void displayAppMenu() {
        System.out.println("==== Informasi Pengguna ====");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }

    public void reportItem(Scanner scanner) {
        System.out.print("Masukkan nama barang yang ingin dilaporkan: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Masukkan deskripsi barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi terakir ditemukan: ");
        String lokasi = scanner.nextLine();

        System.out.println(nama + " telah melaporkan barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Lokasi terakir: "+lokasi);
    }

    public void viewReportItems(Scanner scanner) {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }
}
