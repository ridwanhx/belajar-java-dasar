import java.util.Scanner;

public class BilanganPrima {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int X = scan.nextInt();
        boolean prima = true;

        if (X <= 1) {
            prima = false;
        } else {
            for (int i = 2; i <= Math.sqrt(X); i++) {
                if (X % i == 0) {
                    prima = false;
                    break;
                }
            }
        }

        if (prima) {
            System.out.println("prima");
        } else {
            System.out.println("bukan prima");
        }

        scan.close();
    }
}