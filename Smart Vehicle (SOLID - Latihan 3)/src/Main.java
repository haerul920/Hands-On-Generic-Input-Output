// 1. Pemisahan interface menjadi spesifik sesuai kemampuan kendaraan (ISP)
interface Vehicle {
    void bergerak();
}

interface MesinVehicle {
    void startEngine();
}

interface BahanBakarVehicle {
    void isiBahanBakar();
}

interface BateraiVehicle {
    void isiBaterai();
}

// 2. Implementasi tiap jenis kendaraan hanya pada interface yang relevan (ISP, LSP & OCP)
class MobilListrik implements Vehicle, MesinVehicle, BateraiVehicle {
    @Override
    public void startEngine() {
        System.out.println("[Mobil Listrik] Menyalakan sistem motor listrik...");
    }

    @Override
    public void isiBaterai() {
        System.out.println("[Mobil Listrik] Mengisi baterai kendaraan listrik di charging station...");
    }

    @Override
    public void bergerak() {
        System.out.println("[Mobil Listrik] Melaju dengan tenang di jalan raya.");
    }
}

class MobilBensin implements Vehicle, MesinVehicle, BahanBakarVehicle {
    @Override
    public void startEngine() {
        System.out.println("[Mobil Bensin] Menyalakan mesin pembakaran internal...");
    }

    @Override
    public void isiBahanBakar() {
        System.out.println("[Mobil Bensin] Mengisi bahan bakar bensin di SPBU...");
    }

    @Override
    public void bergerak() {
        System.out.println("[Mobil Bensin] Berjalan di jalan raya.");
    }
}

// Sepeda tidak dipaksa memiliki startEngine(), isiBahanBakar(), atau isiBaterai()
class Sepeda implements Vehicle {
    @Override
    public void bergerak() {
        System.out.println("[Sepeda] Dikayuh berjalan di jalur sepeda (tanpa mesin & bahan bakar).");
    }
}

// 3. Controller bergantung pada abstraksi sehingga mudah menambah kendaraan baru (OCP & DIP)
class SmartVehicleManager {
    public void jalankanKendaraan(Vehicle vehicle) {
        vehicle.bergerak();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOLID Latihan 3: Smart Vehicle ===\n");

        MobilListrik tesla = new MobilListrik();
        tesla.startEngine();
        tesla.isiBaterai();

        System.out.println();

        MobilBensin avanza = new MobilBensin();
        avanza.startEngine();
        avanza.isiBahanBakar();

        System.out.println();

        Sepeda polygon = new Sepeda();

        // Menjalankan semua jenis kendaraan melalui abstraksi Vehicle (OCP & LSP)
        SmartVehicleManager manager = new SmartVehicleManager();
        manager.jalankanKendaraan(tesla);
        manager.jalankanKendaraan(avanza);
        manager.jalankanKendaraan(polygon);

        System.out.println("\n--- Jawaban Pertanyaan Latihan 3 ---");
        System.out.println("1. Prinsip SOLID yang dilanggar:");
        System.out.println("   - Interface Segregation Principle (ISP) & Single Responsibility Principle (SRP): Semua fitur (mesin, bensin, baterai) digabung dalam satu kelas/interface Vehicle.");
        System.out.println("   - Liskov Substitution Principle (LSP): Objek Sepeda yang dibuat dari Vehicle memiliki metode startEngine() padahal sepeda tidak bermesin, sehingga memicu anomali/error saat runtime.");
        System.out.println("   - Open-Closed Principle (OCP): Sulit menambah jenis kendaraan baru (misal Kapal/Pesawat/Skuter) tanpa mengubah kelas Vehicle.");
        System.out.println("2. Solusi sesuai Interface Segregation Principle (ISP):");
        System.out.println("   - Memecah kemampuan kendaraan menjadi interface kecil yang spesifik: `Vehicle` (bergerak), `MesinVehicle` (startEngine), `BahanBakarVehicle` (isiBahanBakar), dan `BateraiVehicle` (isiBaterai).");
        System.out.println("   - Kelas `MobilListrik`, `MobilBensin`, dan `Sepeda` hanya mengimplementasikan interface yang sesuai dengan fiturnya.");
        System.out.println("3. Cara membuat struktur fleksibel sesuai Open-Closed Principle (OCP):");
        System.out.println("   - Menggunakan abstraksi (`Vehicle`, dll.) sebagai kontrak dasar. Ketika ada kendaraan baru (misal `MotorListrik` atau `KapalLayar`), kita cukup membuat class baru yang mengimplementasikan interface terkait tanpa memodifikasi kode yang sudah ada.");
    }
}
