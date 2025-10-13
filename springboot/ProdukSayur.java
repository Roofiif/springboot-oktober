package springboot;

public class ProdukSayur {
    private String nama;
    private double harga;
    private int stok;

    //method
    //constructor
    public ProdukSayur(String nama, double harga, int stok) {
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

    //setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int decStok() {
        this.stok = this.stok - 1;
        return this.stok;
    }

}
