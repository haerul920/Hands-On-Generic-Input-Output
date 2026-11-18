enum AccountType {
    SAVINGS("SA", 2.5),
    CREDIT("CR", 15.0),
    DEPOSIT("DP", 5.5);

    private String code;
    private double interestRate;

    private AccountType(String code, double interestRate) {
        this.code = code;
        this.interestRate = interestRate;
    }

    public String getCode() {
        return code;
    }

    public double getInterestRate() {
        return interestRate;
    }
}

public class EnumConstructorDemo {
    public static void main(String[] args) {
        System.out.println("=== Hands-on 2: Enum dengan Konstruktor ===");

        for (AccountType type : AccountType.values()) {
            System.out.printf("Nama: %-10s | Kode: %-4s | Suku Bunga: %.2f%%%n",
                    type.name(), type.getCode(), type.getInterestRate());
        }
    }
}

