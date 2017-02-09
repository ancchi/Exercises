package staticLessons.inheritance;

/**
 * Created by afischer on 09/02/2017.
 */
public class StaticBlockInheritance {

    static{

        System.out.println("This is a static Block in the parent class.");
    }

    public void method() {
        System.out.println("That is just a simple method in the parent class.");
    }


    public static void staticMethod() {
        System.out.println("That is a static method in the child class.");
    }


    public static void main(String [] args) {
        /**
         * Bei einer leeren main-Methode in der Oberklasse wird nur die Oberklasse ausgeführt.
         * Das sieht man an der Ausgabe der static-Blöcke, die sich wie statische Konstruktoren verhalten
         */

        /** Aufruf aus Oberklasse: */

        // nur die Oberklasse wird bei der Initialisierung mit new aufgerufen (Ausgabe des static-Blocks)
        StaticBlockInheritance staticBlockInheritance = new StaticBlockInheritance();


        // Oberklasse und Unterklasse werden aufgerufen (Ausgabe der static-Blocks)
//        StaticBlockInheritance staticBlockInheritance = new StaticBlockInheritanceChild();

        // Oberklasse und Unterklasse werden aufgerufen (Ausgabe der static-Blocks)
//        StaticBlockInheritanceChild staticBlockInheritanceChild = new StaticBlockInheritanceChild();

    }

}
