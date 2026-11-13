import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class pengujian untuk memverifikasi fungsionalitas ProdukWriterNew (Hands-on 10).
 */
public class ProdukWriterTest {

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null && actual == null) return;
        if (expected != null && expected.equals(actual)) return;
        throw new AssertionError(message + " | Expected: <" + expected + "> but was: <" + actual + ">");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    // Test 1: Menguji pembuatan objek Produk<String, Double, Integer> dan toString()
    public void testProdukToString() {
        Produk<String, Double, Integer> p = new Produk<>("Laptop", 15000000.0, 10);
        assertEquals("Laptop," + 15000000.0 + ",10", p.toString(), "Format toString() Produk harus sesuai");
        assertEquals("Laptop", p.getAtribut1(), "Nama produk harus Laptop");
        assertEquals(15000000.0, p.getAtribut2(), "Harga produk harus 15000000.0");
        assertEquals(10, p.getAtribut3(), "Stok produk harus 10");
        System.out.println("[PASS] testProdukToString");
    }

    // Test 2: Menguji penulisan dan pembacaan kembali file dengan NIO.2 (Files.readAllLines())
    public void testSimpanDanBacaFileProduk() throws IOException {
        Path tempFile = Files.createTempFile("test_produk_", ".txt");
        try {
            List<Produk<String, Double, Integer>> list = new ArrayList<>();
            list.add(new Produk<>("Mouse", 150000.0, 50));
            list.add(new Produk<>("Keyboard", 350000.0, 30));

            ProdukWriterNew.simpanKeFile(tempFile, list);
            assertTrue(Files.exists(tempFile), "File output harus ada setelah disimpan");

            List<String> lines = ProdukWriterNew.bacaDariFile(tempFile);
            assertEquals(2, lines.size(), "Jumlah baris yang dibaca harus 2");
            assertEquals("Mouse,150000.0,50", lines.get(0), "Baris pertama harus sesuai");
            assertEquals("Keyboard,350000.0,30", lines.get(1), "Baris kedua harus sesuai");
            System.out.println("[PASS] testSimpanDanBacaFileProduk");
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }

    // Test 3: Menguji penyimpanan jenis data lain (Pelanggan)
    public void testSimpanDataPelanggan() throws IOException {
        Path tempFile = Files.createTempFile("test_pelanggan_", ".txt");
        try {
            List<Produk<Integer, String, Boolean>> pelangganList = new ArrayList<>();
            pelangganList.add(new Produk<>(101, "Budi", true));

            ProdukWriterNew.simpanKeFile(tempFile, pelangganList);
            List<String> lines = ProdukWriterNew.bacaDariFile(tempFile);

            assertEquals(1, lines.size(), "Jumlah baris pelanggan harus 1");
            assertEquals("101,Budi,true", lines.get(0), "Data pelanggan harus sesuai");
            System.out.println("[PASS] testSimpanDataPelanggan");
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Menjalankan Unit Testing Hands-on 10 ===");
        ProdukWriterTest tester = new ProdukWriterTest();
        try {
            tester.testProdukToString();
            tester.testSimpanDanBacaFileProduk();
            tester.testSimpanDataPelanggan();
            System.out.println("Semua Unit Test BERHASIL (3/3 passed)!");
        } catch (Exception | AssertionError e) {
            System.err.println("Unit Test GAGAL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

