package team;

import java.util.ArrayList;
import model.Player;

// Class untuk mengelola data tim dan daftar pemain
public class Team {

    private String teamName;
    private ArrayList<Player> players;

    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        if (teamName != null && !teamName.trim().isEmpty()) {
            this.teamName = teamName.trim();
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        if (player != null) {
            players.add(player);
        }
    }

    public boolean removePlayer(int index) {
        if (index >= 0 && index < players.size()) {
            players.remove(index);
            return true;
        }
        return false;
    }

    // Menampilkan tabel daftar pemain di dalam tim
    public void displayAllPlayers() {
        System.out.println("+------+------------------------+--------+--------------+");
        System.out.printf("| %-53s |%n", "SKUAD TIM: " + teamName.toUpperCase() + " (" + players.size() + " Pemain)");
        System.out.println("+------+------------------------+--------+--------------+");
        System.out.println("| No.  | Nama Pemain            | Usia   | Posisi       |");
        System.out.println("+------+------------------------+--------+--------------+");

        if (players.isEmpty()) {
            System.out.println("|          Belum ada pemain di dalam tim ini.           |");
        } else {
            for (Player player : players) {
                player.displayInfo();
            }
        }
        System.out.println("+------+------------------------+--------+--------------+");
    }

    // Menjalankan peran setiap pemain (Polymorphism)
    public void performAllRoles() {
        System.out.println("=========================================================================");
        System.out.println(" PERAN PEMAIN DI LAPANGAN - " + teamName.toUpperCase());
        System.out.println("=========================================================================");
        if (players.isEmpty()) {
            System.out.println(" Belum ada pemain untuk ditampilkan.");
            return;
        }
        for (Player player : players) {
            player.performRole();
        }
        System.out.println("=========================================================================");
    }

    // Menjalankan latihan untuk semua pemain (Interface Trainable)
    public void runTrainingSession() {
        System.out.println("=========================================================================");
        System.out.println(" SESI LATIHAN TIM - " + teamName.toUpperCase());
        System.out.println("=========================================================================");
        if (players.isEmpty()) {
            System.out.println(" Belum ada pemain untuk mengikuti latihan.");
            return;
        }
        for (Player player : players) {
            player.train();
        }
        System.out.println("=========================================================================");
    }

    // Simulasi pertandingan melawan tim lawan (Interface Playable & Polymorphism)
    public void simulateMatch(String opponentTeam) {
        System.out.println("=========================================================================");
        System.out.println(" PERTANDINGAN: " + teamName.toUpperCase() + " vs " + opponentTeam.toUpperCase());
        System.out.println("=========================================================================");
        if (players.isEmpty()) {
            System.out.println(" Pertandingan dibatalkan karena belum ada pemain di dalam skuad!");
            return;
        }

        System.out.println("\n[Babak 1 - Aksi Pertandingan]");
        for (Player player : players) {
            player.playMatch();
        }

        System.out.println("\n[Babak 2 - Koordinasi Peran Posisi]");
        for (Player player : players) {
            player.performRole();
        }

        System.out.println("\n>>> Peluit panjang berbunyi! Laga melawan " + opponentTeam + " selesai.");
        System.out.println("=========================================================================");
    }

    public void simulateMatch() {
        simulateMatch("Elang Nusantara FC");
    }
}
