package de.post.collections.sets.interfaces;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by afischer on 09/12/2016.
 */
public class SetT {


    public void putOutSetWithoutIterator(Set set) {  // Werte werden mit Komma in Liste angezeigt

        System.out.println(set);

    }

    public void putOutSetWithIterator(Set set) {    // Werte werden untereinander aufgelistet

        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            String element = (String)iterator.next();  // warum kann es nach String konvertiert werden?
            System.out.println(element);
        }
    }

    public void putOutSetWithForLoop(Set<String> set) {  // Typ muss angegeben werden in Diamond-Operator
        for(String temp : set) {
            System.out.println(temp);
        }
    }

}
