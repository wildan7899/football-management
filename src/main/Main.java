package main;

import interfaces.Playable;
import interfaces.Trainable;
import java.util.ArrayList;
import model.Defender;
import model.Forward;
import model.Goalkeeper;
import model.Midfielder;
import model.Player;
import team.Team;

/**
 * Class Main (Program Utama)
 * 
 * Mendemonstrasikan keseluruhan konsep Pemrograman Berorientasi Objek (PBO):
 * 1. Inheritance (Pewarisan)
 * 2. Abstract Class (Class Abstrak)
 * 3. Abstract Method (Method Abstrak)
 * 4. Interface (Kontrak Perilaku)
 * 5. Polymorphism (Polimorfisme Runtime menggunakan ArrayList<Player>)
 * 6. Method Overriding (Implementasi Spesifik pada Subclass)
 * 7. Encapsulation (Enkapsulasi Data dengan Private Attributes, Getter, dan Setter)
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("######################################################################");
        System.out.println("#            FOOTBALL TEAM MANAGEMENT SYSTEM (JAVA OOP)              #");
        System.out.println("######################################################################\n");

        // =====================================================================
        // 1. PEMBUATAN OBJEK PEMAIN DARI BERBAGAI POSISI (INHERITANCE)
        // =====================================================================
        System.out.println("=== [1] MEMBUAT OBJEK PEMAIN & MENAMBAHKAN KE DALAM TIM ===");
        Goalkeeper gk = new Goalkeeper("Nadeo Argawinata", 1, 27);
        Defender def1 = new Defender("Rizky Ridho", 5, 23);
        Defender def2 = new Defender("Jay Idzes", 4, 24);
        Midfielder mid1 = new Midfielder("Thom Haye", 19, 29);
        Midfielder mid2 = new Midfielder("Marselino Ferdinan", 7, 20);
        Forward fwd1 = new Forward("Rafael Struick", 9, 21);
        Forward fwd2 = new Forward("Ragnar Oratmangoen", 11, 26);

        // =====================================================================
        // 2. PENAMBAHAN PEMAIN KE DALAM SATU TIM
        // =====================================================================
        Team garudaTeam = new Team("Garuda Muda FC");
        garudaTeam.addPlayer(gk);
        garudaTeam.addPlayer(def1);
        garudaTeam.addPlayer(def2);
        garudaTeam.addPlayer(mid1);
        garudaTeam.addPlayer(mid2);
        garudaTeam.addPlayer(fwd1);
        garudaTeam.addPlayer(fwd2);

        // Menampilkan seluruh daftar pemain
        garudaTeam.displayAllPlayers();

        // =====================================================================
        // 3. DEMONSTRASI ENCAPSULATION (GETTER & SETTER)
        // =====================================================================
        System.out.println("\n=== [2] DEMONSTRASI ENCAPSULATION (GETTER & SETTER) ===");
        System.out.println("Data sebelum perubahan -> Nama: " + mid2.getName()
                + " | No. Punggung: #" + mid2.getJerseyNumber()
                + " | Usia: " + mid2.getAge() + " thn");

        // Mengubah nomor punggung dan usia menggunakan Setter
        mid2.setJerseyNumber(10);
        mid2.setAge(21);
        System.out.println("Data setelah Setter    -> Nama: " + mid2.getName()
                + " | No. Punggung: #" + mid2.getJerseyNumber()
                + " | Usia: " + mid2.getAge() + " thn");

        // =====================================================================
        // 4. PEMANGGILAN METHOD MENGGUNAKAN POLYMORPHISM (ArrayList<Player>)
        // =====================================================================
        // Mengambil koleksi ArrayList<Player> dari objek Team dan melakukan iterasi
        // untuk memanggil method performRole() melalui referensi bertipe Player.
        ArrayList<Player> squadList = garudaTeam.getPlayers();
        System.out.println("\n=== [3] DEMONSTRASI RUNTIME POLYMORPHISM (ArrayList<Player>) ===");
        for (Player player : squadList) {
            // Satu tipe referensi (Player) menghasilkan perilaku berbeda sesuai objek aslinya
            player.performRole();
        }

        // =====================================================================
        // 5. PEMANGGILAN METHOD DARI INTERFACE (Trainable & Playable)
        // =====================================================================
        System.out.println("\n=== [4] DEMONSTRASI PEMANGGILAN METHOD MELALUI TIPE INTERFACE ===");
        // Polimorfisme melalui referensi Interface Trainable
        Trainable trainablePlayer = gk;
        trainablePlayer.train();

        // Polimorfisme melalui referensi Interface Playable
        Playable playablePlayer = fwd1;
        playablePlayer.playMatch();

        // =====================================================================
        // 6. SIMULASI AKTIVITAS LATIHAN TIM
        // =====================================================================
        garudaTeam.runTrainingSession();

        // =====================================================================
        // 7. SIMULASI PERTANDINGAN SEPAK BOLA
        // =====================================================================
        garudaTeam.simulateMatch("Harimau Malaya FC");
    }
}
