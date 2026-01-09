import java.util.Scanner;

public class MembeliBensin{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // var input = scan.nextInt(); // untuk menerima input int
        // var input = scan.nextLine(); // untuk menerima input string
        
        //Tulis jawaban anda dibawah ini
        int jenis = scan.nextInt();

        double jumlahLiter = scan.nextDouble();

        double hargaPertamax = 9000.0;
        double hargaPremium = 7600.0;

        double totalBayar;
        if (jenis == 1) {
            totalBayar = jumlahLiter * hargaPertamax;
        } else {
            totalBayar = jumlahLiter * hargaPremium;
        }


        System.out.printf("%.2f\n", totalBayar);

        scan.close();
        
    }
}