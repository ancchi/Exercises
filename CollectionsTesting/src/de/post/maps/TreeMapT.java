package de.post.maps;

import de.post.maps.interfaces.MapT;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by afischer on 07/12/2016.
 */
public class TreeMapT {

    public void useTreeMapForTheMap() {
        TreeMap<String, String> treeM = new TreeMap<>();
        MapT mapT= new MapT();
        mapT.fillMap(treeM);

        System.out.println("\nTreeMap - automatisch sortiert:");
        System.out.println(treeM);

        System.out.println("Ausschnitt aus Map:");
        System.out.println(treeM.subMap("Dominius", "Meyer"));  // fromKey inclusive, toKey exclusive

        System.out.println("Schlüssel:");
        System.out.println(treeM.keySet());
        System.out.println("Werte:");
        System.out.println(treeM.values());

        System.out.println("Formatierte Ausgabe mit Iterator:");
        String vorname;
        Collection<String> someColl = treeM.values();  // treeMap-Werte sind in someColl
        Iterator<String> iterator = someColl.iterator(); // auf someColl kann Iterator aufgerufen werden
        while(iterator.hasNext()) {
            vorname = iterator.next();
            System.out.println("Vorname: " + vorname);
        }



    }

}
