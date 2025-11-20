import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        ArrayList<Integer> angka = new ArrayList<>(Arrays.asList(5, 3, 8, 2));

        for (int i = 0; i < angka.size() - 1; i++) {
            int minIndex = i;
            for (int j = 0; j < angka.size(); j++) {
                if (angka.get(j) < angka.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = angka.get(i);
            angka.set(angka.get(i), angka.get(minIndex));
            angka.set(angka.get(minIndex), temp);
        }

        System.out.println("angka: " + angka);
    }
}
