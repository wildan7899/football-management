package model;

import interfaces.Playable;
import interfaces.Trainable;

/**
 * Class Goalkeeper (Penjaga Gawang)
 * 
 * Konsep OOP yang diterapkan:
 * 1. INHERITANCE: Mewarisi atribut dan method dari abstract class Player (extends Player).
 * 2. INTERFACE IMPLEMENTATION: Mengimplementasikan kontrak dari Trainable dan Playable.
 * 3. METHOD OVERRIDING: Mengimplementasikan ulang method performRole(), train(), dan playMatch()
 *    sesuai karakteristik posisi penjaga gawang.
 */
public class Goalkeeper extends Player implements Trainable, Playable {

    /**
     * Constructor Goalkeeper yang meneruskan inisialisasi atribut ke constructor induk (super).
     *
     * @param name         Nama penjaga gawang
     * @param jerseyNumber Nomor punggung
     * @param age          Usia pemain
     */
    public Goalkeeper(String name, int jerseyNumber, int age) {
        super(name, jerseyNumber, age, "Goalkeeper");
    }

    /**
     * METHOD OVERRIDING terhadap abstract method performRole() milik class Player.
     */
    @Override
    public void performRole() {
        System.out.println("[Goalkeeper - #" + getJerseyNumber() + " " + getName() + "] "
                + "Menjaga gawang, menepis tembakan lawan (diving save), dan mengomandoi lini pertahanan.");
    }

    /**
     * METHOD OVERRIDING terhadap method train() dari interface Trainable.
     */
    @Override
    public void train() {
        System.out.println("[Latihan Goalkeeper] " + getName()
                + " berlatih refleks tangkapan bola, lompatan penyelamatan penalti, dan distribusi tendangan gawang.");
    }

    /**
     * METHOD OVERRIDING terhadap method playMatch() dari interface Playable.
     */
    @Override
    public void playMatch() {
        System.out.println("[Pertandingan - Goalkeeper] " + getName() + " (#" + getJerseyNumber() + ") "
                + "berdiri tangguh di bawah mistar gawang untuk mencatatkan clean sheet!");
    }
}
