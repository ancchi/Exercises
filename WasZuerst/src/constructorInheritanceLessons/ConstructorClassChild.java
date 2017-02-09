package constructorInheritanceLessons;

/**
 * Created by afischer on 09/02/2017.
 */
public class ConstructorClassChild extends ConstructorClass {

    public ConstructorClassChild() {
        System.out.println("Ausgabe des Konstruktors der Unterklasse.");
    }


    public static void main(String[] args) {

        /**
         * Bei der Initialisierung der ChildKlasse wird sowohl der Konstruktor der Oberklasse
         * als auch der Konstruktor der Unterklasse aufgerufen.
         */

        ConstructorClass constructorClass = new ConstructorClassChild();
        System.out.println("");
        ConstructorClassChild constructorClassChild1 = new ConstructorClassChild();

        System.out.println("\n\n");

        /**
         * Bei der Initialisierung des Konstruktors der Oberklasse in der Unterklasse wird nur der
         * Konstruktor der Oberklasse aufgerufen.
         */

        ConstructorClass constructorClass1 = new ConstructorClass();
    }

}
