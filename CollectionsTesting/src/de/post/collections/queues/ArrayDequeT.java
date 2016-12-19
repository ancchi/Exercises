package de.post.collections.queues;

import java.util.ArrayDeque;
import de.post.collections.queues.*;
import de.post.collections.queues.interfaces.QueueT;

/**
 * Created by afischer on 09/12/2016.
 */
public class ArrayDequeT {

    public void generateArrayDeque() {
        ArrayDeque arrayDeque = new ArrayDeque();
        QueueT qT = new QueueT();

        qT.generateQueue(arrayDeque);


    }

}
