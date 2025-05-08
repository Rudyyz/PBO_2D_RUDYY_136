package com.praktikum.users;

public abstract class User {
    protected String nama;
    protected long nim;

    public User(String nama, long nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }
    public long getNim() {
        return nim;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setNim(long nim) {
        this.nim = nim;
    }

    public abstract void displayAppMenu();
}
