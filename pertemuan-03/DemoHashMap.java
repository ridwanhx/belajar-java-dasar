import java.util.HashMap;

public class DemoHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> nilai = new HashMap<>();

        nilai.put("Rian", 80);
        nilai.put("Edo", 70);
        nilai.put("Malika", 90);
        nilai.put("Edo", 20);

        System.out.println("Nilai Edo: " +nilai.get("Edo"));
        System.out.println("Daftar Mahasiswa");

        for (String nama : nilai.keySet()) {
            System.out.println("- " + nama + " : " + nilai.get(nama));
        }
    }
}
