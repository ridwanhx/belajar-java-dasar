import java.util.Scanner;

public class CekTangkiBensin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int uang = scan.nextInt();
        double kapasitas = scan.nextDouble();

        // Harga bensin premium
        double harga = 7600.0;

        // Hitung jumlah bensin yang dibeli
        double bensin = uang / harga;

        // Output
        System.out.printf("%.2f\n", bensin);

        // Cek kapasitas tangki
        if (bensin > kapasitas) {
            System.out.println("Bensin Berlebih");
        }
        
        scan.close();
  }

}
