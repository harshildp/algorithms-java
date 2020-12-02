import java.security.KeyManagementException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KMostFrequentWords {
    public static void main(String[] args) {
        String[] input = {
            "Anacell provides the best services in the city",
            "betacellular has awesome services",
            "Best services provided by anacell, everyone should use anacell"
        };
        String[] inputKeywords = { "anacell", "cetracular", "betacellular"};

        System.out.println(mostFreqWords(input, inputKeywords, 2));

        String[] input2 = {
            "I love anacell Best services; Best services provided by anacell",
            "betacellular has great services",
            "deltacellular provides much better services than betacellular",
            "cetracular is worse than anacell",
            "Betacellular is better than deltacellular."
        };
        String[] inputKeywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};

        System.out.println(mostFreqWords(input2, inputKeywords2, 2));
    }

    public static List<String> mostFreqWords(String[] strings, String[] keywords, int k) {
        Set<String> keySet = new HashSet(Arrays.asList(keywords));
        Map<String, Integer> keyCount = new HashMap<>();

        for (String s : strings) {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            Set<String> addedSet = new HashSet<>();

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (Character.isLetter(c)) {
                    sb.append(Character.toLowerCase(c));
                    if (i != chars.length - 1) continue;
                }

                if (sb.length() > 0) {
                    String word = sb.toString();

                    if (keySet.contains(word) && !addedSet.contains(word)) {
                        keyCount.put(word, keyCount.getOrDefault(word, 0) + 1);
                        addedSet.add(word);
                    }

                    sb = new StringBuilder();
                }
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                int val = keyCount.get(a) - keyCount.get(b);
                if (val == 0) {
                    return b.compareTo(a);
                }
                return val;
            }
        );

        for (String word : keyCount.keySet()) {
            //System.out.println("Word is " + word + " count is " + keyCount.get(word));
            pq.offer(word);

            if (pq.size() > k) {
                pq.poll();
            }

            //System.out.println(pq.toString());
        }

        List<String> ans = new ArrayList<>();

        while (!pq.isEmpty()){
            ans.add(pq.poll());
        }

        Collections.reverse(ans);
        return ans;
    }
}