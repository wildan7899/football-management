package interfaces;

/**
 * Interface Playable
 * 
 * Konsep OOP: INTERFACE
 * Mendefinisikan kontrak perilaku bertanding (match play) yang harus diimplementasikan
 * oleh setiap class pemain sepak bola.
 */
public interface Playable {

    /**
     * Method abstrak untuk menjalankan aksi pemain saat pertandingan berlangsung.
     */
    void playMatch();
}
