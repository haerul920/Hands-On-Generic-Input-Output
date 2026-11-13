public class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void showTypes() {
        System.out.println("Tipe: " + first.getClass().getName() + " & " + second.getClass().getName());
    }

    // Method swap() untuk menukar nilai (mengembalikan Pair<T2, T1>)
    public Pair<T2, T1> swap() {
        return new Pair<>(this.second, this.first);
    }

    @Override
    public String toString() {
        return "Pair(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        System.out.println("=== Hands-on 4: Generic Class Multi-Tipe ===");

        // Buat Pair<Integer, String>
        Pair<Integer, String> pair1 = new Pair<>(101, "Budi Santoso");
        System.out.println("Sebelum swap pair1 : " + pair1);
        pair1.showTypes();

        Pair<String, Integer> swappedPair1 = pair1.swap();
        System.out.println("Sesudah swap pair1 : " + swappedPair1);
        swappedPair1.showTypes();

        System.out.println();

        // Buat Pair<Double, Boolean>
        Pair<Double, Boolean> pair2 = new Pair<>(98.5, true);
        System.out.println("Sebelum swap pair2 : " + pair2);
        pair2.showTypes();

        Pair<Boolean, Double> swappedPair2 = pair2.swap();
        System.out.println("Sesudah swap pair2 : " + swappedPair2);
        swappedPair2.showTypes();
    }
}

