import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {

    private Deque<Integer> dq;

    private HashSet<Integer> set;

    private final int CACHE_SIZE;

    // Initialize a new LRU Cache of capacity provided
    LRUCache(int capacity) {
        dq = new LinkedList<>();
        set = new HashSet<>();
        CACHE_SIZE = capacity;
    }

    // Update the cache with the latest reference
    public void refer(int value) {

        // Check if the latest value has already been cached before
        // If it hasnt been cached check to see if capacity has been reached.
        // Remove the oldest element if at capacity 
        if (!set.contains(value)) {
            if (dq.size() == CACHE_SIZE) {
                int oldest = dq.removeLast();
                set.remove(oldest);
            }
        // If the value has been cached before. Remove it so we can recache it as newest value
        } else {
            dq.remove(value);
        }

        // Cache the new value
        dq.push(value);
        set.add(value);
    }

    public void print() {
        Iterator<Integer> it = dq.iterator();

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }

    public static void main (String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(4);
        cache.print();
        System.out.println();
        cache.refer(5);
        cache.print();
    }
}