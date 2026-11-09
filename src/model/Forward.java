package model;

import interfaces.Playable;
import interfaces.Trainable;

/**
 * Class Forward (Pemain Depan / Penyerang)
 * 
 * Konsep OOP yang diterapkan:
 * 1. INHERITANCE: Mewarisi atribut dan method dari abstract class Player (extends Player).
 * 2. INTERFACE IMPLEMENTATION: Mengimplementasikan kontrak dari Trainable dan Playable.
 * 3. METHOD OVERRIDING: Mengimplementasikan ulang method performRole(), train(), dan playMatch()
 *    sesuai karakteristik posisi penyerang pencetak gol.
 */
public class Forward extends Player implements Trainable, Playable {

    /**
     * Constructor Forward yang meneruskan inisialisasi atribut ke constructor induk (super).
     *
     * @param name         Nama pemain penyerang
     * @param jerseyNumber Nomor punggung
     * @param age          Usia pemain
     */
    public Forward(String name, int jerseyNumber, int age) {
        super(name, jerseyNumber, age, "Forward");
    }

    /**
     * METHOD OVERRIDING terhadap abstract method performRole() milik class Player.
     */
    @Override
    public void performRole() {
        System.out.println("[Forward    - #" + getJerseyNumber() + " " + getName() + "] "
                + "Mencari ruang kosong di pertahanan lawan, melakukan penyelesaian akhir (finishing), dan mencetak gol.");
    }

    /**
     * METHOD OVERRIDING terhadap method train() dari interface Trainable.
     */
    @Override
    public void train() {
        System.out.println("[Latihan Forward]    " + getName()
                + " berlatih ketajaman tembakan ke gawang (shooting), akselerasi sprint, dan variasi penyelesaian akhir.");
    }

    /**
     * METHOD OVERRIDING terhadap method playMatch() dari interface Playable.
     */
    @Override
    public void playMatch() {
        System.out.println("[Pertandingan - Forward]    " + getName() + " (#" + getJerseyNumber() + ") "
                + "melakukan penetrasi ke kotak penalti lawan dan melepaskan tembakan keras ke gawang!");
    }
}
