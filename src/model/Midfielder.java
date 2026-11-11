package model;

// Subclass untuk posisi Gelandang
public class Midfielder extends Player {

    public Midfielder(String name, int jerseyNumber, int age) {
        super(name, jerseyNumber, age, "Midfielder");
    }

    @Override
    public void performRole() {
        System.out.printf("| %-10s | #%-2d %-18s : Mengatur tempo dan mengalirkan umpan ke lini depan.%n",
                getPosition(), getJerseyNumber(), getName());
    }

    @Override
    public void train() {
        System.out.printf("| %-10s | %-22s : Latihan akurasi umpan, kontrol bola, dan stamina.%n",
                getPosition(), getName());
    }

    @Override
    public void playMatch() {
        System.out.printf("| %-10s | #%-2d %-18s : Menguasai lini tengah dan memberi umpan terobosan!%n",
                getPosition(), getJerseyNumber(), getName());
    }
}
