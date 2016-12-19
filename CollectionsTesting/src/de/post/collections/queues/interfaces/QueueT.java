package de.post.collections.queues.interfaces;


import java.util.LinkedList;
import java.util.Queue;

public class QueueT {

    public void generateQueue( Queue queue) {

        queue.offer("Die");
        queue.offer("Kuh");
        queue.offer("lief");
        queue.offer("um");
        queue.offer("den");
        queue.offer("Teich.");

        queue.poll();  // fragt das erste Element der Kette ab und entfernt es oder gibt null zurück
        queue.offer("Diekuhliefumdenteich.");

        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }


}
