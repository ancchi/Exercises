package de.deutschepost.epost.servlet.verification;

import de.deutschepost.epost.servlet.model.Address;

import java.util.regex.Pattern;

/**
 * Created by afischer on 14/02/2017.
 */
public class Verify {

    // Vorname, Nachname: Buchstaben, keine Sonderzeichen ausser Leerzeichen, keine Zahlen
    // Land: nur Buchstaben, keine Sonderzeichen ausser Leerzeichen, keine Zahlen
    // Ort: nur Buchstaben, keine Sonderzeichen ausser Leerzeichen, keine Zahlen
    // Strasse: Buchstaben, keine Sonderzeichen ausser Leerzeichen, Zahlen sind erlaubt


    public boolean proveInput(Address address) {
        boolean proved = false;
        if (
                proveForOnlyLetters(address.getPrename()) &&
                        proveForOnlyLetters(address.getLastName()) &&
                        proveForOnlyLetters(address.getStreet()) &&
                        proveForNoSpecialCharacters(address.getStreetNumber()) &&
                        verifyPLZ_IfFiveNumbersOnly(address.getPostCode()) &&
                        proveForOnlyLetters(address.getLocation())
                ) {
            proved = true;
        }
        return proved;
    }


    private boolean proveForOnlyLetters(CharSequence input) {  // String implements the Interface CharSequence -> kein Casting in diese Richtung nötig
        boolean prove;
        // ?i ist für Pattern.Case_Insensitive
        // X? - X darf einmal oder keinnmal vorhanden sein
        // [ \t] - Leerzeichen
        //(wort1 mindestens 1mal mit leerzeichen einmal oder keinmal und bindestrich einmal oder keinmal) beliebig oft wiederholbar plus wort2
        if (/**Pattern.matches("(?i)[a-z]+", input) || */Pattern.matches("((?i)[a-z]+[ \t]?[-]?)*(?i)[a-z]*", input)) {
            prove = true;
        } else {
            prove = false;
        }
        return prove;
    }


    // Hausnummer: Zahlen und Buchstaben, keine Sonderzeichen

    private boolean proveForNoSpecialCharacters(CharSequence input) {
        boolean prove;
        if (Pattern.matches("\\d*(?i)[a-z]", input) || Pattern.matches("\\d*", input)) { // Hausnummer egal wie groß + ein Buchstabe
            prove = true;
        } else {
            prove = false;
        }
        return prove;
    }

    // PLZ: nur Zahlen

    private boolean verifyPLZ_IfFiveNumbersOnly(CharSequence input) {
        boolean prove;
        if (Pattern.matches("\\d{5}", input)) { // genau 5 Zahlen erlaubt
            prove = true;
        } else {
            prove = false;
        }
        return prove;
    }

    // verify doGET

    public boolean verifyID_IfNumbersOnly(CharSequence input) {
        boolean prove;
        if(Pattern.matches("\\d", input)) {
            prove = true;
        } else {
            prove = false;
        }


        return prove;
    }

    // ---> Formatting


}
