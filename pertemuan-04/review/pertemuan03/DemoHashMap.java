import java.util.HashMap;

public class DemoHashMap {
    // HashMap sendiri diperuntukkan untuk kasus-kasus dimana kita membutuhkan data yang berpasangan (key, value)

    public static void main(String[] args) {
        // inisiasi array hash map
        // karena berdasarkan penjelasan diatas, hashmap itu merupakan data yang berpasangan (key, value). maka wajib hukumnya bagi kita untuk mendeklarasikan tipe data masing-masing key, dan value nya.
        HashMap<String, Integer> nilai = new HashMap<>();

        // berbeda hal nya dengan kasus array sebelumnya, pada hashmap, kita menggunakan put untuk menyimpan data kedalam array
        nilai.put("Ridwan", 89);
        nilai.put("Alfia", 87);
        nilai.put("Qokom", 64);

        // hashmap juga memiliki perbedaan dalam cara perulangannya

        // .keySet() sendiri merupakan method khusus milik Map (HashMap, TreeMap, dll)
        // .keyset() -> Mengembalikan Set berisi semua key yang ada di dalam Map

        // untuk contoh kasus dibawah, bisa kita baca seperti berikut:
        // variabel nama hanya akan berisi key
        // untuk mendapatkan value yang terkait dengan key tersebut, kita perlu memanggil <map>.get(key) -> dalam kasus ini berarti nilai.get(nama)

        // untuk karakteristik kurang lebih masih sama dengan HashSet, dimana untuk urutan nilai nya ini tidak berurutan ketika dijalankan
        for (String nama : nilai.keySet()) {
            System.out.println("- " + nama + " : " + nilai.get(nama));
        }

        // Adapun detail mengenai method apa saja yang dapat kita gunakan untuk Map, diantaranya:

        // .put(key, value) -> Menambahkan pasangan key, value.
        // cth: <map>.put("101", "Rian")

        // .get(key) -> Mengambil value berdasarkan key
        // cth: <map>.get("101")
        
        // .remove(key) -> Menghapus data berdasarkan key
        // cth: <map>.remove("101")

        // .containsKey(key) -> Mengecek apakah key sudah ada
        // cth: <map>.containsKey("101")

        // .containsValue(value) -> Mengecek apakah value sudah ada
        // cth: <map>.containsValue("Rian")
        
        // .size() -> Mengetahui jumlah pasangan data
        // .clear() -> Menghapus semua data
        // .keySet() -> Mengambil semua key
        // .values() -> Mengambil semua value
        // .entrySet() -> Mengambil semua pasangan key dan value

        // implementasi method values
        for (Integer angka : nilai.values()) {
            System.out.println(angka);
        }

        // implementasi method containsKey
        System.out.println(nilai.containsKey("Qokom")); // true
        System.out.println(nilai.containsKey("Maulana"));   // false
    }
}
