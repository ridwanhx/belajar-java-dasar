import java.util.ArrayList;
import java.util.Scanner;

public class LatihanArray {
    public static void main(String[] args) {
        // inisiasi attrs
        double average = 0;
        int lulus = 0;
        int max = 0;
        int min = 0;

        // instansiasi scanner
        Scanner input = new Scanner(System.in);

        // inisiasi array Mahasiswa
        // ArrayList<String> mahasiswa = new ArrayList<>();
        // inisiasi nilai Mahasiswa
        ArrayList<Integer> nilai = new ArrayList<>();
        // inisiasi banyaknya perulangan yang akan dilakukan
        System.out.print("Masukkan jumlah mahasiswa: ");
        int n = input.nextInt();

        // lakukan perulangan
        // ambil nilai setiap mahasiswa
        for (int i = 0; i < n; i++) {
            System.out.print("Nilai Mahasiswa " + (i + 1) + ": ");
            nilai.add(input.nextInt());
        }

        // ambil rata-rata nilai setiap mahasiswa
        for (int i = 0; i < n; i++) {
            average += nilai.get(i);
        }

        // hitung banyaknya mahasiswa yang lulus
        for (int i = 0; i < n; i++) {
            if (nilai.get(i) >= 60) {
                lulus++;
            }
        }

        // int temp = nilai.get(0);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                min = nilai.get(0);
                max = nilai.get(0);
            } else {
                // mencari nilai tertinggi
                if (nilai.get(i) > max) {
                    max = nilai.get(i);
                }
                
                // mencari nilai terendah
                if (nilai.get(i) < min) {
                    min = nilai.get(i);
                }
            }
        }

        System.out.println("=========================");
        System.out.println("=== Hasil Perhitungan ===");
        System.out.println("=========================");
        System.out.println("Nilai Rata-rata: " + (average / n));
        System.out.println("Banyaknya Mahasiswa yang Lulus: " + lulus);
        System.out.println("Nilai Tertinggi: " + max);
        System.out.println("Nilai Terendah: " + min);
    }
}
