/**
 *
 * Quelle: https://mein-javablog.de/java-utility-klassen/
 *
 * Was ist alles nötig für die Umsetzung einer Hilfsklasse?
 * Drei Dinge benötigt jede Utility-Klasse.

 * 1. Die Klasse muss vom kompletten Programm genutzt werden können.
 * 2. Außerdem müssen die Methoden und Konstanten für alle Objekte und alle Programmteile gelten.
 * 3. Es muss verhindert werden, dass andere Klassen Objekte aus dieser Klasse erzeugen können.
 *
 * Beispiel: ein Tafelwerk für die Mathematik
 */

// die Klasse muss public sein
public class UtilityKlasse {
    // die Konstanten müssen public, final und static sein
    public final static double PI = 3.14159265359; // Kreiszahl



    // Methoden müssen statisch sein (nicht public)
    static double berechneKreisFlaeche(double radius) {
        double kreisFlaeche = PI * (radius * radius);
        return kreisFlaeche;
    }

    static double berechneKreisFlaeche(Kreis kreis) {
        double flaecheKreisObjekt = PI * (kreis.getRadius() * kreis.getRadius());
        return flaecheKreisObjekt;
    }

    // der Default-Konstruktor wird private gemacht, wodurch jegliche Instanziierung
    // in anderen Klassen verhindert wird
    private UtilityKlasse() {

    }
}
