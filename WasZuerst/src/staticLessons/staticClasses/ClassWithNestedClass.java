package staticLessons.staticClasses;

/**
 * Created by afischer on 09/02/2017.
 */
public class ClassWithNestedClass {

    /** Toplevel-Klassen können nicht statisch sein */
    /** Toplevel-Klassen können statische Variablen und Methoden enhalten */

    static class StaticNestedClass {
        static int staticVariableInNestedClass = 44;
        static final int finalStaticVariableInNestedClass = 33;

        static void staticMethod() {
            System.out.println("Ich befinde mich in einer statischen Methode in einer statischen inneren Klasse.");
        }
    }


    public class NestedClass {

        /** Nichtstatische innere Klassen können keine statischen Methoden oder Variablen enthalten */

        int instanceVariableInNestedClass = 11;

        void instanceMethod() {
            System.out.println("Ich befinde mich in einer normalen Methode in einer normalen inneren Klasse.");
        }

    }


    public static void main(String[] args) {

        /** Ist die Main-Methode leer, erscheint keine Ausgabe. D.h. die Klassen, auch, wenn sie static sind, werden
         * nicht automatisch mit dem Aufruf der Klasse ausgeführt, sondern müssen explizit aufgerufen werden. */

        /** Die statischen Variablen und Methoden können mit vorangestellter statischer Klasse direkt aufgerufen werden. */

        System.out.println("\nAuswertung der statischen (main-)Methode:");
        StaticNestedClass.staticVariableInNestedClass = 55;
        System.out.println(StaticNestedClass.staticVariableInNestedClass);
//        StaticNestedClass.finalStaticVariableInNestedClass = 66; // geht nicht, weil final (Kompilierfehler wird angezeigt)
        System.out.println(StaticNestedClass.finalStaticVariableInNestedClass);
        StaticNestedClass.staticMethod();

        /** Nicht statische Variablen und Methoden können in einem statischen Kontext (main-Methode) nicht referenziert werden.
         * Deswegen muss eine nicht-statische Methode oder ein nicht-statischer Konstruktor erstellt werden, um auf die Elemente
         * zugreifen zu können. Die Methode oder der Konstruktor können dann in der statischen Methode über ein Objekt der
         * Oberklasse aufgerufen werden: */

        ClassWithNestedClass classWithNestedClass = new ClassWithNestedClass();
        classWithNestedClass.nonStaticMethodForNonstaticNestedClass();

        /** Auch die statische Klasse kann in einer nicht-statische Methode verwendet werden */
        ClassWithNestedClass classWithNestedClass1 = new ClassWithNestedClass();
        classWithNestedClass.nonStaticMethodForStaticNestedClass();
    }

    public void nonStaticMethodForNonstaticNestedClass() {
        System.out.println("\nAuswertung der nicht-statischen Methode für die nicht statische innere Klasse:");
        NestedClass nestedClassObject = new NestedClass();
        /** um auf eine Variable oder eine Methode zuzugreifen, benötigt man ein Objekt */
        System.out.println(nestedClassObject.instanceVariableInNestedClass);
        nestedClassObject.instanceMethod();
    }

    public void nonStaticMethodForStaticNestedClass() {
        System.out.println("\nAuswertung der nicht-statischen Methode für die statische innere Klasse:");
        System.out.println(StaticNestedClass.finalStaticVariableInNestedClass);
        System.out.println(StaticNestedClass.staticVariableInNestedClass);
        StaticNestedClass.staticMethod();
    }

    public static void staticOuterMethod() {
        /**  */
        System.out.println("\nIch befinde mich in einer äusseren statischen Methode der toplevel class.");
        System.out.println("Ausgabe ");
        ClassWithNestedClass.StaticNestedClass.staticMethod();
        System.out.println(StaticNestedClass.finalStaticVariableInNestedClass);

        ClassWithNestedClass classWithNestedClass = new ClassWithNestedClass();
        classWithNestedClass.nonStaticMethodForNonstaticNestedClass();
        classWithNestedClass.nonStaticMethodForStaticNestedClass();

    }

}
