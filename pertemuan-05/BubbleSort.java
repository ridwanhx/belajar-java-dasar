import java.util.ArrayList;
import java.util.Arrays;

class BubbleSort {
    public static void main(String[] args) {
        ArrayList<Integer> angka = new ArrayList<>(Arrays.asList(5,3,8,2));

        for (int i = 0; i < angka.size(); i++) {
            for (int j = 0; j < angka.size() - 1 - i; j++) {
                if ( angka.get(j) > angka.get(j + 1) ) {
                    int temp = angka.get(j);
                    angka.set(j, angka.get(j + 1));
                    angka.set(j + 1, temp);
                }
            }
        }

        System.out.println("Hasil sorting: " + angka);
    }
}