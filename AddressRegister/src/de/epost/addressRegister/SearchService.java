package de.epost.addressRegister;

import de.epost.addressRegister.model.Address;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by afischer on 05/12/2016.
 */
public interface SearchService {


    /*
    * SearchService bildet die Schnittstelle für die normale Suche und die Suche mit Case insensitive
    * implementiert von: CaseSensitiveSearchService und NotCaseSensitiveSearchServiceTest
    * */

    // erhält den Nachnamen als Suchkriterium und gibt die Adresse als String zurück
    String searchByLastName(String lastName);
    // erhält den Vornamen als Suchkriterium und gibt die Adresse als String zurück
    String searchByPrename(String prename);
    // wird im Menue beim Hinzufuegen von Daten aufgerufen um die Map der beiden Klassen zu updaten
    void updateDatabase(Map<String, Address> newDatabase);


}
