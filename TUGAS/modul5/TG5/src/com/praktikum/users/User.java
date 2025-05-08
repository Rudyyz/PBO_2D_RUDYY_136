package com.praktikum.users;

import java.util.Scanner;

public abstract class User {
    protected String nama;
    protected String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }
    public String getNim() {
        return nim;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }
    public abstract boolean login(String input1, String input2);
    public abstract boolean displayAppMenu(Scanner scanner);
}
