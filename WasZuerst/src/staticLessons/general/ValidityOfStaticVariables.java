package staticLessons.general;

/**
 * Created by afischer on 08/02/2017.
 */
public class ValidityOfStaticVariables {


    static String staticVariable;
    String instanceVariable;

    public ValidityOfStaticVariables(String instanceVariable) {
        System.out.println("\nKonstruktor1: ");
                this.instanceVariable = instanceVariable;
        System.out.println(instanceVariable + " " + staticVariable);

    }


    public ValidityOfStaticVariables(String instanceVariable, String staticVariable) {  // statisches bla wird überschrieben - sollte nicht gemacht werden!
        System.out.println("\nKonstruktor2: ");
        this.instanceVariable = instanceVariable;
        this.staticVariable = staticVariable;
        System.out.println(instanceVariable + " " + staticVariable);

    }

    /**
     * der static Initializer wird als erstes (vor der Main-Methode) ausgewertet
     * hier können nur statische Variablen initialisiert werden
     */

    static{
        System.out.println("\nstatic Initializer:");
        staticVariable = "static1";

        ValidityOfStaticVariables validityOfStaticVariables = new ValidityOfStaticVariables("instance2");  // Inhalt von Konstruktor1 wird ausgegeben - blubb2 null
        System.out.println(validityOfStaticVariables.instanceVariable + " " + staticVariable); // hier hat bla einen Wert erhalten - blubb2 bla
        ValidityOfStaticVariables validityOfStaticVariables1 = new ValidityOfStaticVariables("instance3", staticVariable); // Inhalt von Konstruktor2 wird ausgegeben - blubb3 bla1


    }  // static Initializer


    static {
        System.out.println("\nZweiter static Block:");
        staticVariable = "static2";
        System.out.println(staticVariable);
    }

    public static void main(String[] args) {

        /**
         * Wenn der static Initializer existiert, dann werden
         * staticLessons.general.ValidityOfStaticVariables.bla = "Auto";  und
         * staticLessons.general.ValidityOfStaticVariables wasZuerst = new staticLessons.general.ValidityOfStaticVariables("blubb1"); aus der Main-Methode erst ausgewertet,
         * nachdem der static Initializer ausgewertet wurde.
         * Selbst dann, wenn in der Main-Methode nichts steht, wird der static Initializer ausgewertet.
         *
         */
    //        System.out.println("Main-Methode:");
    //        ValidityOfStaticVariables.staticVariable = "Auto";
    //        ValidityOfStaticVariables wasZuerst = new ValidityOfStaticVariables("blubb1");  // mit "new staticLessons.general.ValidityOfStaticVariables" wird der Konstruktor1 aufgerufen und abgearbeitet - blubb1 Auto
    //        System.out.println(ValidityOfStaticVariables.staticVariable);  // dann wird sout ausgeführt - Auto
    //
    //        ValidityOfStaticVariables wasZuerst1 = new ValidityOfStaticVariables("hallo"); // Konstruktor1 mit Inhalt - hallo Auto
    //        System.out.println(ValidityOfStaticVariables.staticVariable); // Ausgabe - Auto

        /**
         * Eine weitere Eigenschaft vom static Initializer ist, dass ein static Block nur einmal aufgerufen werden kann, während
         * ein non-static Block mit jeder neuen Intitialisierung der Klasse aufgerufen wird:
         */

    }

}


