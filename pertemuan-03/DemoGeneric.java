import java.util.ArrayList;

public class DemoGeneric {
    public static void main(String[] args) {
        ArrayList data = new ArrayList<>();
        data.add("Hello");
        data.add(100);

        String teks = data.get(0);
        System.out.println(teks);
    }
}
