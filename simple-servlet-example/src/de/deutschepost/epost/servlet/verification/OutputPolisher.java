package de.deutschepost.epost.servlet.verification;

import de.deutschepost.epost.servlet.model.Address;

import java.util.regex.Pattern;

/**
 * Created by afischer on 16/02/2017.
 */
public class OutputPolisher {


    public Address polishInput(Address address) {
        // TODO die Daten sollen formatiert und dann direkt in die Entity geschrieben werden
        address.setPrename(checkIfMoreThenOneWord(address.getPrename()));
        address.setLastName(checkIfMoreThenOneWord(address.getLastName()));
        address.setStreet(checkIfMoreThenOneWord(address.getStreet()));
        address.setLocation((checkIfMoreThenOneWord(address.getLocation())));
        System.out.println("Test polishInput: " + address.getPrename());
        return address;
    }


    private String checkIfMoreThenOneWord(String name) {
        String wholeName = "";
        if (name.contains(" ") || name.contains("-")) {

            String[] arrayWithoutSpaces = name.split(" ");
            for (int i = 0; i < arrayWithoutSpaces.length; i++) {
                String word = "";
                int index = 0;
                if (arrayWithoutSpaces[i].contains("-")) {
                    String[] arrayWithoutHyphens = arrayWithoutSpaces[i].split("-");
                    for (index = 0; index < arrayWithoutHyphens.length; index++) {
                        String tempWord = giveBackAsFormattedSubstantive(arrayWithoutHyphens[index]);
                        word += tempWord;
                        if (!word.equals("") && index < arrayWithoutHyphens.length - 1) {
                            word += "-";
                        }
                    }
                    System.out.println("Test Bindestrich: " + word);  // yes
                    arrayWithoutSpaces[i] = word; // word besitzt das Wort mit Bindestrich
                }
                if (!arrayWithoutSpaces[i].equals(word)) { // checkt, ob es ein Bindestrich enthält
                    arrayWithoutSpaces[i] = giveBackAsFormattedSubstantive(arrayWithoutSpaces[i]);
                }
                wholeName += arrayWithoutSpaces[i];
                if (!wholeName.equals("") && i < arrayWithoutSpaces.length - 1) {
                    wholeName += " ";
                }
            }
        } else {
            wholeName = name;
        }
        return wholeName;
    }


    private String giveBackAsFormattedSubstantive(CharSequence inputWord) {
        String outputWord;
        char firstLetter;
        char followingLetter;
        if (Pattern.matches("\\p{Upper}\\p{Lower}*", inputWord)) {
            outputWord = inputWord.toString();
        } else {
            // alle Buchstaben ausser der erste werden klein geschrieben
            for (int index = 1; index < inputWord.length(); index++) {
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
