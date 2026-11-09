package model;

import interfaces.Playable;
import interfaces.Trainable;

/**
 * Abstract Class Player
 * 
 * Konsep OOP yang diterapkan pada class ini:
 * 1. ABSTRACT CLASS: Class induk abstrak yang tidak dapat diinstansiasi secara langsung,
 *    berfungsi sebagai kerangka dasar (blueprint) bagi seluruh jenis pemain.
 * 2. ENCAPSULATION: Seluruh atribut dideklarasikan dengan modifier 'private' agar tidak
 *    dapat diakses langsung dari luar class, melainkan melalui Getter dan Setter.
 * 3. INTERFACE IMPLEMENTATION: Mengimplementasikan interface Trainable dan Playable
 *    sehingga setiap objek Player memiliki kontrak latihan dan bertanding.
 * 4. ABSTRACT METHOD: Mendeklarasikan method 'performRole()' tanpa body yang wajib
 *    di-override oleh setiap subclass sesuai posisi bermainnya.
 */
public abstract class Player implements Trainable, Playable {

    // =========================================================================
    // ENCAPSULATION: Atribut bersifat private untuk melindungi integritas data
    // =========================================================================
    private String name;
    private int jerseyNumber;
    private int age;
    private String position;

    /**
     * Constructor utama untuk menginisialisasi data pemain lengkap beserta posisinya.
     *
     * @param name         Nama pemain
     * @param jerseyNumber Nomor punggung pemain
     * @param age          Usia pemain
     * @param position     Posisi bermain (Goalkeeper, Defender, Midfielder, Forward)
     */
    public Player(String name, int jerseyNumber, int age, String position) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.age = age;
        this.position = position;
    }

    /**
     * Constructor overloading dengan tiga parameter utama sesuai spesifikasi dasar.
     *
     * @param name         Nama pemain
     * @param jerseyNumber Nomor punggung pemain
     * @param age          Usia pemain
     */
    public Player(String name, int jerseyNumber, int age) {
        this(name, jerseyNumber, age, "Player");
    }

    // =========================================================================
    // ENCAPSULATION: Method Getter dan Setter untuk akses terkontrol ke atribut
    // =========================================================================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
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
            this.position = position;
        }
    }

    // =========================================================================
    // ABSTRACT METHOD: Wajib diimplementasikan (override) oleh setiap subclass
    // =========================================================================

    /**
     * Menampilkan peran spesifik pemain di lapangan sesuai posisinya.
     * Method ini tidak memiliki body karena setiap posisi memiliki tugas berbeda.
     */
    public abstract void performRole();

    // =========================================================================
    // CONCRETE METHOD: Method umum yang langsung diwarisi oleh seluruh subclass
    // =========================================================================

    /**
     * Menampilkan informasi profil lengkap pemain ke layar.
     */
    public void displayInfo() {
        System.out.printf("No. #%-2d | Nama: %-18s | Usia: %2d thn | Posisi: %-12s%n",
                jerseyNumber, name, age, position);
    }
}
