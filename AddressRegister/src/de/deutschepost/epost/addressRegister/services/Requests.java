package de.deutschepost.epost.addressRegister.services;

import de.deutschepost.epost.addressRegister.model.Address;
import de.deutschepost.epost.addressRegister.persistence.SearchDao;

import java.util.Map;
import java.util.Scanner;

public class Requests {

    // TODO: Für Abfragen verwenden

//    Map<String, Address> addressMap;
//    SensitiveSearchDao caseSensitiveSearchService;
//    SearchDao notCaseSensitiveSearchService;
//    Scanner input;
//    String searchTerm;  // Suchwort
//
//
//    public Requests(Map<String, Address> addressMap) {
//        this.addressMap = addressMap;
//        this.caseSensitiveSearchService = new SensitiveSearchDao();
//        this.notCaseSensitiveSearchService = new SearchDao();
//    }
//
//    public Requests(Map<String, Address> addressMap, Scanner keyReader) {
//        this.addressMap = addressMap;
//        this.input = keyReader;
//        this.caseSensitiveSearchService = new SensitiveSearchDao();
//        this.notCaseSensitiveSearchService = new SearchDao();
//    }
//
//
//    public void outputByLastName(int indicator) {
//        System.out.print("Bitte geben Sie den Nachnamen der Person ein, die Sie suchen wollen: ");
//        searchTerm = input.nextLine();
//        System.out.println("Die Adresse von der Person, die Sie suchen, ist: ");
//        if(indicator == 1) {
//            System.out.println(this.caseSensitiveSearchService.searchByLastName(searchTerm));
//        } else if(indicator == 2) {
//            System.out.println(this.notCaseSensitiveSearchService.searchByLastName(searchTerm));
//            // Debugging: searchTerm wird übergeben, Aufruf der Methode verursacht wahrscheinlich NullPointerException
//            // Ursache war, dass die HashMap aus dem Konstruktor leer war -> update-Methode an richtiger Stelle implementiert
//        }
//    }
//
//    public void outputByPrename(int indicator) {
//        System.out.print("Bitte geben Sie den Vornamen der Person ein, die Sie suchen wollen: ");
//        searchTerm = input.nextLine();
//        System.out.println("Die Adresse von der Person, die Sie suchen, ist: ");
//        if(indicator == 1)
//        System.out.println(this.caseSensitiveSearchService.searchByPrename(searchTerm));
//        if(indicator == 2)
//            System.out.println(this.notCaseSensitiveSearchService.searchByPrename(searchTerm));
//
//    }
//
//
//    public void giveOutAll() {
//        System.out.println(this.caseSensitiveSearchService.putAllOut());
//    }
//
//
//    public SensitiveSearchDao getCaseSensitiveSearchService() {
//        return caseSensitiveSearchService;
//    }
//
//
//    public SearchDao getNotCaseSensitiveSearchService() {
//
//        return notCaseSensitiveSearchService;
//    }



}
