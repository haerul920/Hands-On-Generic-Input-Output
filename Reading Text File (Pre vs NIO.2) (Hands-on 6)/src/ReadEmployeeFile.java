import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadEmployeeFile {
    public static void main(String[] args) {
        System.out.println("=== Hands-on 6: Reading Text File (NIO.2) ===");

        Path sourcePath = Paths.get("data/employees.txt");
        Path copyPath = Paths.get("data/copy_employees.txt");

        if (Files.notExists(sourcePath)) {
            System.out.println("Peringatan: File '" + sourcePath.toAbsolutePath() + "' tidak ditemukan!");
            return;
        }

        ArrayList<String> employeeList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(sourcePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                employeeList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
            return;
        }

        System.out.println("Berhasil membaca " + employeeList.size() + " baris dari " + sourcePath + ":");
        for (String emp : employeeList) {
            System.out.println(" - " + emp);
        }

        try {
            Files.write(copyPath, employeeList, StandardCharsets.UTF_8);
            System.out.println("\nData berhasil disalin ke file baru: " + copyPath);
        } catch (IOException e) {
            System.out.println("Gagal menulis ke file baru: " + e.getMessage());
        }
    }
}