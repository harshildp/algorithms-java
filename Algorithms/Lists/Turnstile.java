import java.util.Queue;
import java.util.LinkedList;

public class Turnstile {
    public static void main(String[] args) {
        int[] inputT = {0, 0, 1, 5};
        int[] inputT1 = {1, 2, 4};
        int[] inputT2 = {1, 1};
        int[] inputT3 = {1, 1, 3, 3, 4, 5, 6, 7, 7};
        int[] inputD = {0, 1, 1, 0};
        int[] inputD1 = {0, 1, 1};
        int[] inputD2 = {1, 1};
        int[] inputD3 = {1, 1, 0, 0, 0, 1, 1, 1, 1};

        int[] output = getTimes(inputT, inputD);
        int[] output1 = getTimes(inputT1, inputD1);
        int[] output2 = getTimes(inputT2, inputD2);
        int[] output3 = getTimes(inputT3, inputD3);

        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : output1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : output2) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : output3) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] getTimes(int[] times, int[] directions) {
        Queue<Integer> exit = new LinkedList<>();
        Queue<Integer> entry = new LinkedList<>();

        for (int i = 0; i < directions.length; i++) {
            if (directions[i] == 0) {
                entry.add(i);
            } else {
                exit.add(i);
            }
        }

        int prevDir = -1;
        int time = 0;

        int[] ans = new int[directions.length];
        while (!exit.isEmpty() && !entry.isEmpty()) {
            int nextExit = Math.max(time, times[exit.peek()]);
            int nextEntry = Math.max(time, times[entry.peek()]);

            if (Math.min(nextEntry, nextExit) > time) {
                time = Math.min(nextEntry, nextExit);
                prevDir = -1;
                continue;
            }
            if (nextEntry < nextExit) {
                prevDir = 0;
                time = nextEntry;
                ans[entry.peek()] = nextEntry;
                entry.poll();
            } else if (nextExit < nextEntry) {
                prevDir = 1;
                time = nextExit;
                ans[exit.peek()] = nextExit;
                exit.poll();
            } else {
                if (prevDir == -1 || prevDir == 1) {
                    prevDir = 1;
                    time = nextExit;
                    ans[exit.peek()] = nextExit;
                    exit.poll();
                } else {
                    prevDir = 0;
                    time = nextEntry;
                    ans[entry.peek()] = nextEntry;
                    entry.poll(); 
                }
            }
            time++;
        }

        while (!exit.isEmpty()) {
            int nextExit = Math.max(time, times[exit.peek()]);
            ans[exit.peek()] = nextExit;
            time = nextExit + 1;
            exit.poll();
        }

        while (!entry.isEmpty()) {
            int nextEntry = Math.max(time, times[entry.peek()]);
            ans[entry.peek()] = nextEntry;
            time = nextEntry + 1;
            entry.poll();
        }
        return ans;
    }
}