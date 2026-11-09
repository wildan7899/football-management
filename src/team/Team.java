package team;

import java.util.ArrayList;
import model.Player;

/**
 * Class Team
 * 
 * Konsep OOP yang diterapkan:
 * 1. ENCAPSULATION: Atribut teamName dan daftar players bersifat private, diakses melalui method publik.
 * 2. AGGREGATION / HAS-A RELATIONSHIP: Objek Team memiliki daftar objek Player (ArrayList<Player>).
 * 3. RUNTIME POLYMORPHISM: Menyimpan berbagai subclass (Goalkeeper, Defender, Midfielder, Forward)
 *    ke dalam satu koleksi bertipe induk ArrayList<Player> dan memanggil method yang di-override
 *    secara dinamis saat runtime.
 */
public class Team {

    // ENCAPSULATION: Atribut private
    private String teamName;
    private ArrayList<Player> players;

    /**
     * Constructor untuk membuat objek tim baru dan menginisialisasi koleksi pemain.
     *
     * @param teamName Nama tim sepak bola
     */
    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
    }

    // Getter dan Setter
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        if (teamName != null && !teamName.trim().isEmpty()) {
            this.teamName = teamName;
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Menambahkan objek pemain (subclass apa pun dari Player) ke dalam daftar tim.
     *
     * @param player Objek pemain yang akan ditambahkan
     */
    public void addPlayer(Player player) {
        if (player != null) {
            players.add(player);
            System.out.println("[+] Pemain berhasil ditambahkan ke " + teamName + ": "
                    + player.getName() + " (#" + player.getJerseyNumber() + " - " + player.getPosition() + ")");
        }
    }

    /**
     * Menampilkan informasi seluruh pemain yang terdaftar di dalam tim.
     */
    public void displayAllPlayers() {
        System.out.println("\n======================================================================");
        System.out.println(" DAFTAR SKUAD TIM: " + teamName.toUpperCase() + " (" + players.size() + " Pemain)");
        System.out.println("======================================================================");
        if (players.isEmpty()) {
            System.out.println("Belum ada pemain di dalam tim.");
            return;
        }
        for (Player player : players) {
            player.displayInfo();
        }
        System.out.println("======================================================================");
    }

    /**
     * POLYMORPHISM:
     * Melakukan iterasi pada ArrayList<Player> dan memanggil performRole().
     * Meskipun dipanggil melalui referensi bertipe Player, JVM secara dinamis (runtime)
     * mengeksekusi implementasi performRole() sesuai class asli masing-masing objek.
     */
    public void performAllRoles() {
        System.out.println("\n======================================================================");
        System.out.println(" DEMONSTRASI POLYMORPHISM: PERAN SETIAP PEMAIN DI LAPANGAN");
        System.out.println("======================================================================");
        for (Player player : players) {
            // Pemanggilan polimorfik: satu tipe referensi (Player), banyak perilaku berbeda
            player.performRole();
        }
    }

    /**
     * Menjalankan simulasi sesi latihan untuk seluruh pemain menggunakan method train()
     * dari interface Trainable.
     */
    public void runTrainingSession() {
        System.out.println("\n======================================================================");
        System.out.println(" SIMULASI SESI LATIHAN TIM: " + teamName.toUpperCase());
        System.out.println("======================================================================");
        for (Player player : players) {
            player.train();
        }
    }

    /**
     * Menjalankan simulasi pertandingan sepak bola melawan tim lawan.
     *
     * @param opponentTeam Nama tim lawan
     */
    public void simulateMatch(String opponentTeam) {
        System.out.println("\n======================================================================");
        System.out.println(" SIMULASI PERTANDINGAN: " + teamName.toUpperCase() + " vs " + opponentTeam.toUpperCase());
        System.out.println("======================================================================");
        System.out.println(">>> Kick-Off Babak Pertama dimulai!\n");

        System.out.println("--- [Aksi Bertanding Setiap Pemain (Interface Playable)] ---");
        for (Player player : players) {
            player.playMatch();
        }

        System.out.println("\n--- [Koordinasi Taktik & Peran Posisi (Polymorphism performRole)] ---");
        for (Player player : players) {
            player.performRole();
        }

        System.out.println("\n>>> Peluit Panjang Berbunyi! Pertandingan " + teamName + " vs " + opponentTeam
                + " selesai dengan kerja sama tim yang solid!");
        System.out.println("======================================================================");
    }

    /**
     * Overloading method simulateMatch() tanpa parameter.
     */
    public void simulateMatch() {
        simulateMatch("Elang Nusantara FC");
    }
}
