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
    }

}
