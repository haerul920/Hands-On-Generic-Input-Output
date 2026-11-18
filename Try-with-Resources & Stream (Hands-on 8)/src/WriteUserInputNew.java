import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WriteUserInputNew {
    public static void main(String[] args) {
        System.out.println("=== Hands-on 8: Try-with-Resources & Stream ===");

        Path outputPath = Paths.get("data/user_input.txt");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            if (Files.notExists(outputPath.getParent())) {
                Files.createDirectories(outputPath.getParent());
            }
        } catch (IOException e) {
            System.out.println("Error membuat direktori data: " + e.getMessage());
            return;
        }

        try (Scanner sc = new Scanner(System.in);
             BufferedWriter bw = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8)) {

            System.out.println("Ketik teks untuk disimpan ke file (ketik 'exit' untuk berhenti):");

            while (true) {
                System.out.print("Enter text: ");
                if (!sc.hasNextLine()) {
                    break;
                }
                String text = sc.nextLine();

                if (text.equalsIgnoreCase("exit")) {
                    System.out.println("Perintah 'exit' diterima. Menutup program...");
                    break;
                }

                String timestamp = LocalDateTime.now().format(formatter);
                String formattedLine = "[" + timestamp + "] " + text;

                bw.write(formattedLine);
                bw.newLine();
            }

            System.out.println("Saved! Semua data berhasil disimpan di: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}