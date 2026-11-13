import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileCopyNew {
    private static final Path LOG_PATH = Paths.get("data/log.txt");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static void writeLog(List<String> logs, String message) {
        String entry = "[" + LocalDateTime.now().format(FORMATTER) + "] " + message;
        logs.add(entry);
        System.out.println(entry);
    }

    public static void main(String[] args) {
        System.out.println("=== Hands-on 7: Write and Copy Files (NIO.2) ===");

        Path source = Paths.get("data/report.txt");
        Path backup = Paths.get("data/backup/report.txt");
        List<String> logEntries = new ArrayList<>();

        try {
            if (Files.notExists(source.getParent())) {
                Files.createDirectories(source.getParent());
            }

            // Menulis isi laporan ke file sumber
            Files.write(source, List.of("Report Generated", "Status: OK"), StandardCharsets.UTF_8);
            writeLog(logEntries, "INFO: File sumber 'data/report.txt' berhasil dibuat.");

            // Tambahkan pengecekan file sebelum menyalin (Files.exists())
            if (Files.exists(source)) {
                writeLog(logEntries, "INFO: Pengecekan Files.exists(source) bernilai TRUE. Melanjutkan proses salin.");

                if (Files.notExists(backup.getParent())) {
                    Files.createDirectories(backup.getParent());
                    writeLog(logEntries, "INFO: Direktori '" + backup.getParent() + "' berhasil dibuat.");
                }

                Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);
                writeLog(logEntries, "SUCCESS: Backup berhasil dibuat di '" + backup + "'.");
            } else {
                writeLog(logEntries, "ERROR: File sumber '" + source + "' tidak ditemukan! Penyalinan dibatalkan.");
            }
        } catch (IOException e) {
            writeLog(logEntries, "ERROR: Terjadi kesalahan I/O - " + e.getMessage());
        } finally {
            // Buat log hasil operasi ke file log.txt
            try {
                if (Files.notExists(LOG_PATH.getParent())) {
                    Files.createDirectories(LOG_PATH.getParent());
                }
                Files.write(LOG_PATH, logEntries, StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Log operasi berhasil disimpan ke: " + LOG_PATH);
            } catch (IOException e) {
                System.out.println("Gagal menulis log ke log.txt: " + e.getMessage());
            }
        }
    }
}

