import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/* Given an Array of strings of format "userid1 userid2 transactions". Find all the userids which
have been logged more than the provided threshold number of times. If the userid in a log is the 
same for userid1 and userid2, consider it as a single occurrence. Sort the output by userid*/ 

public class Logs {
    public static void main(String[] args) {
        String[] input = new String[] {
            "345366 89921 45",
            "029323 38239 23",
            "38239 345366 15",
            "029323 38239 77",
            "345366 38239 23",
            "029323 345366 13",
            "38239 38239 23" 
        };
        System.out.println(usersAboveThreshold(input, 3));
    }

    public static List<String> usersAboveThreshold(String[] logs, int threshold) {
        // Map for storing the count for each userid
        HashMap<String, Integer> countMap = new HashMap<>();

        // Loop through the logs and split on space. Check if userid1 and 2 are the same.
        // Update the countMap
        for (String log : logs) {
            String[] vals = log.split(" ");
            countMap.put(vals[0], countMap.getOrDefault(vals[0], 0) + 1);
            if (vals[1] != vals[0]) {
                countMap.put(vals[1], countMap.getOrDefault(vals[1], 0) + 1);
            }
        }

        // Loop through the map keyset and find all the userids that exceed the threshold
        List<String> ans = new ArrayList<>();
        for (String key : countMap.keySet()) {
            int temp = countMap.get(key);
            if (temp >= threshold) {
                ans.add(key);
            }
        }

        // Sort userids that exceeded threshold and return the final list
        Collections.sort(ans, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
            }
        });

        return ans;
    }
}