package de.post.collections.queues;

import java.util.LinkedList;
import java.util.Queue;

import de.post.collections.queues.*;
import de.post.collections.queues.interfaces.QueueT;

/**
 * Created by afischer on 09/12/2016.
 */
public class LinkedListQueueT {


    public void generateLinkedList() {
        QueueT queT = new QueueT();
        Queue lList = new LinkedList();

        queT.generateQueue(lList);
    }


}
