
package de.deutschepost.epost.addressRegister;


public class Menue {

    // TODO: neues Menue implementieren

//    Map<String, Address> addressMap;
//    Input input;
//    Scanner keyReader;
//    Requests output;
//    int indicator;
//
//
//    public Menue() {
//       keyReader = new Scanner(System.in);  // an weitere Klassen weiterreichen
//       addressMap = new HashMap<>();
//       input = new Input(keyReader);
//       output = new Requests(addressMap);
//       output = new Requests(addressMap, keyReader); // Konstruktor überladen
//
//    }
//
//
//    public void showMenue() {
//        System.out.println("\nWas möchten Sie machen?");
//        System.out.println("(1) Neue Daten eingeben");
//        System.out.println("(2) Alles anzeigen");
//        System.out.println("(3) Suche nach Vorname starten");
//        System.out.println("(4) Suche nach Nachname starten");
//        System.out.println("(5) Suche nach Vorname starten (Case Insensitive)");
//        System.out.println("(6) Suche nach Nachname Starten (Case Insensitive)");
//        System.out.println("(x) Programm beenden");
//    }
//
//    public void menueSelection(String option) {
//        switch(option) {
//            case("1"):
//                Address newAddress = input.receiveInput();
//                addressMap.put(newAddress.getLastName(), newAddress);  // (key, Datentyp)
//                output.getCaseSensitiveSearchService().updateDatabase(addressMap);   // HashMap updaten
//                output.getNotCaseSensitiveSearchService().updateDatabase(addressMap);
//                break;
//            case("2"):
//                output.giveOutAll();
//                break;
//            case("3"):
//                indicator = 1;
//                output.outputByPrename(indicator);
//                break;
//            case("4"):
//                indicator = 1;
//                output.outputByLastName(indicator);
//                break;
//            case("5"):
//                indicator = 2;
//                output.outputByPrename(indicator);
//                break;
//            case("6"):
//                indicator = 2;
//                output.outputByLastName(indicator);
//                break;
//            case("x"):
//                System.exit(0);
//                break;
//        }
//    }
    
}
