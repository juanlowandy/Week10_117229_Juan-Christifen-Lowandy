package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Barang> daftarBarang = new ArrayList<>();
        ArrayList<Order> listOrder = new ArrayList<>();

        while (true) {

            System.out.println("------------Menu Toko Voucher & HP-------------");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("3. Barang Baru");
            System.out.print("Pilihan : ");
            int pilih = sc.nextInt();
            sc.nextLine();

            // ======================================================
            //                PILIHAN 1 : PESAN BARANG
            // ======================================================
            if (pilih == 1) {

                if (daftarBarang.isEmpty()) {
                    System.out.println("Belum ada barang!\n");
                    continue;
                }

                System.out.println("Daftar Barang Toko Voucher & HP");
                for (Barang b : daftarBarang) {
                    System.out.println("----------------------------------------");
                    System.out.println("ID    : " + b.getId());
                    System.out.println("Nama  : " + b.getNama());
                    System.out.println("Stok  : " + b.getStok());
                    System.out.println("Harga : " + b.getHarga());
                }
                System.out.println("----------------------------------------");

                System.out.print("Ketik 0 untuk batal\nPesan Barang (ID) : ");
                String id = sc.nextLine();

                if (id.equals("0")) {
                    System.out.println("Dibatalkan.\n");
                    continue;
                }

                Barang barangDipilih = null;
                for (Barang b : daftarBarang) {
                    if (b.getId().equalsIgnoreCase(id)) {
                        barangDipilih = b;
                        break;
                    }
                }

                if (barangDipilih == null) {
                    System.out.println("Barang tidak ditemukan!\n");
                    continue;
                }

                System.out.print("Masukkan Jumlah : ");
                int jumlah = sc.nextInt();
                sc.nextLine();

                if (jumlah > barangDipilih.getStok()) {
                    System.out.println("Stok tidak cukup!\n");
                    continue;
                }

                int total = jumlah * barangDipilih.getHarga();
                System.out.println(jumlah + " @ " + barangDipilih.getNama() + 
                                   " dengan total harga " + total);

                System.out.print("Masukkan jumlah uang : ");
                int uang = sc.nextInt();
                sc.nextLine();

                if (uang < total) {
                    System.out.println("Uang tidak cukup!\n");
                    continue;
                }

                barangDipilih.setStok(barangDipilih.getStok() - jumlah);

                listOrder.add(new Order(barangDipilih.getNama(), jumlah, total));

                System.out.println("Berhasil dipesan!\n");
            }

            // ======================================================
            //                PILIHAN 2 : LIHAT PESANAN
            // ======================================================
            else if (pilih == 2) {

                if (listOrder.isEmpty()) {
                    System.out.println("Belum ada pesanan.\n");
                } else {
                    System.out.println("---- Daftar Pesanan ----");
                    for (Order o : listOrder) {
                        System.out.println("----------------------------------");
                        System.out.println("Nama Barang : " + o.getNamaBarang());
                        System.out.println("Jumlah      : " + o.getJumlah());
                        System.out.println("Total Harga : " + o.getTotal());
                    }
                    System.out.println("----------------------------------\n");
                }
            }

            // ======================================================
            //                PILIHAN 3 : INPUT BARANG BARU
            // ======================================================
            else if (pilih == 3) {

                System.out.print("Voucher / Handphone (V/H): ");
                String jenis = sc.nextLine().toLowerCase();

                if (jenis.equals("h")) {

                    String idBaru = "H" + String.format("%02d", daftarBarang.size() + 1);

                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Harga: ");
                    int harga = sc.nextInt();
                    System.out.print("Stok: ");
                    int stok = sc.nextInt();
                    sc.nextLine();

                    Barang hp = new Handphone(idBaru, nama, harga, stok);  // ← Perubahan penting
                    daftarBarang.add(hp);

                    System.out.println("Handphone telah berhasil diinput\n");
                }

                else if (jenis.equals("v")) {

                    String idBaru = "V" + String.format("%02d", daftarBarang.size() + 1);

                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Harga: ");
                    int harga = sc.nextInt();
                    System.out.print("Stok: ");
                    int stok = sc.nextInt();
                    sc.nextLine();

                    Barang v = new Voucher(idBaru, nama, harga, stok);  // ← Perubahan penting
                    daftarBarang.add(v);

                    System.out.println("Voucher telah berhasil diinput\n");
                }

                else {
                    System.out.println("Input tidak dikenal!\n");
                }
            }
        }
    }
}
