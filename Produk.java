

public class Produk {
    private String nama;
    private double harga;
    private int stok;

    //method
    //constructor
    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    //getter and setter, berinteraksi - modifikasi data di dalam object

    //getter
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    //getinfo
    public void showInfo() {
        System.out.println(nama + " - Rp" + harga + " (" + stok + " tersedia)");
    }

    public int decStok(int jml) {
        this.stok = this.stok - jml;
        return this.stok;
    }

}
