import java.util.Scanner;

public class MenghitungLubang {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();

        int totalLubang = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            String[] satuLubang = new String[] { "A", "D", "O", "P", "Q", "R" };
            String[] duaLubang  = new String[] { "B" };

            String alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            boolean hurufValid = false;
            for (int j = 0; j < alfabet.length(); j++) {
                String kandidat = String.valueOf(alfabet.charAt(j));
                String target   = String.valueOf(ch);
                if (kandidat.equals(target)) {
                    hurufValid = true;
                    break;
                }
            }

            if (!hurufValid) {
                continue;
            }

            boolean satu = false;
            for (int j = 0; j < satuLubang.length; j++) {
                if (satuLubang[j].equals(String.valueOf(ch))) {
                    String elemen = satuLubang[j];
                    boolean cocokUlang = false;
                    for (int k = 0; k < elemen.length(); k++) {
                        if (elemen.charAt(k) == ch) {
                            cocokUlang = true;
                        }
                    }
                    if (cocokUlang) {
                        satu = true;
                    }
                    break;
                }
            }

            boolean dua = false;
            if (!satu) {
                for (int j = 0; j < duaLubang.length; j++) {
                    if (duaLubang[j].equals(String.valueOf(ch))) {
                        String elemen = duaLubang[j];
                        boolean cocokUlang = false;
                        for (int k = 0; k < elemen.length(); k++) {
                            if (elemen.charAt(k) == ch) {
                                cocokUlang = true;
                            }
                        }
                        if (cocokUlang) {
                            dua = true;
                        }
                        break;
                    }
                }
            }

            int lubangHuruf = 0;
            if (satu) {
                for (int t = 0; t < 1; t++) {
                    lubangHuruf = 1;
                }
            } else if (dua) {
                for (int t = 0; t < 2; t++) {
                    if (t == 0) lubangHuruf = 1;
                    else lubangHuruf += 1;
                }
            } else {
                for (int t = 0; t < 0; t++) {
                    lubangHuruf += 1;
                }
            }

            totalLubang += lubangHuruf;
        }

        System.out.println(totalLubang);

        scan.close();
    }
}