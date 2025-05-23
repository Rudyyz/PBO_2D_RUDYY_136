package com.praktikum.users;
import com.praktikum.actions.*;
import java.util.Scanner;
import com.praktikum.data.*;
import com.praktikum.main.LoginSystem;

public class Mahasiswa extends User implements MahasiswaActions {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String input1, String input2) {
        return this.nama.equalsIgnoreCase(input1) && this.nim.equals(input2);
    }

    @Override
    public boolean displayAppMenu(Scanner scanner) {
        System.out.println("=====> Informasi Pengguna <=====");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);

        while (true) {
            System.out.println("\n==---== Menu Mahasiswa ==---==");
            System.out.println("1. Lapor Barang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Kembali");

            try {
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
                        return true;
                    default:
                        System.out.println("Opsi tidak valid.");
                }
            }catch (java.util.InputMismatchException e){
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
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

        item barang = new item(namaBarang,deskripsi,"Reported");
        LoginSystem.reportedItems.add(barang);

        System.out.println();

        System.out.println("==---== Barang Berhasil di Laporkan ==---==");
        System.out.println(nama + " telah melaporkan barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Lokasi terakhir: " + lokasi);
    }

    @Override
    public void viewReportItems(Scanner scanner) {
        if(LoginSystem.reportedItems.isEmpty()){
            System.out.println("Belum ada laporan barang.");
        }else{
            System.out.println("==---== daftar barang yang Dilaporkan ==---== ");
            for(item barang : LoginSystem .reportedItems){
                if(barang.getStatus().equals("Reported")){
                    System.out.println("Nama barang : "+barang.getItemNama());
                    System.out.println("Lokasi : "+barang.getLocation());
                    System.out.println("Status : "+barang.getStatus());
                    System.out.println();
                }
            }
        }
    }
}