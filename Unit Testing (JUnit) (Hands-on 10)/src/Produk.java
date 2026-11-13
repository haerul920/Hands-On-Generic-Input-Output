/**
 * Generic Class Produk<T, U, V> dengan atribut ketiga (misal stok bertipe Integer,
 * atau dapat digunakan untuk menyimpan data Pelanggan / Transaksi).
 */
public class Produk<T, U, V> {
    private T atribut1; // Nama Produk / ID Pelanggan / ID Transaksi
    private U atribut2; // Harga / Nama Pelanggan / Nominal Transaksi
    private V atribut3; // Stok (Integer) / Status / Metode Pembayaran

    public Produk(T atribut1, U atribut2, V atribut3) {
        this.atribut1 = atribut1;
        this.atribut2 = atribut2;
        this.atribut3 = atribut3;
    }

    public T getAtribut1() {
        return atribut1;
    }

    public U getAtribut2() {
        return atribut2;
    }

    public V getAtribut3() {
        return atribut3;
    }

    @Override
    public String toString() {
        return atribut1 + "," + atribut2 + "," + atribut3;
    }
}

