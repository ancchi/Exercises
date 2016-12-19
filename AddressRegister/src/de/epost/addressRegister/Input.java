
package de.epost.addressRegister;

import de.epost.addressRegister.model.Address;

import java.util.Scanner;


public class Input {
    
    Scanner keyboard;
    
    public Input(Scanner keyboard) {
          this.keyboard = keyboard;
    }
    
    public Address receiveInput() {
        Address address = new Address();
        System.out.print("Vorname: ");
        address.setPrename(this.keyboard.nextLine());
        System.out.print("Nachname: ");
        address.setLastName(this.keyboard.nextLine());
        return address;
    }
    
}
