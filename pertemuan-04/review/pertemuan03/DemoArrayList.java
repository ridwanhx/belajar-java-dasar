import java.util.ArrayList;

public class DemoArrayList {
    // Pada ArrayList, kita dapat memanfaatkan beberapa method untuk memanipulasi array (menambah, mengubah, menghapus, menghitung banyak data didalamnya, dsb)

    // .size() -> Menghitung jumlah elemen dalam ArrayList
    // .get(index) -> Mengambil nilai berdasarkan index
    // .set(index, nilai) -> Mengubah nilai di index tertentu
    // .add(nilai) -> menambah elemen baru di akhir
    // .remove(index) -> Menghapus elemen di posisi index tertentu

    public static void main(String[] args) {
        // inisiasi array list
        ArrayList<String> nama = new ArrayList<>();

        // menambahkan nilai kedalam array list
        nama.add("Muhamad");    // 0
        nama.add("Ridwan"); // 1
        nama.add("Berliana");   // 2

        // mengubah nilai yang ada didalam array list
        // Mengubah Berliana => Rahadian
        nama.set(2, "Rahadian");

        // menghapus nilai yang ada di dalam array list
        // menghapus "Ridwan"
        nama.remove(nama.get(1));

        // menjalankan perulangan foreach
        for (String n : nama) {
            System.out.println(n);
        }

        // menghitung banyaknya data yang ada didalam array list
        System.out.println("Jumlah data pada array list nama sebanyak: " + nama.size());

        // sebelumnya, kita sudah menggunakan get / mengambil data pada index tertentu di dalam array list
        System.out.println("Data pada index pertama adalah: " + nama.get(0));
    }
}
