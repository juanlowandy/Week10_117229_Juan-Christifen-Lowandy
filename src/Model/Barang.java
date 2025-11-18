package Model;

public class Barang {
    private String id;
    private String nama;
    private int harga;
    private int stok;

    public Barang(String id, String nama, int harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // GETTER
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // SETTER
    public void setStok(int stok) {
        this.stok = stok;
    }
}
