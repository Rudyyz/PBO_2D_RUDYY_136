package com.example.app;

import com.example.perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        NonFiksi buku1 = new NonFiksi("Manusia Indonesia", "Mochtar Lubis", "Psikologi Sosial");
        Fiksi buku2 = new Fiksi("Laskar Pelangi", "Andrea Hirata", "fiksi realis inspiratif");

        buku1.displayInfo();
        buku2.displayInfo();

        System.out.println();

        anggota anggota1 = new anggota("M. Rudi Mustakim", "D136");
        anggota anggota2 = new anggota("Avina Pinky Firu Ananda", "D141");

        anggota1.displayInfo();
        anggota2.displayInfo();

        System.out.println();

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);

        System.out.println();

        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");
    }
}

