package de.post.collections.listen.interfaces;

import java.util.Collection;
import java.util.List;

/**
 * Created by afischer on 07/12/2016.
 */
public class ListT {

    /*
    * eine Liste ist eine Sequenz
    * und List ist ein Interface und kann nicht als Instanz implementiert werden
    *
    * */


    public void fillList (List<String> coll) {
        coll.add("Charlotte");
        coll.add("Paul");
        coll.add("Franzi");
        coll.add("Julia");
    }


}
