import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    Employee(String n, int a) {
        name = n;
        age = a;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + "}";
    }
}

public class SerializeDemo {

    public static void serialize(Object obj, String filename) {
        try {
            Path path = Paths.get(filename);
            if (path.getParent() != null && Files.notExists(path.getParent())) {
                Files.createDirectories(path.getParent());
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(obj);
                System.out.println("Serialized successfully to " + filename);
            }
        } catch (IOException ex) {
            System.out.println("Error serializing: " + ex.getMessage());
        }
    }

    public static Object deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserializing: " + ex.getMessage());
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        System.out.println("=== Hands-on 9: Serialization ===");

        Employee e1 = new Employee("John", 30);
        serialize(e1, "data/emp.ser");

        Employee restoredSingle = (Employee) deserialize("data/emp.ser");
        if (restoredSingle != null) {
            System.out.println("Deserialized single object: " + restoredSingle.name + ", " + restoredSingle.age);
        }

        System.out.println("\n--- Uji dengan Beberapa Objek Berbeda ---");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 30));
        employees.add(new Employee("Alice", 25));
        employees.add(new Employee("Bob", 40));
        employees.add(new Employee("Siti", 28));

        serialize(employees, "data/employees_list.ser");

        List<Employee> restoredList = (List<Employee>) deserialize("data/employees_list.ser");
        if (restoredList != null) {
            System.out.println("Deserialized multiple objects:");
            for (Employee emp : restoredList) {
                System.out.println(" - " + emp);
            }
        }
    }
}

