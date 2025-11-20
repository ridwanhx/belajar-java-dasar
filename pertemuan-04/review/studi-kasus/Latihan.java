import java.util.ArrayList;
import java.util.Scanner;

public class Latihan {
    public static void main(String[] args) {
        // 1. Membaca 5 nilai (bilangan bulat) dan menyimpannya ke ArrayList<Integer>
        // inisiasi ArrayList untuk menampung nilai
        ArrayList<Integer> nilai = new ArrayList<>();

        // inisiasi attribut pendukung
        double average = 0;
        int jmlLulus = 0;

        // inisiasi objek baru yang merupakan instance ke Scanner
        Scanner input = new Scanner(System.in);
        
        System.out.print("Masukkan jumlah mahasiswa: ");
        Integer n = input.nextInt();

        // 2. Menampilkan semua nilai (pakai perulangan for / foreach)
        for (int i = 0; i < n; i++) {
            // input setiap nilai bilangan kedalam ArrayList
            System.out.print("Masukkan nilai mahasiswa ke-" + (i + 1) + " : ");
            nilai.add(input.nextInt());
        }

        // 3. Menghitung dan menampilkan:
            // 1. Rata-rata nilai
            for (int i = 0; i < nilai.size(); i++) {
                average += nilai.get(i);
            }
            average /= nilai.size();

            // 2. Jumlah yang lulus (nilai >= 60), gunakan if
            for (Integer x : nilai) {
                if (x >= 60) {
                    jmlLulus++;
                }
            }

            // 3. Nilai tertinggi dan terendah
            int min = nilai.get(0); // inisiasi nilai awal
            int max = nilai.get(0); // inisiasi nilai awal
            for (int i = 0; i < nilai.size(); i++) {
                if (nilai.get(i) > max) {
                    max = nilai.get(i);
                }

                if (nilai.get(i) < min) {
                    min = nilai.get(i);
                }
            }

            System.out.println("--------------------");
            System.out.println("Program Hitung Nilai");
            System.out.println("--------------------");
            System.out.println("Rata-rata nilai: " + average);
            System.out.println("Jumlah mahasiswa lulus: " + jmlLulus);
            System.out.println("Nilai tertinggi: " + max);
            System.out.println("Nilai terendah: " + min);
    }
}
