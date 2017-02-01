package de.deutschepost.epost.addressRegister.utils;

import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * Created by afischer on 26/01/2017.
 */
public class Utilities {

    public boolean toBoolean (int intWert) {
        return intWert != 0;   // gibt true zurück, wenn der Wert nicht 0 ist
    }

    public int boolToInt (boolean bool) {
        if (bool)
            return 1;
        else
            return 0;
    }


}
