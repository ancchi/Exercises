package de.deutschepost.epost.servlet.verification;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Created by afischer on 14/02/2017.
 */
public class Verify {

    // Vorname, Nachname: Buchstaben, keine Sonderzeichen ausser Leerzeichen, keine Zahlen
    // Land: nur Buchstaben, keine Sonderzeichen ausser Leerzeichen, keine Zahlen
    // Ort: nur Buchstaben, keine Sonderzeichen ausser Leerzeichen, keine Zahlen
    // Strasse: Buchstaben, keine Sonderzeichen ausser Leerzeichen, Zahlen sind erlaubt

    public boolean proofForOnlyLetters(CharSequence input) {  // String implements the Interface CharSequence -> kein Casting in diese Richtung nötig
        boolean proof;

        if(Pattern.matches(".*\\p{Lower}*", input) || Pattern.matches("\\p{Upper}.*", input)) {
            proof = true;
        } else {
            proof = false;
        }
        return proof;
    }


    // Hausnummer: Zahlen und Buchstaben, keine Sonderzeichen

    public boolean proofForNoSpecialCharacters(CharSequence input) {
        boolean proof;
        if(Pattern.matches("\\d*.", input)) { // Hausnummer egal wie groß + ein Buchstabe
            proof = true;
        } else {
            proof = false;
        }
        return proof;
    }

    // PLZ: nur Zahlen

    public boolean verifyPLZWith5NumbersOnly(CharSequence input) {
        boolean proof;
        if(Pattern.matches("\\d{5}", input)) { // genau 5 Zahlen erlaubt
            proof = true;
        } else {
            proof = false;
        }
        return proof;
    }


    public String checkIfMoreThenOneWord(String name) {
        // TODO rufe zuerst diese Methode zum Prüfen auf, übergebe dann jeden einzelnen String an
        // TODO giveBackAsFormattedSubstantive, lasse sie dir im richtigen Format wieder zurückgeben und füge sie wieder zusammen
        String singleWord;

        String[] arrayOfSingleWords = name.split("\\s");
        String wholeName = giveBackAsFormattedSubstantive(arrayOfSingleWords[0]);
        for(int i = 1; i < arrayOfSingleWords.length; i++) {
            singleWord = giveBackAsFormattedSubstantive(arrayOfSingleWords[i]);
            wholeName = wholeName + " " + singleWord;
        }
        return wholeName;
    }

    public String giveBackAsFormattedSubstantive(CharSequence inputWord) {
        String outputWord;
        char firstLetter;
        char followingLetter;
        if(Pattern.matches("\\p{Upper}\\p{Lower}*", inputWord)) {
            outputWord = inputWord.toString();
        } else {
            // alle Buchstaben ausser der erste werden klein geschrieben
            for(int index = 1; index < inputWord.length(); index++) {
                followingLetter = inputWord.charAt(index);
                followingLetter = Character.toLowerCase(followingLetter);
                inputWord = inputWord.toString().replace(inputWord.charAt(index), followingLetter);
            }
            // erster Buchstabe wird groß geschrieben
            firstLetter = inputWord.charAt(0);
            firstLetter = Character.toUpperCase(firstLetter);
            outputWord = inputWord.toString().replaceFirst(String.valueOf(inputWord.charAt(0)), String.valueOf(firstLetter));
        }
        return outputWord;
    }
}
