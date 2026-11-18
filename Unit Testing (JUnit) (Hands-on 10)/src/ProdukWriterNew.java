import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProdukWriterNew {

    public static <T, U, V> void simpanKeFile(Path filePath, List<Produk<T, U, V>> dataList) throws IOException {
        if (filePath.getParent() != null && Files.notExists(filePath.getParent())) {
            Files.createDirectories(filePath.getParent());
        }
        List<String> lines = new ArrayList<>();
        for (Produk<T, U, V> item : dataList) {
            lines.add(item.toString());
        }
        Files.write(filePath, lines, StandardCharsets.UTF_8);
    }

    public static List<String> bacaDariFile(Path filePath) throws IOException {
        return Files.readAllLines(filePath, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        System.out.println("=== Hands-on 10: Generic Class + NIO.2 & Unit Testing ===");

        List<Produk<String, Double, Integer>> produkList = new ArrayList<>();
        produkList.add(new Produk<>("Laptop", 15000000.0, 10));
        produkList.add(new Produk<>("Mouse", 150000.0, 50));
        produkList.add(new Produk<>("Keyboard", 350000.0, 30));

        Path produkPath = Paths.get("data/produk_output.txt");

        try {
            simpanKeFile(produkPath, produkList);
            System.out.println("Data produk berhasil disimpan menggunakan NIO.2 ke " + produkPath);

            List<String> hasilBacaProduk = bacaDariFile(produkPath);
            System.out.println("\nIsi file " + produkPath + " (Nama,Harga,Stok):");
            for (String line : hasilBacaProduk) {
                System.out.println(" - " + line);
            }
        } catch (IOException e) {
            System.out.println("Gagal memproses file produk: " + e.getMessage());
        }

        System.out.println("\n--- Menyimpan Jenis Data Lain (Pelanggan & Transaksi) ---");

        List<Produk<Integer, String, Boolean>> pelangganList = new ArrayList<>();
        pelangganList.add(new Produk<>(1001, "Andi Pratama", true));
        pelangganList.add(new Produk<>(1002, "Siti Aminah", false));

        Path pelangganPath = Paths.get("data/pelanggan_output.txt");

        List<Produk<String, Double, Integer>> transaksiList = new ArrayList<>();
        transaksiList.add(new Produk<>("TRX-2026-01", 15150000.0, 2));
        transaksiList.add(new Produk<>("TRX-2026-02", 350000.0, 1));

        Path transaksiPath = Paths.get("data/transaksi_output.txt");

        try {
            simpanKeFile(pelangganPath, pelangganList);
            System.out.println("\nIsi file " + pelangganPath + " (ID,Nama,MemberAktif):");
            for (String line : bacaDariFile(pelangganPath)) {
                System.out.println(" - " + line);
            }

            simpanKeFile(transaksiPath, transaksiList);
            System.out.println("\nIsi file " + transaksiPath + " (KodeTransaksi,Total,JumlahItem):");
            for (String line : bacaDariFile(transaksiPath)) {
                System.out.println(" - " + line);
            }
        } catch (IOException e) {
            System.out.println("Gagal memproses file: " + e.getMessage());
        }
    }
}
