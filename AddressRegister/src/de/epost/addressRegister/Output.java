package de.epost.addressRegister;

import de.epost.addressRegister.model.Address;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Output {

    Map<String, Address> addressMap;
    CaseSensitiveSearchService caseSensitiveSearchService;
    NotCaseSensitiveSearchService notCaseSensitiveSearchService;
    Scanner input;
    String searchTerm;  // Suchwort


    public Output(Map<String, Address> addressMap) {
        this.addressMap = addressMap;
        this.caseSensitiveSearchService = new CaseSensitiveSearchService();
        this.notCaseSensitiveSearchService = new NotCaseSensitiveSearchService();
    }

    public Output(Map<String, Address> addressMap, Scanner keyReader) {
        this.addressMap = addressMap;
        this.input = keyReader;
        this.caseSensitiveSearchService = new CaseSensitiveSearchService();
        this.notCaseSensitiveSearchService = new NotCaseSensitiveSearchService();
    }


    public void outputByLastName(int indicator) {
        System.out.print("Bitte geben Sie den Nachnamen der Person ein, die Sie suchen wollen: ");
        searchTerm = input.nextLine();
        System.out.println("Die Adresse von der Person, die Sie suchen, ist: ");
        if(indicator == 1) {
            System.out.println(this.caseSensitiveSearchService.searchByLastName(searchTerm));
        } else if(indicator == 2) {
            System.out.println(this.notCaseSensitiveSearchService.searchByLastName(searchTerm));
            // Debugging: searchTerm wird übergeben, Aufruf der Methode verursacht wahrscheinlich NullPointerException
            // Ursache war, dass die HashMap aus dem Konstruktor leer war -> update-Methode an richtiger Stelle implementiert
        }
    }

    public void outputByPrename(int indicator) {
        System.out.print("Bitte geben Sie den Vornamen der Person ein, die Sie suchen wollen: ");
        searchTerm = input.nextLine();
        System.out.println("Die Adresse von der Person, die Sie suchen, ist: ");
        if(indicator == 1)
        System.out.println(this.caseSensitiveSearchService.searchByPrename(searchTerm));
        if(indicator == 2)
            System.out.println(this.notCaseSensitiveSearchService.searchByPrename(searchTerm));

    }


    public void giveOutAll() {
        System.out.println(this.caseSensitiveSearchService.putAllOut());
    }


    public NotCaseSensitiveSearchService getNotCaseSensitiveSearchService() {
        return notCaseSensitiveSearchService;
    }

    public CaseSensitiveSearchService getCaseSensitiveSearchService() {
        return caseSensitiveSearchService;
    }

}
