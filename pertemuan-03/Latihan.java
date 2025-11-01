import java.util.ArrayList;
import java.util.Scanner;

public class Latihan {
    public static void main(String[] args) {
        // inisiasi array bilangan
        ArrayList<Integer> bilangan = new ArrayList<>();

        // instansiasi Scanner
        Scanner input = new Scanner(System.in);

        // inisiasi attrs
        double avg = 0;
        int max = 0;
        int min = 0;
        int hitungLulus = 0;
        
        // perulangan sebanyak 5x
        for (int index = 0; index < 5; index++) {
            // input oleh user
            System.out.print("Masukkan input ke- " + (index + 1) + ": ");
            int inp = input.nextInt();

            // tambahkan setiap nilai input user kedalam array bilangan
            bilangan.add(inp);

            // penentuan nilai awal
            // jika index masih yang pertama
            if (index == 0) {
                // simpan nilai pertama tersebut kedalam attrs
                max = inp;
                min = inp;
            } else {
                // jika input lebih besar dari nilai max saat ini
                if (inp > max) {
                    // maka override (timpa) nilai max saat ini dengan nilai input tersebut
                    max = inp;
                }
                // ini juga sama
                if (inp < min) {
                    min = inp;
                }
            }

            if (inp >= 60) {
                hitungLulus++;
            }

        }

        // loop sbnyak 5x,
        for (int i = 0; i < 5; i++) {
            System.out.println(bilangan.get(i));
            // average = average + nilai bilangan index saat ini
            avg += bilangan.get(i);
        }

        // output
        System.out.println("=== Hasil Perhitungan ===");
        System.out.println("Rata-rata: " + avg / 5);
        System.out.println("Yang Lulus: " + hitungLulus);
        System.out.println("Nilai Tertinggi: " + max);
        System.out.println("Nilai Terendah: " + min);
    }
}
