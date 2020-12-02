import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Containers{
    public static void main(String[] args) {
        String s1 = "|**|*|*";
        System.out.println("Items in " + s1 + " : " + numberOfItems(s1, Arrays.asList(1, 1), Arrays.asList(5, 6))); // Output is [2, 3]
        
        String s2 = "*|*";
        System.out.println("Items in " + s2 + " : " + numberOfItems(s2, Arrays.asList(0), Arrays.asList(3))); // Output is [0]
        
        String s3 = "****|*|";
        System.out.println("Items in " + s3 + " : " + numberOfItems(s1, Arrays.asList(0, 4, 2), Arrays.asList(3, 7, 7))); // Output is [0, 1, 1]
    }

    public static List<Integer> numberOfItems(String s, List<Integer> startInd, List<Integer> endInd) {
        int[] start = new int[s.length()];
        int[] end = new int[s.length()];
        int[] ast = new int[s.length()];

        int astCount = 0;
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if (left == '|') {
                start[i] = i;
            }

            if (left == '*') {
                astCount++;
                start[i] = i == 0 ? 0 : start[i-1];
            }

            if (right == '|') {
                end[j] = j;
            }

            if (right == '*') {
                end[j] = j == s.length() - 1 ? 0 : end[j+1];
            }

            ast[i] = astCount;
        }

        for (int x = 0; x < start.length; x++) {
            System.out.println(start[x] + " " + end[x] + " " + ast[x]);
        }

        List<Integer> ans = new ArrayList<>();

        for(int k = 0; k < startInd.size(); k++) {
            int temp = 0;
            int si = startInd.get(k);
            int ei = endInd.get(k);
            if (si <= s.length() && ei <= s.length() && si >= 1 && ei >= 1) {
                int sInd = end[si - 1];
                int eInd = start[ei - 1];
                temp = sInd > eInd ? 0 : ast[eInd] - ast[sInd];
            }
            ans.add(temp);
        }

        return ans;
    }
}