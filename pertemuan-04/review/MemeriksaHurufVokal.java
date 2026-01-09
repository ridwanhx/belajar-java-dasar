import java.util.Scanner;

public class MemeriksaHurufVokal{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // var input = scan.nextInt(); // untuk menerima input int
        // var input = scan.nextLine(); // untuk menerima input string
        
        //Tulis jawaban anda dibawah ini
        char c = scan.next().charAt(0);

        char lower = Character.toLowerCase(c);

        boolean isVokal = (lower == 'a' || lower == 'i' || lower == 'u' || lower == 'e' || lower == 'o');

        System.out.println(isVokal);

        scan.close();

        
    }
}
