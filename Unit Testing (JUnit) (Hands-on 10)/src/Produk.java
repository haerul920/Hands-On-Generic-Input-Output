public class Produk<T, U, V> {
    private T atribut1;
    private U atribut2;
    private V atribut3;

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

