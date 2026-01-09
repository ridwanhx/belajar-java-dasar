import java.util.Scanner;

public class WujudBenda {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // var input = scan.nextInt(); // untuk menerima input int
        // var input = scan.nextLine(); // untuk menerima input string
        
        //Tulis jawaban anda dibawah ini
        // Input: satu bilangan riil
        double suhu = scan.nextDouble();

        // Logika menentukan wujud benda
        if (suhu >= 0 && suhu <= 100) {
            System.out.println("berwujud cair");
        } else {
            System.out.println("berwujud non cair");
        }

        scan.close();
        
    }
}