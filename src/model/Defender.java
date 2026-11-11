package model;

// Subclass untuk posisi Pemain Bertahan (Bek)
public class Defender extends Player {

    public Defender(String name, int jerseyNumber, int age) {
        super(name, jerseyNumber, age, "Defender");
    }

    @Override
    public void performRole() {
        System.out.printf("| %-10s | #%-2d %-18s : Mengawal lawan, melakukan tekel, dan potong umpan.%n",
                getPosition(), getJerseyNumber(), getName());
    }

    @Override
    public void train() {
        System.out.printf("| %-10s | %-22s : Latihan fisik, duel udara, dan ketepatan tekel.%n",
                getPosition(), getName());
    }

    @Override
    public void playMatch() {
        System.out.printf("| %-10s | #%-2d %-18s : Menjaga kotak penalti dan memblokir serangan lawan!%n",
                getPosition(), getJerseyNumber(), getName());
    }
}
