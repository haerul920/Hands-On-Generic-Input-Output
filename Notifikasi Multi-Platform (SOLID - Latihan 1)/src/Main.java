// 1. Interface umum yang spesifik (ISP & DIP)
interface Notifier {
    void send(String message);
}

// 2. Implementasi masing-masing platform (SRP & OCP)
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim Email: " + message);
    }
}

class SMSNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim SMS: " + message);
    }
}

class WhatsAppNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim WhatsApp: " + message);
    }
}

// Penambahan kanal baru (Telegram & Push Notification) TANPA mengubah kelas lama (OCP)
class TelegramNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim Telegram: " + message);
    }
}

class PushNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Mengirim Push Notification: " + message);
    }
}

// 3. Service tingkat tinggi bergantung pada abstraksi Notifier (DIP)
class NotificationService {
    private final Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void notifyUser(String message) {
        notifier.send(message);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOLID Latihan 1: Notifikasi Multi-Platform ===\n");

        // Pengiriman pesan ke berbagai platform tanpa memodifikasi NotificationService
        NotificationService emailService = new NotificationService(new EmailNotifier());
        emailService.notifyUser("Halo, ini email test!");

        NotificationService smsService = new NotificationService(new SMSNotifier());
        smsService.notifyUser("Ini SMS test!");

        NotificationService waService = new NotificationService(new WhatsAppNotifier());
        waService.notifyUser("Ini pesan WhatsApp test!");

        // Uji penambahan kanal baru (Telegram & Push Notification) sesuai OCP
        NotificationService telegramService = new NotificationService(new TelegramNotifier());
        telegramService.notifyUser("Pengumuman akademik via Telegram!");

        NotificationService pushService = new NotificationService(new PushNotifier());
        pushService.notifyUser("Notifikasi baru di aplikasi mobile kampus!");

        System.out.println("\n--- Jawaban Pertanyaan Latihan 1 ---");
        System.out.println("1. Prinsip SOLID yang dilanggar pada kode awal:");
        System.out.println("   - Single Responsibility Principle (SRP): Kelas NotificationService menangani semua logika pengiriman (Email, SMS, WhatsApp) sekaligus.");
        System.out.println("   - Open-Closed Principle (OCP): Menambah platform baru (misal Telegram/Push) mengharuskan modifikasi kelas NotificationService.");
        System.out.println("   - Interface Segregation Principle (ISP) & Dependency Inversion Principle (DIP): Klien terikat langsung pada satu kelas gemuk berisi banyak metode spesifik platform dan bukan pada abstraksi.");
        System.out.println("2. Solusi sesuai OCP dan ISP:");
        System.out.println("   - Membuat interface ringkas dan spesifik `Notifier` dengan metode `send(String message)` (ISP).");
        System.out.println("   - Memisahkan setiap kanal ke kelas sendiri (`EmailNotifier`, `SMSNotifier`, `WhatsAppNotifier`, `TelegramNotifier`) sehingga penambahan kanal baru cukup membuat kelas baru tanpa mengubah kode lama (OCP).");
    }
}
