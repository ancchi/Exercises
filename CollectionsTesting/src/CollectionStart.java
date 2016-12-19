
import de.post.collections.listen.ArrayListT;
import de.post.collections.listen.LinkedListT;
import de.post.collections.queues.ArrayDequeT;
import de.post.collections.queues.LinkedListQueueT;
import de.post.collections.queues.PriorityQueueT;
import de.post.collections.sets.HashSetT;
import de.post.collections.sets.TreeSetT;

public class CollectionStart {

    public static void main(String[] args) {

//        LinkedListT listT = new LinkedListT();
//        listT.useCollectionForGeneratingList();
//
//
//
//        ArrayListT arrList = new ArrayListT();
//        arrList.useCollectionToFillArrayList();
//        arrList.useListToFillArrayList();


//        HashMapT hashM = new HashMapT();
//        hashM.useHashMapForTheMap();
//
//        TreeMapT treeM = new TreeMapT();
//        treeM.useTreeMapForTheMap();

        HashSetT hashSetT = new HashSetT();
        hashSetT.generateHashSet();
        hashSetT.putHashSetIntoTreeSet();


        TreeSetT tSetT = new TreeSetT();
        tSetT.generateTreeSet();

//        LinkedListQueueT llQueue = new LinkedListQueueT();
//        llQueue.generateLinkedList();
//
//        ArrayDequeT arrayDequeT = new ArrayDequeT();
//        arrayDequeT.generateArrayDeque();

//        PriorityQueueT priorityQueueT = new PriorityQueueT();
//        priorityQueueT.generatePriorityQueue();

    }

}
