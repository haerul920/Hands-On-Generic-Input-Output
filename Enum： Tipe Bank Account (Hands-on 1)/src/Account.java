enum AccountType {
    SAVINGS {
        @Override
        public String toString() {
            return "Savings Account (Rekening Tabungan)";
        }
    },
    CREDIT {
        @Override
        public String toString() {
            return "Credit Account (Rekening Kredit)";
        }
    },
    DEPOSIT {
        @Override
        public String toString() {
            return "Deposit Account (Rekening Deposito)";
        }
    }
}

public class Account {
    private AccountType type;

    public Account(AccountType type) {
        this.type = type;
    }

    public AccountType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Account [Tipe = " + type.name() + ", Deskripsi = " + type.toString() + "]";
    }

    public static void main(String[] args) {
        System.out.println("=== Hands-on 1: Enum: Tipe Bank Account ===");

        // Uji di main() dengan mencetak semua tipe enum
        System.out.println("\nDaftar Semua Tipe Enum:");
        for (AccountType type : AccountType.values()) {
            System.out.println("- " + type.name() + " -> " + type);
        }

        // Uji pembuatan objek Account untuk setiap tipe
        System.out.println("\nUji Objek Account:");
        Account acc1 = new Account(AccountType.SAVINGS);
        Account acc2 = new Account(AccountType.CREDIT);
        Account acc3 = new Account(AccountType.DEPOSIT);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println(acc3);
    }
}

