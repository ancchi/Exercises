
public class Main {

    /** Quelle: https://mein-javablog.de/java-utility-klassen/ */

    public static void main(String[] args) {
        Kreis kreisObjekt = new Kreis(20);

        // Konstante ausgeben
        System.out.println(UtilityKlasse.PI);

        // Übergabe des radius direkt:
        System.out.println(UtilityKlasse.berechneKreisFlaeche(20));

        // Übergabe eines Kreises:
        System.out.println(UtilityKlasse.berechneKreisFlaeche(kreisObjekt));

        /**
        Achtung!
         Theoretisch ist es möglich eine Instanz dieser Klasse zu bilden.
         Das ist aber weder nötig, weil alles in dieser Klasse statisch ist, noch erwünscht.
         Die Methoden auf Objekten der Klasse UtilityKlasse aufzurufen, würde keinen Sinn ergeben.
         Damit später keine Verwirrung dahingehend geschieht, kann man das unterbinden:

         -> der Default-Konstruktor der UtilityKlasse wird einfach private gemacht und andere Konstruktoren
         werden gar nicht erst angeboten
         */

        // UtilityKlasse utilClass = new UtilityKlasse(); // nicht erwünscht!!


    }
}
