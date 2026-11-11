package model;

// Subclass untuk posisi Penjaga Gawang
public class Goalkeeper extends Player {

    public Goalkeeper(String name, int jerseyNumber, int age) {
        super(name, jerseyNumber, age, "Goalkeeper");
    }

    @Override
    public void performRole() {
        System.out.printf("| %-10s | #%-2d %-18s : Menjaga gawang dan menepis tembakan lawan.%n",
                getPosition(), getJerseyNumber(), getName());
    }

    @Override
    public void train() {
        System.out.printf("| %-10s | %-22s : Latihan refleks tangkapan dan tendangan gawang.%n",
                getPosition(), getName());
    }

    @Override
    public void playMatch() {
        System.out.printf("| %-10s | #%-2d %-18s : Melakukan penyelamatan di bawah mistar gawang!%n",
                getPosition(), getJerseyNumber(), getName());
    }
}
