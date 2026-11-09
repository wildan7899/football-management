package model;

import interfaces.Playable;
import interfaces.Trainable;

/**
 * Class Midfielder (Pemain Tengah / Gelandang)
 * 
 * Konsep OOP yang diterapkan:
 * 1. INHERITANCE: Mewarisi atribut dan method dari abstract class Player (extends Player).
 * 2. INTERFACE IMPLEMENTATION: Mengimplementasikan kontrak dari Trainable dan Playable.
 * 3. METHOD OVERRIDING: Mengimplementasikan ulang method performRole(), train(), dan playMatch()
 *    sesuai karakteristik posisi gelandang pengatur serangan.
 */
public class Midfielder extends Player implements Trainable, Playable {

    /**
     * Constructor Midfielder yang meneruskan inisialisasi atribut ke constructor induk (super).
     *
     * @param name         Nama pemain gelandang
     * @param jerseyNumber Nomor punggung
     * @param age          Usia pemain
     */
    public Midfielder(String name, int jerseyNumber, int age) {
        super(name, jerseyNumber, age, "Midfielder");
    }

    /**
     * METHOD OVERRIDING terhadap abstract method performRole() milik class Player.
     */
    @Override
    public void performRole() {
        System.out.println("[Midfielder - #" + getJerseyNumber() + " " + getName() + "] "
                + "Mengatur tempo permainan, mengalirkan umpan terobosan (through pass), dan menghubungkan antar lini.");
    }

    /**
     * METHOD OVERRIDING terhadap method train() dari interface Trainable.
     */
    @Override
    public void train() {
        System.out.println("[Latihan Midfielder] " + getName()
                + " berlatih akurasi umpan jarak jauh, visi bermain, kontrol bola (dribbling), dan daya tahan stamina.");
    }

    /**
     * METHOD OVERRIDING terhadap method playMatch() dari interface Playable.
     */
    @Override
    public void playMatch() {
        System.out.println("[Pertandingan - Midfielder] " + getName() + " (#" + getJerseyNumber() + ") "
                + "mendominasi lini tengah dan menciptakan peluang emas bagi penyerang!");
    }
}
