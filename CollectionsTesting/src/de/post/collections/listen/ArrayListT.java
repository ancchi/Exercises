package de.post.collections.listen;

import de.post.collections.listen.interfaces.CollectionT;
import de.post.collections.listen.interfaces.ListT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by afischer on 07/12/2016.
 */
public class ArrayListT {


    public void useCollectionToFillArrayList() {
        List<String> arrList = new ArrayList<>();
        CollectionT coll = new CollectionT();
        coll.fillColl(arrList); // Methode fillColl() hat als Argument das Interface Collection

        System.out.println("ArrayList:");
        System.out.println(arrList);

        Collections.sort(arrList);
        System.out.println("Sortierte ArrayList:");
        System.out.println(arrList);
        System.out.println("Index 1: " + arrList.get(0));
        System.out.println("Index 2: " + arrList.get(1));

    }


    public void useListToFillArrayList() {
        List<String> arrList = new ArrayList<>();
        ListT listT = new ListT();  // Methode fillList() hat als Argument das Interface List
        listT.fillList(arrList);


        System.out.println(arrList);
    }



}
