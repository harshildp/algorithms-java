/* 

*/

import java.util.*;

public class IntersectingActivityTimes {
    public static void main(String[] args) {
        int[][] person1 = new int[3][2];
        int[] p1one = {1,2};
        int[] p1two = {3,4};
        int[] p1three = {6,15};
        person1[0] = p1one;
        person1[1] = p1two;
        person1[2] = p1three;

        int[][] person2 = new int[3][2];
        int[] p2one = {1,8};
        int[] p2two = {9,10};
        int[] p2three = {14,17};
        person2[0] = p2one;
        person2[1] = p2two;
        person2[2] = p2three;

        List<int[]> ans = findOverlap(person1, person2);
        if (ans.size() == 0) System.out.println("No overlaps found");
        for (int[] i : ans) {
            System.out.println("{" + i[0] + "," + i[1] + "}");
        }

    }

    public static List<int[]> findOverlap(int[][] p1, int[][] p2) {
        List<int[]> res = new ArrayList<>();

        if (p1 == null || p1.length == 0 || p2 == null || p2.length == 0) return res;

        List<int[]> list = new ArrayList(Arrays.asList(p1));
        list.addAll(Arrays.asList(p2));

        list.sort((i1, i2) -> Integer.compare(i1[0], i2[0]));

        // (1,3) (2,4) (5,10) (6,9) (11,15) (14,17)
        // (2,3) (6,9) (14,15)

        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            int[] l = list.get(i);
            start = l[0]; 
            if (start < end) {
                int[] temp = {start, Math.min(end, l[1])};
                res.add(temp);
            }

            end = Math.max(end, l[1]);
        }

        return res;
    }
}