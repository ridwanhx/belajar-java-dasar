import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int umur = 21;
        double tinggi = 165.5;
        char gender = 'M';
        boolean is_active = true;
        String nama = "Muhamad Ridwan";
        System.out.println("Nama saya " + nama + " umur saya " + umur + " jenis kelamin " + gender + " keaktifan " + tinggi + " cm " + is_active);

        int a = 10;
        int b = 3;
        System.out.println(a / b);

        System.out.println("===============");

        // == hanya berlaku untuk integer / numeric, sedangkan untuk perbandingan antar string gunakan equals
        // for perulangan yang banyak perulangannya sudah diketahui
        // while akan terus melakukan perulangan selama true

        // instansiasi object Scanner
        Scanner input = new Scanner(System.in);

        // System.out.println("Username : ");
        // String username = input.nextLine();

        // System.out.println("Password : ");
        // String password = input.nextLine();

        // if ( username.equals("admin") || password.equals("admin@123") ) {
        //     System.out.println("Welcome Back, " + username);
        // } else {
        //     System.out.println("Username / password salah!");
        // }

        // kotak
        for (int i = 1; i <= 5; i++) {
            for ( int j = 1; j <= 5; j++ ) {
                System.out.print("*");
            }
            System.out.println();
        }

        // segitiga
        for ( int i = 1; i <= 5; i++ ) {
            for ( int j = 1; j <= i; j++ ) {
                System.out.print("*");
            }
            System.out.println();
        }

        // segitiga
        for ( int i = 1; i <= 5; i++ ) {
            for ( int j = 5; j >= i; j-- ) {
                System.out.print("*");
            }
            System.out.println();
        }

        int index = 1;

        while (index <= 5) {
            
            if ( index == 3 ) {
                break;
            }
            
            System.out.println("Hello World!");
            index++;
        }

    }
}
