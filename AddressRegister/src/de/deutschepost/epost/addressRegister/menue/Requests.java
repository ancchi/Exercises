package de.deutschepost.epost.addressRegister.menue;

import de.deutschepost.epost.addressRegister.Input;
import de.deutschepost.epost.addressRegister.model.Address;
import de.deutschepost.epost.addressRegister.persistence.SearchDao;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Requests {

    // TODO: Für Abfragen verwenden

    Scanner inputReader = new Scanner(System.in);
    String searchTerm;
    Input input = new Input(inputReader);


    public void requestByPrename() {
        System.out.println("Bitte geben Sie den Vornamen der Person ein, die Sie suchen wollen: ");
        searchTerm = inputReader.nextLine();
        List<Address> listByPrename = new SearchDao().searchByPrename(searchTerm);
        doOutput(listByPrename);
    }


    public void requestByLastname() {
        System.out.println("Bitte geben Sie den Nachnamen der Person ein, die Sie suchen wollen: ");
        searchTerm = inputReader.nextLine();
        List<Address> listByLastname = new SearchDao().searchByLastname(searchTerm);
        doOutput(listByLastname);
    }

    public void requestByPrenameInsensitive() {
        System.out.println("Bitte geben Sie einen Teil des Vornamens ein:");
        searchTerm = inputReader.nextLine();
        List<Address> listByPartOfPrename = new SearchDao().searchByPrenameInsensitive(searchTerm);
        doOutput(listByPartOfPrename);
    }

    public void requestByLastnameInsensitive() {
        System.out.println("Bitte geben Sie einen Teil des Nachnamens ein:");
        searchTerm = inputReader.nextLine();
        List<Address> listByPartOfLastname = new SearchDao().searchByLastnameInsensitive(searchTerm);
        doOutput(listByPartOfLastname);
    }


    public void globalSearchInsensitive() {
        System.out.println("Bitte geben Sie einen Suchbegriff ein:");
        searchTerm = inputReader.nextLine();
        List<Address> globalSearchList = new SearchDao().globalSearch(searchTerm);
        doOutput(globalSearchList);
    }

    public void deleteRecordByID(Menue menue) throws FileNotFoundException, SQLException {
        System.out.println("Bitte geben Sie die ID des zu löschenden Datensatzes ein:");
        System.out.println("(x) eingeben, wenn die ID nicht bekannt ist");
        searchTerm = inputReader.nextLine();
        if(searchTerm.equals("x")) {
            menue.menueStart();
        } else {
                long number = Long.parseLong(searchTerm);
                new SearchDao().delete(number);
        }

    }

    public void changeRecordWithID(Menue menue) throws FileNotFoundException, SQLException {
        System.out.println("Bitte geben Sie die ID des zu ändernden Datensatzes an:");
        System.out.println("(x) eingeben, wenn die ID nicht bekannt ist.");
        searchTerm = inputReader.nextLine();
        if(searchTerm.equals("x")) {
            menue.menueStart();
        } else {
            long number = Long.parseLong(searchTerm);
            Address address = input.receiveInput(2);  // Input fragt die ID nicht ab
            address.setAddressID(number);             // ID einzeln übergeben
            new SearchDao().update(address);          // -> address ist vollständig mit ID
        }
    }

    public void doOutput(List<Address> addressList) {
        if(addressList.isEmpty()) {
            System.out.println("Es sind keine passenden Datensätze vorhanden.");
        } else {
            System.out.println("Passende Suchergebnisse:");
            for (Address address : addressList) {
                System.out.println(address);
            }
        }
    }


}
