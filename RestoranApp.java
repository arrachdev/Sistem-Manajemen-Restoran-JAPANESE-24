import java.util.Scanner;

public class RestoranApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Menu menu = new Menu();
        menu.muatMenu();

        Pesanan pesanan = new Pesanan();

        int pilihan;

        do {

            System.out.println("\n=== MANAJEMEN RESTORAN ===");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Tampilkan Menu");
            System.out.println("3. Pesan Menu");
            System.out.println("4. Hitung Total");
            System.out.println("5. Tampilkan Struk");
            System.out.println("6. Keluar");
            System.out.print("Pilihan : ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:

                    System.out.println("\n1. Makanan");
                    System.out.println("2. Minuman");
                    System.out.println("3. Diskon");
                    System.out.print("Pilih : ");

                    int jenis = input.nextInt();
                    input.nextLine();

                    if (jenis == 1) {

                        System.out.print("Nama : ");
                        String nama = input.nextLine();

                        System.out.print("Harga : ");
                        double harga = input.nextDouble();
                        input.nextLine();

                        System.out.print("Jenis Makanan : ");
                        String jm = input.nextLine();

                        menu.tambahMenu(
                                new Makanan(
                                        nama,
                                        harga,
                                        jm));

                    } else if (jenis == 2) {

                        System.out.print("Nama : ");
                        String nama = input.nextLine();

                        System.out.print("Harga : ");
                        double harga = input.nextDouble();
                        input.nextLine();

                        System.out.print("Jenis Minuman : ");
                        String jn = input.nextLine();

                        menu.tambahMenu(
                                new Minuman(
                                        nama,
                                        harga,
                                        jn));

                    } else if (jenis == 3) {

                        System.out.print("Nama Diskon : ");
                        String nama = input.nextLine();

                        System.out.print("Persentase : ");
                        double diskon = input.nextDouble();

                        menu.tambahMenu(
                                new Diskon(
                                        nama,
                                        diskon));
                    }

                    menu.simpanMenu();

                    break;

                case 2:

                    menu.tampilkanMenu();

                    break;

                case 3:

                    menu.tampilkanMenu();

                    System.out.print("Pilih nomor menu : ");
                    int nomor = input.nextInt();

                    System.out.print("Jumlah : ");
                    int jumlah = input.nextInt();
                    
                    try {

                        MenuItem item = menu.getItem(nomor - 1);

                        for(int i = 0; i < jumlah; i++) {
                        pesanan.tambahPesanan(item);
                    }

                        System.out.println(
                                "Menu berhasil ditambahkan.");

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage());
                    }

                    break;

                case 4:

                    System.out.println(
                            "Total Bayar : Rp"
                                    + pesanan.hitungTotal());

                    break;

                case 5:

                    pesanan.tampilStruk();
                    pesanan.simpanStruk();

                    break;

                case 6:

                 System.out.println("\n=================================");
                 System.out.println(" Terima kasih telah menggunakan");
                 System.out.println(" Sistem Manajemen Restoran JAPANESE24");
                 System.out.println("=================================");
                 System.out.println(" Program ditutup.");
                 System.out.println(" Sampai jumpa kembali!");
                  break;

                default:

                    System.out.println(
                            "Pilihan tidak tersedia.");
            }

        } while (pilihan != 6);

        input.close();
    }
}