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

class Sepeda implements Vehicle {
    @Override
    public void bergerak() {
        System.out.println("[Sepeda] Dikayuh berjalan di jalur sepeda (tanpa mesin & bahan bakar).");
    }
}

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

        SmartVehicleManager manager = new SmartVehicleManager();
        manager.jalankanKendaraan(tesla);
        manager.jalankanKendaraan(avanza);
        manager.jalankanKendaraan(polygon);
    }
}
