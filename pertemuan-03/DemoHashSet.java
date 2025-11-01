import java.util.HashSet;

public class DemoHashSet {
    public static void main(String[] args) {
        HashSet<String> kota = new HashSet<>();

        kota.add("Jakarta");
        kota.add("Surabaya");
        kota.add("Bengkulu");
        kota.add("Jakarta"); // duplikat, diabaikan
        
        for (String k : kota) {
            System.out.println(k);
        }
    }
}
