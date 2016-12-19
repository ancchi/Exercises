package de.epost.addressRegister;

import java.util.Scanner;

public class AddressRegister {

    public static void main(String[] args) {

        Scanner keyReader = new Scanner(System.in);
        Menue menue = new Menue();

        while (true) {
            menue.showMenue();
            String input = keyReader.next();
            menue.menueSelection(input);
        }
    }
}
