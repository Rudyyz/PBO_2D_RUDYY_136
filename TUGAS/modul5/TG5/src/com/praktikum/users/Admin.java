package com.praktikum.users;
import com.praktikum.actions.*;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.*;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public boolean displayAppMenu(Scanner scanner) {
        System.out.println("==== Informasi Pengguna ====");
        System.out.println("Username: " + username);

        while (true) {
            System.out.println("\n===== Menu Admin =====");
            System.out.println("1. Kelola Barang");
            System.out.println("2. Kelola Mahasiswa");
            System.out.println("0. Kembali");

            try {
                System.out.print("Pilih opsi: ");
                int opsi = scanner.nextInt();
                scanner.nextLine();

                switch (opsi) {
                    case 1:
                        manageitem(scanner);
                        break;
                    case 2:
                        manageUser(scanner);
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
    public void manageitem(Scanner scanner) {
        boolean kembali = false;

        while (!kembali) {
            System.out.println("\n==== Kelola Barang ====");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil (Claimed)");
            System.out.println("0. Kembali");
            System.out.print("Pilih opsi: ");
            int opsi = scanner.nextInt();
            scanner.nextLine();

            switch (opsi) {
                case 1:
                    lihatSemuaLaporan();
                    break;
                case 2:
                    tandaiBarangTelahDiambil(scanner);
                    break;
                case 0:
                    kembali = true;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }


    private void lihatSemuaLaporan() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.println("==== Semua Laporan Barang ====");
        for (item barang : LoginSystem.reportedItems) {
            System.out.println("Nama Barang : " + barang.getItemNama());
            System.out.println("Lokasi Barang : " + barang.getLocation());
            System.out.println("Status : " + barang.getStatus());
            System.out.println();
        }
    }


    private void tandaiBarangTelahDiambil(Scanner scanner) {
        int count = 0;
        for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
            item barang = LoginSystem.reportedItems.get(i);
            if (barang.getStatus().equalsIgnoreCase("Reported")) {
                System.out.println(i + ". " + barang.getItemNama() + " | Lokasi: " + barang.getLocation());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Tidak ada barang dengan status Reported.");
            return;
        }

        System.out.print("Masukkan indeks barang yang ingin ditandai sebagai Claimed: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();

            item barangDipilih = LoginSystem.reportedItems.get(index);
            if (!barangDipilih.getStatus().equalsIgnoreCase("Reported")) {
                System.out.println("Barang ini sudah ditandai sebagai Claimed.");
            } else {
                barangDipilih.setStatus("Claimed");
                System.out.println("Barang berhasil ditandai sebagai Claimed!");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeks tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Input tidak valid.");
            scanner.nextLine();
        }
    }


    @Override
    public void manageUser(Scanner scanner) {
        boolean kembali = false;

        while (!kembali) {
            System.out.println("\n==== Kelola Mahasiswa ====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");

            try {
                System.out.print("Pilih opsi: ");
                int opsi = scanner.nextInt();
                scanner.nextLine();

                switch (opsi) {
                    case 1:
                        tambahMahasiswa(scanner);
                        break;
                    case 2:
                        hapusMahasiswa(scanner);
                        break;
                    case 0:
                        kembali = true;
                        break;
                    default:
                        System.out.println("Opsi tidak valid.");
                }
            }catch (java.util.InputMismatchException e){
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
    }

    private void tambahMahasiswa(Scanner scanner) {
        System.out.print("Masukkan nama Mahasiswa: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();

        Mahasiswa mhsBaru = new Mahasiswa(nama, nim);
        LoginSystem.userList.add(mhsBaru);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    private void hapusMahasiswa(Scanner scanner) {
        System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
        String nimHapus = scanner.nextLine();

        boolean ditemukan = false;
        for (int i = 0; i < LoginSystem.userList.size(); i++) {
            User user = LoginSystem.userList.get(i);
            if (user instanceof Mahasiswa && user.getNim().equals(nimHapus)) {
                LoginSystem.userList.remove(i);
                System.out.println("Mahasiswa berhasil dihapus.");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }
}