public class Cell<T> {
    private T data;

    public void setValue(T data) {
        this.data = data;
    }

    public T getValue() {
        return data;
    }

    public void displayType() {
        if (data != null) {
            System.out.println("Tipe data: " + data.getClass().getName() + " | Nilai: " + data);
        } else {
            System.out.println("Tipe data: null");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Hands-on 3: Generic Class ===");

        // Buat Cell<Integer> dan Cell<String> di main()
        Cell<Integer> intCell = new Cell<>();
        intCell.setValue(100);

        Cell<String> stringCell = new Cell<>();
        stringCell.setValue("Belajar Java Generics");

        // Menampilkan nilai dan tipe data dengan displayType()
        intCell.displayType();
        stringCell.displayType();

        // Penjelasan keuntungan penggunaan generic type safety
        System.out.println("\n--- Keuntungan Penggunaan Generic Type Safety ---");
        System.out.println("1. Deteksi Kesalahan Saat Kompilasi (Compile-Time Type Checking):");
        System.out.println("   Kesalahan tipe data langsung terdeteksi saat kompilasi (misal memasukkan String ke Cell<Integer>),");
        System.out.println("   sehingga mencegah ClassCastException saat runtime.");
        System.out.println("2. Menghilangkan Kebutuhan Type Casting Manual:");
        System.out.println("   Kita tidak perlu melakukan casting eksplisit seperti (Integer) cell.getValue().");
        System.out.println("3. Reusabilitas Kode (Code Reusability):");
        System.out.println("   Satu class Cell<T> dapat digunakan untuk berbagai tipe data (Integer, String, Double, dll).");
    }
}

