import java.util.Scanner;

public class KasirSayur {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0;
        boolean selesai = false;

        System.out.println("=== KASIR TOKO SAYUR ===");
        System.out.println("Menu Sayuran:");
        System.out.println("1. Wortel     - Rp 10000/kg");
        System.out.println("2. Bayam      - Rp 5000/ikat");
        System.out.println("3. Kangkung   - Rp 4000/ikat");
        System.out.println("4. Kentang    - Rp 12000/kg");
        System.out.println("5. Kubis      - Rp 8000/kg");
        System.out.println("0. Selesai");

        while (!selesai) {
            System.out.print("\nPilih nomor menu (0-5): ");
            int pilihan = input.nextInt();

            if (pilihan == 0) {
                selesai = true;
                continue;
            }

            if (pilihan < 1 || pilihan > 5) {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            System.out.print("Masukkan jumlah: ");
            int jumlah = input.nextInt();

            int harga = 0;
            String item = "";

            switch (pilihan) {
                case 1:
                    harga = 10000;
                    item = "Wortel";
                    break;
                case 2:
                    harga = 5000;
                    item = "Bayam";
                    break;
                case 3:
                    harga = 4000;
                    item = "Kangkung";
                    break;
                case 4:
                    harga = 12000;
                    item = "Kentang";
                    break;
                case 5:
                    harga = 8000;
                    item = "Kubis";
                    break;
            }

            int subtotal = harga * jumlah;
            total += subtotal;

            System.out.println(item + " x " + jumlah + " = Rp " + subtotal);
        }

        System.out.println("\n=== STRUK PEMBAYARAN ===");
        System.out.println("Total Belanja: Rp " + total);
        
        System.out.print("Masukkan jumlah uang: Rp ");
        int uangBayar = input.nextInt();
        
        int kembalian = uangBayar - total;
        System.out.println("Kembalian: Rp " + kembalian);
        System.out.println("\nTerima kasih telah berbelanja!");
        
        input.close();
    }
}