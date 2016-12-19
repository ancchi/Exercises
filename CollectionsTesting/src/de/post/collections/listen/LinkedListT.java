package de.post.collections.listen;


import de.post.collections.listen.interfaces.CollectionT;
import de.post.collections.listen.interfaces.ListT;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListT {

    public void useCollectionForGeneratingList() {
        List<String> linkedList = new LinkedList<>();
        CollectionT collectionT = new CollectionT();
        collectionT.fillColl(linkedList);    // fillIn erhält eine Collection (LinkedList) und füllt sie

        System.out.println("List:");
        System.out.println(linkedList);



        linkedList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("Sortierte List:");
        System.out.println(linkedList);
        System.out.println("Index 1: " + linkedList.get(0));
        System.out.println("Index 2: " + linkedList.get(1));

        Collections.sort( linkedList );  // Collections ist eine Klasse, kein Interface - sie enthält die Methode sort
        System.out.println("Sortierte List:");
        System.out.println(linkedList);
    }


    public void useListToFillArrayList() {
        List<String> linkList = new LinkedList<>();
        ListT listT = new ListT();  // Methode fillList() hat als Argument das Interface List
        listT.fillList(linkList);


        System.out.println(linkList);
    }





}
