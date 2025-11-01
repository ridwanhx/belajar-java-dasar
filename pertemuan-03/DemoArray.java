import java.util.ArrayList;

public class DemoArray {
    public static void main(String[] args) {
        ArrayList<String> nama = new ArrayList<>();

        nama.add("Rina");
        nama.add("Dian");
        nama.add("Budi");
        nama.add("Sinta");

        nama.remove("Dian"); // hapus elemen dengan value "Dian"
        nama.set(1, "Eka"); // ubah elemen

        System.out.println("Jumlah: " + nama.size());

        // memanggil data berdasarkan index menggunakan get()
        for (int i = 0; i < 2; i++) {
            System.out.println("Index " + i + " : " + nama.get(i));
        }

    }
}
