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

class GradeReportPrinter {
    public void cetakLaporan(String nama, double nilai) {
        System.out.println("Laporan Nilai Mahasiswa: " + nama + " = " + nilai);
    }
}

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
    }
}
