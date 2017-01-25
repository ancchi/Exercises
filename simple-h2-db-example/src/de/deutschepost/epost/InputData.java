package de.deutschepost.epost;

import java.util.Scanner;

/**
 * Created by afischer on 24/01/2017.
 */
public class InputData {


    Scanner readFromLine = new Scanner(System.in);


    public String inputTodo() {
        System.out.println("Neuer Eintrag auf TODO-List:");
        String todoItem = readFromLine.next();
        return todoItem;
    }


    public boolean inputStatus() {
        System.out.println("Status: (open/done");
        String status = readFromLine.next();

        if (status.equals("open")) {
            return false;
        } else {
            return true;
        }
    }



}
