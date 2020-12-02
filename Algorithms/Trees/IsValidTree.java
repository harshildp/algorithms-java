import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class IsValidTree {
    public static void main(String[] args) {
        int[][] input1 = new int[][] {{0,1},{0,2},{0,3},{1,4}};       // true
        int[][] input2 = new int[][] {{0,1},{1,2},{2,3},{1,3},{1,4}}; // false
        int n = 5;

        System.out.println(isValidTreeDFS(input1, n));
        System.out.println(isValidTreeDFS(input2, n));
    }

    public static boolean isValidTreeDFS(int[][] edges, int n) {
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            edgeMap.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            System.out.println("populating " + edge[0] + " " + edge[1]);
            edgeMap.get(edge[0]).add(edge[1]);
            edgeMap.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        boolean ret = dfs(0, -1, edgeMap, visited);
        System.out.println("Size is " + visited.size() + " ret is " + ret);
        return ret && visited.size() == n;
    }

    private static boolean dfs(int cur, int parent, Map<Integer, List<Integer>> edgeMap, Set<Integer> visited) {

        if (visited.contains(cur)) return false;

        visited.add(cur);

        for (int i : edgeMap.get(cur)) {
            System.out.println(" cur is " + cur + " i is " + i + " parent is " + parent);
            if (i != parent && !dfs(i, cur, edgeMap, visited)) {
                return false;
            }
        }

        return true;
    }


    public static boolean isValidTreeBFS(int[][] edges, int n) {
        if (edges.length != n - 1) return false;
        List<List<Integer>> edgeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            edgeList.add(new ArrayList<>());
        } 

        for (int[] edge : edges) {
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        while(!q.isEmpty()) {
            int cur = q.poll();

            // if (visited.contains(cur)) {
            //     System.out.println("cur is " + cur);
            //     return false;
            // }

            visited.add(cur);

            for (int i : edgeList.get(cur)) {   
                if (!visited.contains(i)) {
                    q.offer(i);
                }
            }
        }

        System.out.println("Size is " + visited.size());
        if (visited.size() != n) return false;

        return true;
    }
}