import java.util.HashMap;
import java.util.Map;

/**
 * Created by afischer on 19/12/2016.
 */




public class GenericMethod {


    // https://www.tutorialspoint.com/java/java_generics.htm

    /**
     * Diese Methode kann die Elemente von mehreren Datentypen aufnehmen und ausgeben.
     */

    public <E> void printArray(E[] inputArray) { // warum statisch???
        for (E element : inputArray) {
            System.out.printf(" " + element);  // %s geht nicht - warum??
        }
        System.out.println();

        HashMap[] names1 = null;
        Map[] names2 = toArray1(names1);
        names2 = toArray2(names1);
        names2 = toArray3(names1);

    }

    /**
     * das was im Rückgabetyp als Generic steht kann auch nur durch die Methode angenommen werden
     * verschiedene Möglchkeiten der Schreibweise von generischen Methoden:
     */

    public <T> T[] toArray1(T[] a){  // hier ist der Typ völlig offen

        return null;
    }

    public <T extends Map> T[] toArray2(T[] a){  // mit extends Map wird der Typ eingeschränkt

        return null;
    }


    public Map[] toArray3(HashMap[] a){  // die übliche Schreibweise ist aber ohne Generics

        return null;
    }


    public static <T> T random (T m, T n) {
        return Math.random() > 0.5 ? m : n; // wenn die Zufallszahl > 0.5, gib m zurück, sonst gib n zurück
    }                                       // auf diese Weise wird ein Random für Strings fabriziert

}
