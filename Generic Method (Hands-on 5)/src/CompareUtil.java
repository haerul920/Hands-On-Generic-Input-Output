public class CompareUtil {
    public static <T extends Comparable<T>> boolean isEqual(T a, T b) {
        return a.compareTo(b) == 0;
    }

    public static void main(String[] args) {
        System.out.println("=== Hands-on 5: Generic Method ===");

        // Test case bawaan
        System.out.println("Integer (5, 5)           : " + isEqual(5, 5));
        System.out.println("String (\"Hello\", \"World\"): " + isEqual("Hello", "World"));

        // Tambahkan test case untuk Double dan Character
        System.out.println("Double (3.14, 3.14)      : " + isEqual(3.14, 3.14));
        System.out.println("Double (3.14, 2.71)      : " + isEqual(3.14, 2.71));
        System.out.println("Character ('A', 'A')     : " + isEqual('A', 'A'));
        System.out.println("Character ('A', 'B')     : " + isEqual('A', 'B'));

        // Penjelasan perbedaan antara generic class dan generic method
        System.out.println("\n--- Perbedaan Generic Class dan Generic Method ---");
        System.out.println("1. Cakupan Parameter Tipe (Scope):");
        System.out.println("   - Generic Class: Parameter tipe <T> dideklarasikan pada level class (misal class Cell<T>)");
        System.out.println("     dan berlaku untuk seluruh atribut serta non-static method di dalam class tersebut.");
        System.out.println("   - Generic Method: Parameter tipe <T> dideklarasikan tepat sebelum return type method");
        System.out.println("     (misal public static <T> boolean isEqual(T a, T b)) dan hanya berlaku di dalam method itu saja.");
        System.out.println("2. Penggunaan pada Method Static:");
        System.out.println("   - Generic Method dapat berupa static method (seperti CompareUtil.isEqual),");
        System.out.println("     sedangkan parameter tipe milik Generic Class tidak bisa digunakan langsung oleh static method.");
        System.out.println("3. Instansiasi:");
        System.out.println("   - Generic Class mengharuskan penentuan tipe saat pembuatan objek: new Cell<String>().");
        System.out.println("   - Generic Method dapat berada di dalam class biasa (non-generic) dan tipe datanya");
        System.out.println("     otomatis dikenali (type inference) dari argumen saat method dipanggil.");
    }
}

