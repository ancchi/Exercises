
package de.deutschepost.epost.addressRegister;

import de.deutschepost.epost.addressRegister.model.Address;

import java.util.Scanner;


public class Input {

    // TODO: wird die Klasse gebraucht?
    
    Scanner keyboard;

    public Input(Scanner keyboard) {
          this.keyboard = keyboard;
    }


    public Address receiveInput(int indicator) {
        Address address = new Address();
//        if(indicator == 2) {
//            address.setAddressID(Long.parseLong(this.keyboard.nextLine()));
//        }
        System.out.print("Vorname: ");
        address.setPrename(this.keyboard.nextLine());
        System.out.print("Nachname: ");
        address.setLastName(this.keyboard.nextLine());
        System.out.print("Strasse: ");
        address.setStreet(this.keyboard.nextLine());
        System.out.print("Hausnummer: ");
        address.setStreetNumber(this.keyboard.nextLine());
        System.out.print("PLZ: ");
        address.setPostCode(this.keyboard.nextLine());
        System.out.print("Ort: ");
        address.setLocation(this.keyboard.nextLine());
        return address;
    }
    
}
