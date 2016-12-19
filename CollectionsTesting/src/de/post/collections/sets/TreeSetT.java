package de.post.collections.sets;

import de.post.collections.sets.interfaces.SetT;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by afischer on 09/12/2016.
 */
public class TreeSetT {

    public void generateTreeSet() {

        Set treeSet = new TreeSet();
        SetT setT = new SetT();

        treeSet.add("Tahoma");
        treeSet.add("Oklahoma");
        treeSet.add("Uganda");
        treeSet.add("Tokio");


        System.out.println("TreeSet (als Objekt):");
        setT.putOutSetWithoutIterator(treeSet);

        System.out.println("TreeSet (mit Iterator)");
        setT.putOutSetWithIterator(treeSet);

        System.out.println("TreeSet (mit For-Schleife:");
        setT.putOutSetWithForLoop(treeSet);


    }

}
