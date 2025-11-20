import java.util.HashSet;

public class DemoHashSet {
    // HashSet tidak menyimpan data duplikat dan tidak mempertahaknkan urutan
    public static void main(String[] args) {
        // inisiasi array hash set
        HashSet<String> kota = new HashSet<>();

        kota.add("Bandung");
        kota.add("Jakarta");
        kota.add("Pontianak");
        kota.add("Jakarta"); // teridentifikasi duplikat, maka diabaikan
        
        // bisa kita amati nanti pada saat dilakukan running pada program, karena HashSet ini mempunyai karakteristik yaitu tidak mempertahankan urutan, maka dapat dilihat nanti urutannya tidak berurutan sebagaimana yang sudah kita definisikan diatas
        for (String k : kota) {
            System.out.println(k);
        }
    }
}
