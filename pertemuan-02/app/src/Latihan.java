import java.util.Scanner;

public class Latihan {
    public static void main(String[] args) throws Exception {
        // inisiasi Scanner
        Scanner input = new Scanner(System.in);

        
        double total = 0;
        double avgPemakaianBulanan = 0;
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Masukkan pemakaian (Kwh) per hari : ");
            double kwhPerHari = input.nextInt();

            total += kwhPerHari;
        }

        avgPemakaianBulanan = total / 5;

        System.out.println("Total : " + total);
        System.out.println("Rata-rata : " + avgPemakaianBulanan);
    }
}
