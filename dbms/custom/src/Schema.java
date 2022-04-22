package dbms.custom.src;

public class Schema<T> {
    private String id;
    private T item;

    public Schema(String id, T item) {
        this.id = id;
        this.item = item;
    }

    public boolean equals(Schema<T> other) {
        return this.id.equals(other.id) && this.item.equals(other.item);
    }
}
