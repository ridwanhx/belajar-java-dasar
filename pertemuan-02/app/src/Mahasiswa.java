public class Mahasiswa {
    // inisiasi properties
    String nama;
    int umur;

    // inisiasi constructor
    public Mahasiswa( String n, int u ) {
        nama = n;
        umur = u;
    }

    // inisiasi method internal
    void displayInfo() {
        System.out.println("Nama : " + nama);
        System.out.println("Umur : " + umur);
    }
}
