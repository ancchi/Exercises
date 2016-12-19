import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by afischer on 13/12/2016.
 */
public class ListeUndMain {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("Tom", "Jones"),
                new Person("James", "Brown"),
                new Person("Carlos", "Santana")
        );

        /**
         * sort(Obj o) wendet die überschriebenen Methoden compareTo(Obj o) und toString() des Objekts an
         * und gibt die Liste sortiert und formatiert!!! wieder zurück
         * sodass sie sortiert und formatiert zwischengespeichert wurde und ausgegeben werden kann
         */


        Collections.sort(persons);
        System.out.println(persons);
    }
}