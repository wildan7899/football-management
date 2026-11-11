package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.Defender;
import model.Forward;
import model.Goalkeeper;
import model.Midfielder;
import model.Player;
import team.Team;

// Program utama dengan menu interaktif dan pembersih layar (CLS)
public class Main {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Team team = new Team("Real Madrid CF");
        loadDefaultPlayers(team);

        boolean running = true;
        while (running) {
            clearScreen();
            printMenu(team);
            int choice = readInt("Pilih menu [0-8]: ");

            clearScreen();
            switch (choice) {
                case 1:
                    team.displayAllPlayers();
                    pause();
                    break;
                case 2:
                    addPlayerMenu(team);
                    pause();
                    break;
                case 3:
                    editPlayerMenu(team);
                    pause();
                    break;
                case 4:
                    deletePlayerMenu(team);
                    pause();
                    break;
                case 5:
                    team.performAllRoles();
                    pause();
                    break;
                case 6:
                    team.runTrainingSession();
                    pause();
                    break;
                case 7:
                    matchMenu(team);
                    pause();
                    break;
                case 8:
                    changeTeamNameMenu(team);
                    pause();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan Football Team Management System!");
                    running = false;
                    break;
                default:
                    System.out.println("[!] Pilihan menu tidak valid.");
                    pause();
                    break;
            }
        }
    }

    // Membersihkan layar terminal
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("\n".repeat(30));
        }
    }

    // Menahan layar sampai pengguna menekan ENTER
    private static void pause() {
        System.out.print("\nTekan [ENTER] untuk kembali ke menu...");
        input.nextLine();
    }

    // Tampilan menu utama
    private static void printMenu(Team team) {
        System.out.println("+=======================================================+");
        System.out.println("|            FOOTBALL TEAM MANAGEMENT SYSTEM            |");
        System.out.println("+=======================================================+");
        System.out.printf("| Tim Aktif     : %-37s |%n", team.getTeamName());
        System.out.printf("| Jumlah Pemain : %-37s |%n", team.getPlayers().size() + " Orang");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("| [1] Lihat Daftar Skuad                                |");
        System.out.println("| [2] Tambah Pemain Baru                                |");
        System.out.println("| [3] Ubah Data Pemain                                  |");
        System.out.println("| [4] Hapus Pemain dari Skuad                           |");
        System.out.println("| [5] Lihat Peran Posisi Pemain                         |");
        System.out.println("| [6] Jalankan Sesi Latihan Tim                         |");
        System.out.println("| [7] Simulasi Pertandingan                             |");
        System.out.println("| [8] Ganti Nama Tim                                    |");
        System.out.println("| [0] Keluar Program                                    |");
        System.out.println("+=======================================================+");
    }

    // Menu untuk menambah pemain baru dari input pengguna
    private static void addPlayerMenu(Team team) {
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                  TAMBAH PEMAIN BARU                   |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("| Pilih Posisi Pemain:                                  |");
        System.out.println("|   1. Goalkeeper (Penjaga Gawang)                      |");
        System.out.println("|   2. Defender   (Pemain Bertahan)                     |");
        System.out.println("|   3. Midfielder (Gelandang)                           |");
        System.out.println("|   4. Forward    (Penyerang)                           |");
        System.out.println("+-------------------------------------------------------+");

        int posChoice = readInt("Pilih posisi [1-4]   : ");
        if (posChoice < 1 || posChoice > 4) {
            System.out.println("[!] Posisi tidak valid. Pembatalan tambah pemain.");
            return;
        }

        String name = readString("Nama Pemain          : ");
        int jersey = readInt("Nomor Punggung [1-99]: ");
        int age = readInt("Usia Pemain          : ");

        Player newPlayer;
        switch (posChoice) {
            case 1:
                newPlayer = new Goalkeeper(name, jersey, age);
                break;
            case 2:
                newPlayer = new Defender(name, jersey, age);
                break;
            case 3:
                newPlayer = new Midfielder(name, jersey, age);
                break;
            default:
                newPlayer = new Forward(name, jersey, age);
                break;
        }

        team.addPlayer(newPlayer);
        System.out.println("\n[+] Berhasil menambahkan " + newPlayer.getName()
                + " (#" + newPlayer.getJerseyNumber() + " - " + newPlayer.getPosition() + ") ke dalam tim!");
    }

    // Menu untuk mengubah data pemain menggunakan Setter (Encapsulation)
    private static void editPlayerMenu(Team team) {
        ArrayList<Player> list = team.getPlayers();
        if (list.isEmpty()) {
            System.out.println("[!] Belum ada pemain yang bisa diubah.");
            return;
        }

        printIndexedPlayers(list, "UBAH DATA PEMAIN");
        int idx = readInt("Pilih nomor urut pemain [1-" + list.size() + "]: ") - 1;
        if (idx < 0 || idx >= list.size()) {
            System.out.println("[!] Nomor urut tidak ditemukan.");
            return;
        }

        Player target = list.get(idx);
        System.out.println("\nData Saat Ini -> " + target.getName()
                + " | #" + target.getJerseyNumber() + " | " + target.getAge() + " thn");
        System.out.println("(Kosongkan nama atau isi 0 pada angka jika tidak ingin diubah)");

        System.out.print("Nama Baru            : ");
        String newName = input.nextLine().trim();
        if (!newName.isEmpty()) {
            target.setName(newName);
        }

        int newJersey = readInt("Nomor Punggung Baru  : ");
        if (newJersey > 0) {
            target.setJerseyNumber(newJersey);
        }

        int newAge = readInt("Usia Baru            : ");
        if (newAge > 0) {
            target.setAge(newAge);
        }

        System.out.println("\n[+] Data pemain berhasil diperbarui!");
    }

    // Menu untuk menghapus pemain dari skuad
    private static void deletePlayerMenu(Team team) {
        ArrayList<Player> list = team.getPlayers();
        if (list.isEmpty()) {
            System.out.println("[!] Skuad masih kosong.");
            return;
        }

        printIndexedPlayers(list, "HAPUS PEMAIN DARI SKUAD");
        int idx = readInt("Pilih nomor urut pemain yang akan dihapus [1-" + list.size() + "]: ") - 1;
        if (idx < 0 || idx >= list.size()) {
            System.out.println("[!] Nomor urut tidak valid.");
            return;
        }

        String removedName = list.get(idx).getName();
        team.removePlayer(idx);
        System.out.println("\n[-] Pemain " + removedName + " telah dihapus dari skuad.");
    }

    // Menu simulasi pertandingan dengan input nama lawan
    private static void matchMenu(Team team) {
        String opponent = readString("Masukkan nama tim lawan (kosongkan untuk default): ");
        System.out.println();
        if (opponent.isEmpty()) {
            team.simulateMatch();
        } else {
            team.simulateMatch(opponent);
        }
    }

    // Menu untuk mengganti nama tim
    private static void changeTeamNameMenu(Team team) {
        System.out.println("Nama tim saat ini: " + team.getTeamName());
        String newTeamName = readString("Masukkan nama tim baru: ");
        if (!newTeamName.isEmpty()) {
            team.setTeamName(newTeamName);
            System.out.println("\n[+] Nama tim berhasil diubah menjadi: " + team.getTeamName());
        } else {
            System.out.println("\n[!] Nama tim tidak boleh kosong.");
        }
    }

    // Menampilkan daftar pemain dengan nomor urut untuk dipilih
    private static void printIndexedPlayers(ArrayList<Player> list, String title) {
        System.out.println("+-----+------+------------------------+--------+--------------+");
        System.out.printf("| %-59s |%n", title);
        System.out.println("+-----+------+------------------------+--------+--------------+");
        System.out.println("| Idx | No.  | Nama Pemain            | Usia   | Posisi       |");
        System.out.println("+-----+------+------------------------+--------+--------------+");
        for (int i = 0; i < list.size(); i++) {
            Player p = list.get(i);
            System.out.printf("| %2d  | #%-3d | %-22s | %-2d thn | %-12s |%n",
                    (i + 1), p.getJerseyNumber(), p.getName(), p.getAge(), p.getPosition());
        }
        System.out.println("+-----+------+------------------------+--------+--------------+");
    }

    // Helper membaca input angka agar tidak error jika salah ketik huruf
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("[!] Harap masukkan angka yang valid.");
            }
        }
    }

    // Helper membaca input teks
    private static String readString(String prompt) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    // Data pemain awal agar program langsung siap dicoba
    private static void loadDefaultPlayers(Team team) {
        team.addPlayer(new Goalkeeper("Courtois", 1, 33));
        team.addPlayer(new Defender("Dean Huijsen", 4, 24));
        team.addPlayer(new Midfielder("Bernardo Silva", 20, 29));
        team.addPlayer(new Forward("Kylian Mbappe", 10, 27));
    }
}
