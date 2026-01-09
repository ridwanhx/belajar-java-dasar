import java.util.Scanner;

public class KonversiBinerDecimal{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // var input = scan.nextInt(); // untuk menerima input int
        // var input = scan.nextLine(); // untuk menerima input string
        
        //Tulis jawaban anda dibawah ini
        String biner = scan.nextLine();

        int desimal = Integer.parseInt(biner, 2);

        System.out.println(desimal);

        scan.close();
        
    }
}