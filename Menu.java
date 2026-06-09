import java.io.*;
import java.util.ArrayList;

public class Menu {

    private ArrayList<MenuItem> daftarMenu;

    public Menu() {
    daftarMenu = new ArrayList<>();

    daftarMenu.add(
            new Makanan(
                    "Ramen Shoyu",
                    35000,
                    "Mie"));

    daftarMenu.add(
            new Makanan(
                    "Chicken Katsu",
                    28000,
                    "Goreng"));

    daftarMenu.add(
            new Makanan(
                    "Sushi Salmon",
                    45000,
                    "Seafood"));

    daftarMenu.add(
            new Minuman(
                    "Ocha Dingin",
                    8000,
                    "Minuman Dingin"));

    daftarMenu.add(
            new Minuman(
                    "Matcha Latte",
                    18000,
                    "Minuman Panas"));

    daftarMenu.add(
            new Diskon(
                    "Diskon Weekend",
                    10));
}

    public void tambahMenu(MenuItem item) {
        daftarMenu.add(item);
    }

    public ArrayList<MenuItem> getDaftarMenu() {
        return daftarMenu;
    }

    public void tampilkanMenu() {

    System.out.println("\n==============================");
    System.out.println("    RESTORAN JAPANESE 24");
    System.out.println("==============================");

    for (int i = 0; i < daftarMenu.size(); i++) {

        System.out.print((i + 1) + ". ");
        daftarMenu.get(i).tampilMenu();
    }

    System.out.println("==============================");
}

    public MenuItem getItem(int index) throws Exception {

        if (index < 0 || index >= daftarMenu.size()) {
            throw new Exception("Menu tidak ditemukan!");
        }

        return daftarMenu.get(index);
    }

    public void simpanMenu() {

        try (PrintWriter writer = new PrintWriter(
                new FileWriter("menu.txt"))) {

            for (MenuItem item : daftarMenu) {

                if (item instanceof Makanan) {

                    Makanan m = (Makanan) item;

                    writer.println("Makanan,"
                            + m.getNama() + ","
                            + m.getHarga() + ","
                            + m.getJenisMakanan());

                } else if (item instanceof Minuman) {

                    Minuman m = (Minuman) item;

                    writer.println("Minuman,"
                            + m.getNama() + ","
                            + m.getHarga() + ","
                            + m.getJenisMinuman());

                } else if (item instanceof Diskon) {

                    Diskon d = (Diskon) item;

                    writer.println("Diskon,"
                            + d.getNama() + ","
                            + d.getDiskon());
                }
            }

        } catch (IOException e) {
            System.out.println("Gagal menyimpan menu.");
        }
    }

    public void muatMenu() {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("menu.txt"))) {

            String baris;

            while ((baris = reader.readLine()) != null) {

                String[] data = baris.split(",");

                if (data[0].equals("Makanan")) {

                    tambahMenu(new Makanan(
                            data[1],
                            Double.parseDouble(data[2]),
                            data[3]));

                } else if (data[0].equals("Minuman")) {

                    tambahMenu(new Minuman(
                            data[1],
                            Double.parseDouble(data[2]),
                            data[3]));

                } else if (data[0].equals("Diskon")) {

                    tambahMenu(new Diskon(
                            data[1],
                            Double.parseDouble(data[2])));
                }
            }

        } catch (IOException e) {
            System.out.println("File menu belum tersedia.");
        }
    }
}