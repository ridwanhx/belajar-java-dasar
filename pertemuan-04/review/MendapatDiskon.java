import java.util.Scanner;

public class MendapatDiskon{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // var input = scan.nextInt(); // untuk menerima input int
        // var input = scan.nextLine(); // untuk menerima input string
        
        //Tulis jawaban anda dibawah ini
        double hargaBarang = scan.nextDouble();
        int jumlahBarang = scan.nextInt();

        double total = hargaBarang * jumlahBarang;

        if (jumlahBarang % 12 == 0) {
            total = total - (0.15 * total);
        }

        System.out.printf("%.2f\n", total);

        scan.close();
        
    }
}
