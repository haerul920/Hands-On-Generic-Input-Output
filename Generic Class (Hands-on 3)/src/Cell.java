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

        Cell<Integer> intCell = new Cell<>();
        intCell.setValue(100);

        Cell<String> stringCell = new Cell<>();
        stringCell.setValue("Belajar Java Generics");

        intCell.displayType();
        stringCell.displayType();

    }
}

