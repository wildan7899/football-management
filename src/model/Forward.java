package model;

// Subclass untuk posisi Penyerang
public class Forward extends Player {

    public Forward(String name, int jerseyNumber, int age) {
        super(name, jerseyNumber, age, "Forward");
    }

    @Override
    public void performRole() {
        System.out.printf("| %-10s | #%-2d %-18s : Mencari ruang kosong dan mencetak gol ke gawang lawan.%n",
                getPosition(), getJerseyNumber(), getName());
    }

    @Override
    public void train() {
        System.out.printf("| %-10s | %-22s : Latihan akurasi tembakan (shooting) dan sprint.%n",
                getPosition(), getName());
    }

    @Override
    public void playMatch() {
        System.out.printf("| %-10s | #%-2d %-18s : Menembus kotak penalti dan melepaskan tembakan keras!%n",
                getPosition(), getJerseyNumber(), getName());
    }
}
