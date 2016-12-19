package de.post.collections.queues;

import de.post.collections.queues.interfaces.QueueT;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by afischer on 09/12/2016.
 */
public class PriorityQueueT {

    public void generatePriorityQueue() {
        Queue priorQueue = new PriorityQueue();
        QueueT qT = new QueueT();

        qT.generateQueue(priorQueue);


    }


}
