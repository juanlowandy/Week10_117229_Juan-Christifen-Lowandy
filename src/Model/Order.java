package Model;

public class Order {
    private String namaBarang;
    private int jumlah;
    private int total;

    public Order(String namaBarang, int jumlah, int total) {
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
        this.total = total;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getTotal() {
        return total;
    }
}
