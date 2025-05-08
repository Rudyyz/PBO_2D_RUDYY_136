package com.praktikum.users;
import com.praktikum.actions.*;
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
    public void displayAppMenu(Scanner scanner) {
        System.out.println("==== Informasi Pengguna ====");
        System.out.println("Username: " + username);

        boolean keluar = false;
        while (!keluar) {
            System.out.println("\n===== Menu Admin =====");
            System.out.println("1. Kelola Barang");
            System.out.println("2. Kelola Mahasiswa");
            System.out.println("0. Logout");
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
                    keluar = true;
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }
    }

    @Override
    public void manageitem(Scanner scanner) {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }

    @Override
    public void manageUser(Scanner scanner) {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
}