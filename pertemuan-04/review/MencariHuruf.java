import java.util.Scanner;

public class MencariHuruf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] X = {'P','a','d','e','p','o','k','a','n','7','9'};

        String input = scan.nextLine();

        // Ambil huruf pertama dari input
        char huruf = input.charAt(0);

        // Ubah ke lowercase untuk pencarian case-insensitive
        char target = Character.toLowerCase(huruf);

        boolean found = false;

        // do loop
        for (char c : X) {
            if (Character.isLetter(c)) {
                if (Character.toLowerCase(c) == target) {
                    found = true;
                    break;
                }
            } else {
                if (c == huruf) {
                    found = true;
                    break;
                }
            }
        }

        // Output
        if (found) {
            System.out.println("ada");
        } else {
            System.out.println("tidak ada");
        }

        scan.close();
    }
}