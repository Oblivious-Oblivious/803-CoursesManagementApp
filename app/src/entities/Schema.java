package app.src.entities;

import java.io.Serializable;

/* TODO Look into implementing a generic schema object that inherits
    having an id instead of implementing an id-object pair */
public class Schema<T> implements Serializable {
    private String id;
    private T item;

    public Schema(String id, T item) {
        this.id = id;
        this.item = item;
    }

    public T value() {
        return this.item;
    }

    public boolean equals(Schema<T> other) {
        return this.id.equals(other.id) && this.item.equals(other.item);
    }

    public String get_id() {
        return this.id;
    }
}
