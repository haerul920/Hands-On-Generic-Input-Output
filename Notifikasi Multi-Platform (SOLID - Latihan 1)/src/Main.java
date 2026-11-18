interface Notifier {
    void send(String message);
}

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

        NotificationService emailService = new NotificationService(new EmailNotifier());
        emailService.notifyUser("Halo, ini email test!");

        NotificationService smsService = new NotificationService(new SMSNotifier());
        smsService.notifyUser("Ini SMS test!");

        NotificationService waService = new NotificationService(new WhatsAppNotifier());
        waService.notifyUser("Ini pesan WhatsApp test!");

        NotificationService telegramService = new NotificationService(new TelegramNotifier());
        telegramService.notifyUser("Pengumuman akademik via Telegram!");

        NotificationService pushService = new NotificationService(new PushNotifier());
        pushService.notifyUser("Notifikasi baru di aplikasi mobile kampus!");
    }
}
