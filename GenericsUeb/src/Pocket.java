/**
 * Created by afischer on 08/12/2016.
 */
public class Pocket<T> {  // Generischer Typ, T ist eine Typvariable

    private T value;
    public Pocket() {}

    public Pocket(T value) {
        this.value = value;
    }


    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public boolean isEmpty() {
        return value != null;
    }

    public void empty() {
        value = null;
    }


    @Override
    public String toString() {
        return value.toString();
    }

}
