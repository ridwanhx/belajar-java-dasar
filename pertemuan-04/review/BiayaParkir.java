import java.util.Scanner;

public class BiayaParkir {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int jenis = scan.nextInt();

        int jam = scan.nextInt();

        int biaya = 0;

        if (jenis == 1) {
            if (jam == 1) { // mobil
                biaya = 2000;
            } else {
                biaya = 2000 + (jam - 1) * 1000;
            }
        } else if (jenis == 2) {    // motor
            if (jam == 1) {
                biaya = 1000;
            } else {
                biaya = 1000 + (jam - 1) * 500;
            }
        }

        System.out.println(biaya);

        scan.close();
    }
}