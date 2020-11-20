import java.util.PriorityQueue;
import java.util.Queue;

/* Given an array of ints. If you sum any two values at a time,
what is the least possible count that can be calculated? */

public class MinCount {
    public static void main(String[] args) {
        int[] input1 = {8, 4, 6, 12};
        int[] input2 = {20, 4, 8, 2};
        int[] input3 = {1, 2, 5, 10, 35, 89};
        int[] input4 = {2, 2, 3, 3};
        System.out.println(minCount(input1));
        System.out.println(minCount(input2));
        System.out.println(minCount(input3));
        System.out.println(minCount(input4));
    }
    
    // Use a priorityqueue / minheap to hold the values in sorted order.
    // During each iteration, sum the two smallest values and add them to total count
    public static int minCount(int[] input) {
        Queue<Integer> pq = new PriorityQueue<Integer>();

        for (int i : input) {
            pq.offer(i);
        }

        int count = 0;

        while (pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            pq.add(temp);
            count += temp;
        }

        return count;
    }
}