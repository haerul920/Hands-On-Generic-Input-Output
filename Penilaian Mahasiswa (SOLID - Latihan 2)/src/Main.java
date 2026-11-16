// 1. Strategi perhitungan nilai (OCP & LSP)
interface GradingStrategy {
    double calculate(double score);
}

class TugasGrading implements GradingStrategy {
    @Override
    public double calculate(double score) {
        return score * 0.3;
    }
}

class UtsGrading implements GradingStrategy {
    @Override
    public double calculate(double score) {
        return score * 0.3;
    }
}

class UasGrading implements GradingStrategy {
    @Override
    public double calculate(double score) {
        return score * 0.4;
    }
}

// 2. Pemisahan Tanggung Jawab sesuai Single Responsibility Principle (SRP)

// Tanggung Jawab 1: Hanya menghitung nilai akhir mahasiswa
class GradeCalculator {
    private final GradingStrategy tugasStrategy = new TugasGrading();
    private final GradingStrategy utsStrategy = new UtsGrading();
    private final GradingStrategy uasStrategy = new UasGrading();

    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        return tugasStrategy.calculate(tugas)
             + utsStrategy.calculate(uts)
             + uasStrategy.calculate(uas);
    }
}

// Tanggung Jawab 2: Hanya mencetak/menampilkan laporan nilai
class GradeReportPrinter {
    public void cetakLaporan(String nama, double nilai) {
        System.out.println("Laporan Nilai Mahasiswa: " + nama + " = " + nilai);
    }
}

// Tanggung Jawab 3: Hanya menyimpan data nilai ke penyimpanan/database
class GradeRepository {
    public void simpanDatabase(String nama, double nilai) {
        System.out.println("Menyimpan ke database: " + nama + " = " + nilai);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOLID Latihan 2: Penilaian Mahasiswa ===\n");

        GradeCalculator calculator = new GradeCalculator();
        GradeReportPrinter printer = new GradeReportPrinter();
        GradeRepository repository = new GradeRepository();

        double nilai = calculator.hitungNilaiAkhir(80, 85, 90);
        printer.cetakLaporan("Andi", nilai);
        repository.simpanDatabase("Andi", nilai);

        System.out.println("\n--- Jawaban Pertanyaan Latihan 2 ---");
        System.out.println("1. Prinsip SOLID yang dilanggar:");
        System.out.println("   - Single Responsibility Principle (SRP): Kelas StudentGrader memiliki 3 tanggung jawab berbeda sekaligus (menghitung nilai, mencetak laporan, dan menyimpan ke database).");
        System.out.println("   - Open-Closed Principle (OCP): Komponen perhitungan nilai terkunci di satu metode sehingga sulit diperluas jika kebijakan bobot/komponen berubah.");
        System.out.println("2. Solusi sesuai Single Responsibility Principle (SRP):");
        System.out.println("   - Memecah StudentGrader menjadi tiga kelas terpisah yang masing-masing fokus pada satu tanggung jawab:");
        System.out.println("     a) `GradeCalculator` (khusus logika perhitungan nilai)");
        System.out.println("     b) `GradeReportPrinter` (khusus pencetakan laporan nilai)");
        System.out.println("     c) `GradeRepository` (khusus penyimpanan data ke database)");
    }
}
