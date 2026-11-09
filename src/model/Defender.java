package model;

import interfaces.Playable;
import interfaces.Trainable;

/**
 * Class Defender (Pemain Bertahan / Bek)
 * 
 * Konsep OOP yang diterapkan:
 * 1. INHERITANCE: Mewarisi atribut dan method dari abstract class Player (extends Player).
 * 2. INTERFACE IMPLEMENTATION: Mengimplementasikan kontrak dari Trainable dan Playable.
 * 3. METHOD OVERRIDING: Mengimplementasikan ulang method performRole(), train(), dan playMatch()
 *    sesuai karakteristik posisi bek pertahanan.
 */
public class Defender extends Player implements Trainable, Playable {

    /**
     * Constructor Defender yang meneruskan inisialisasi atribut ke constructor induk (super).
     *
     * @param name         Nama pemain bertahan
     * @param jerseyNumber Nomor punggung
     * @param age          Usia pemain
     */
    public Defender(String name, int jerseyNumber, int age) {
        super(name, jerseyNumber, age, "Defender");
    }

    /**
     * METHOD OVERRIDING terhadap abstract method performRole() milik class Player.
     */
    @Override
    public void performRole() {
        System.out.println("[Defender   - #" + getJerseyNumber() + " " + getName() + "] "
                + "Mengawal penyerang lawan, melakukan tekel bersih (tackling), dan memotong alur serangan (intercept).");
    }

    /**
     * METHOD OVERRIDING terhadap method train() dari interface Trainable.
     */
    @Override
    public void train() {
        System.out.println("[Latihan Defender]   " + getName()
                + " berlatih duel udara, kekuatan fisik, posisi jebakan offside, dan ketepatan tekel.");
    }

    /**
     * METHOD OVERRIDING terhadap method playMatch() dari interface Playable.
     */
    @Override
    public void playMatch() {
        System.out.println("[Pertandingan - Defender]   " + getName() + " (#" + getJerseyNumber() + ") "
                + "menjaga rapat area kotak penalti dan memblokir tembakan berbahaya lawan!");
    }
}
