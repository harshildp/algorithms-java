import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GetPairs {
    
    public static void main(String[] args) {
        List<int[]> a1 = new ArrayList(){
            {
                add(new int[] {1, 2});
                add(new int[] {2, 4});
                add(new int[] {3, 6});
            }
        };
        List<int[]> b1 = new ArrayList(){
            {
                add(new int[] {1, 2});
            }
        };
        List<int[]> a2 = new ArrayList(){ 
            {
                add(new int[] {1, 3});
                add(new int[] {2, 5});
                add(new int[] {3, 7});
                add(new int[] {4, 10});
            }
        };
        List<int[]> b2 = new ArrayList(){
            {
                add(new int[] {1, 2});
                add(new int[] {2, 3});
                add(new int[] {3, 4});
                add(new int[] {4, 5});
            }
        };
        List<int[]> a3 = new ArrayList(){
            {
                add(new int[] {1, 8});
                add(new int[] {2, 7});
                add(new int[] {3, 14});
            }
        };
        List<int[]> b3 = new ArrayList(){
            {
                add(new int[] {1, 5});
                add(new int[] {2, 10});
                add(new int[] {3, 14});
            }
        };
        List<int[]> a4 = new ArrayList(){
            {
                add(new int[] {1, 8});
                add(new int[] {2, 15});
                add(new int[] {3, 9});
            }
        };
        List<int[]> b4 = new ArrayList(){
            {
                add(new int[] {1, 8});
                add(new int[] {2, 11});
                add(new int[] {3, 12});
            }
        };

        List<int[]> ans1 = getPairs(a1, b1, 7);
        List<int[]> ans2 = getPairs(a2, b2, 10);
        List<int[]> ans3 = getPairs(a3, b3, 20);
        List<int[]> ans4 = getPairs(a4, b4, 20);
        for (int[] ans : ans1) {
            System.out.print("[" + ans[0] + " " + ans[1] + "] ");
        }
        System.out.println();
        for (int[] ans : ans2) {
            System.out.print("[" + ans[0] + " " + ans[1] + "] ");
        }
        System.out.println();
        for (int[] ans : ans3) {
            System.out.print("[" + ans[0] + " " + ans[1] + "] ");
        }
        System.out.println();
        for (int[] ans : ans4) {
            System.out.print("[" + ans[0] + " " + ans[1] + "] ");
        }
        System.out.println();
    }

    public static List<int[]> getPairs(List<int[]> l1, List<int[]> l2, int target) {
        Collections.sort(l1, (a,b) -> (a[1] - b[1]));
        Collections.sort(l2, (a,b) -> (a[1] - b[1]));

        int curMax = Integer.MIN_VALUE;
        int i = 0;
        int j = l2.size() - 1;

        List<int[]> ans = new ArrayList<>();

        while (i < l1.size() && j >= 0) {
            int sum = l1.get(i)[1] + l2.get(j)[1];
            if (sum > target) {
                j--;
            } else {
                if (sum > curMax) {
                    ans.clear();
                    curMax = sum;
                }
                ans.add(new int[] {l1.get(i)[0], l2.get(j)[0]});
                i++;
            }
        }

        return ans;
    }
}