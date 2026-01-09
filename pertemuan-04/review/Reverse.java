import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String teks = scan.nextLine();

        String hasil = new StringBuilder(teks).reverse().toString();

        // Output
        System.out.println(hasil);

        scan.close();
    }
}