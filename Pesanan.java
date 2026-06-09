import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Pesanan {

    private ArrayList<MenuItem> daftarPesanan;

    public Pesanan() {
        daftarPesanan = new ArrayList<>();
    }

    public void tambahPesanan(MenuItem item) {
        daftarPesanan.add(item);
    }

    public double hitungTotal() {

        double total = 0;
        double persenDiskon = 0;

        for (MenuItem item : daftarPesanan) {

            if (item instanceof Diskon) {

                Diskon d = (Diskon) item;
                persenDiskon = d.getDiskon();

            } else {

                total += item.getHarga();
            }
        }

        total = total - (total * persenDiskon / 100);

        return total;
    }

    public void tampilStruk() {

    System.out.println("\n==============================");
    System.out.println("       STRUK PEMBELIAN");
    System.out.println("      RESTORAN JAPANESE 24");
    System.out.println("==============================");

    for (MenuItem item : daftarPesanan) {

        if (!(item instanceof Diskon)) {
            System.out.println(
                    item.getNama()
                            + " - Rp"
                            + item.getHarga());
        }
    }

    System.out.println("------------------------------");
    System.out.println("Total Bayar : Rp" + hitungTotal());
    System.out.println("==============================");
    System.out.println("Arigatou!");
}

    public void simpanStruk() {

        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter("struk.txt"))) {

            writer.println("===== STRUK =====");

            for (MenuItem item : daftarPesanan) {
                writer.println(item.getNama());
            }

            writer.println("Total : Rp" + hitungTotal());

        } catch (IOException e) {
            System.out.println("Gagal menyimpan struk.");
        }
    }
}