package com.praktikum.users;
import com.praktikum.actions.AdminActions;

import java.util.Scanner;


public class Admin extends User implements AdminActions {
    private String username;
    private String password;

    public Admin(String nama, long nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void displayAppMenu() {
        System.out.println("==== Informasi Pengguna ====");
        System.out.println("Username: " + username);
    }

    public void manageitem(Scanner scanner) {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }
    public void manageUser(Scanner scanner) {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }
}
