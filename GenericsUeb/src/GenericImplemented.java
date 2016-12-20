/**
 * Created by afischer on 20/12/2016.
 */
public final class GenericImplemented extends Number implements Comparable<GenericImplemented> {

    int a;
    int b;

    public GenericImplemented(GenericImplemented a, GenericImplemented b) {
        this.a = a.intValue();
        this.b = b.intValue();
    }


    @Override
    public int compareTo(GenericImplemented o) {  // wie wird compareTo() aufgerufen, warum geht x.compareTo(y) nicht???
        this.b = o.intValue();
        return a - b;
    }


    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
