package de.post.maps;

import de.post.maps.interfaces.MapT;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by afischer on 08/12/2016.
 */
public class HashMapT {

    public void useHashMapForTheMap() {

        Map<String, String> hashM = new HashMap();
        MapT mapT = new MapT();
        mapT.fillMap(hashM);

        System.out.println("HashMap, unsortiert: ");
        System.out.println(hashM);
        System.out.println("Schlüssel:");
        System.out.println(hashM.keySet());
        System.out.println("Werte:");
        System.out.println(hashM.values());

        System.out.println("Formatierte Ausgabe mit Iterator:s");
        String vorname;
        Collection<String> anyColl = hashM.values();
        Iterator<String> iterator = anyColl.iterator();
        while(iterator.hasNext()) {
            vorname = iterator.next();
            System.out.println("Vorname: " + vorname);
        }

    }
}
