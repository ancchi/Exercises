package de.post.collections.sets;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import de.post.collections.sets.interfaces.SetT;

/**
 * Created by afischer on 09/12/2016.
 */
public class HashSetT {

    Set hSet = new HashSet();

    public void generateHashSet() {

        SetT setT = new SetT();

        hSet.add("Tahoma");
        hSet.add("Oklahoma");
        hSet.add("Uganda");
        hSet.add("Tokio");

        System.out.println("HashSet (als Objekt): ");
        setT.putOutSetWithoutIterator(hSet);

        System.out.println("HashSet (mit Iterator):");
        setT.putOutSetWithIterator(hSet);

        System.out.println("HashSet (mit For-Schleife)");
        setT.putOutSetWithForLoop(hSet);

    }

    public void putHashSetIntoTreeSet() {

        TreeSet treeSet1 = new TreeSet(hSet);
        System.out.println("HashMap in TreeSet gepackt:");
        System.out.println(treeSet1);

        TreeSet treeSet2 = new TreeSet(hSet);
        System.out.println("Andere Methode mit addAll(Object o):");
        System.out.println(treeSet2.addAll(hSet));




    }


}
