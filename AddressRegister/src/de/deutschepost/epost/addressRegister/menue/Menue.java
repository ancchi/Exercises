
package de.deutschepost.epost.addressRegister.menue;


import de.deutschepost.epost.addressRegister.Input;
import de.deutschepost.epost.addressRegister.model.Address;
import de.deutschepost.epost.addressRegister.persistence.SearchDao;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menue {

    // TODO: neues Menue implementieren

//    Map<Integer, Address> addressMap;
    Input input;
    Scanner keyReader;
    Requests request;



    public Menue() {
       keyReader = new Scanner(System.in);  // an weitere Klassen weiterreichen
       input = new Input(keyReader);
       request = new Requests();
    }

    public void menueStart() throws FileNotFoundException, SQLException {
        keyReader = new Scanner(System.in);
//        Menue menue = new Menue();

        while (true) {
            showMenue();
            String input = keyReader.next();
            try {
                menueSelection(input);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void showMenue() {
        System.out.println("\nWas möchten Sie machen?");
        System.out.println("(1) Neue Daten eingeben");
        System.out.println("(2) Alles anzeigen");
        System.out.println("(3) Suche nach Vorname");
        System.out.println("(4) Suche nach Nachname");
        System.out.println("(5) Suche nach Vorname (Case Insensitive)");
        System.out.println("(6) Suche nach Nachname (Case Insensitive)");
        System.out.println("(7) Globale Suche nach einem Suchbegriff oder Teil eines Suchbegriffes:");
        System.out.println("(8) Datensatz über die ID löschen:");
        System.out.println("(9) Daten eines Datensatzes ändern (über ID)");
        System.out.println("(x) Programm beenden");
    }



    public void menueSelection(String option) throws FileNotFoundException, SQLException {
        switch(option) {
            case("1"):
                Address newAddress = input.receiveInput(1);
                SearchDao searchDao = new SearchDao();
                searchDao.save(newAddress);            // eigentlich über Requests ?
                break;
            case("2"):
                List<Address> addressList = new SearchDao().findAll();
                System.out.println("\nGesamter Datensatz: ");
                for(Address address : addressList) {
                    System.out.println(address);
                }
                break;
            case("3"):
                request.requestByPrename();
                break;
            case("4"):
                request.requestByLastname();
                break;
            case("5"):
                request.requestByPrenameInsensitive();
                break;
            case("6"):
                request.requestByLastnameInsensitive();
                break;
            case("7"):
                request.globalSearchInsensitive();
                break;
            case("8"):
                try {
                    request.deleteRecordByID(this);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case("9"):
                request.changeRecordWithID(this);
                break;
            case("x"):
                System.exit(0);
                break;
        }
    }
}
