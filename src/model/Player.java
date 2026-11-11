package model;

import interfaces.Playable;
import interfaces.Trainable;

// Abstract class sebagai kerangka dasar seluruh pemain
public abstract class Player implements Trainable, Playable {

    // Atribut private (Encapsulation)
    private String name;
    private int jerseyNumber;
    private int age;
    private String position;

    public Player(String name, int jerseyNumber, int age, String position) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.age = age;
        this.position = position;
    }

    public Player(String name, int jerseyNumber, int age) {
        this(name, jerseyNumber, age, "Player");
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        if (jerseyNumber > 0 && jerseyNumber <= 99) {
            this.jerseyNumber = jerseyNumber;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position != null && !position.trim().isEmpty()) {
            this.position = position.trim();
        }
    }

    // Method abstrak yang wajib diisi oleh setiap posisi pemain
    public abstract void performRole();

    // Menampilkan data singkat pemain dalam baris tabel
    public void displayInfo() {
        System.out.printf("| #%-3d | %-22s | %-2d thn | %-12s |%n",
                jerseyNumber, name, age, position);
    }
}
