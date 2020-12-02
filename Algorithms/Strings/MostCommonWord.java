import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* Given a string and a list of banned words. Return the unbanned word which appears most */

public class MostCommonWord {
    public static void main(String[] args) {
        String input = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] bInput = {"hit"};

        System.out.println(mostCommonWord(input, bInput));
    }

    public static String mostCommonWord(String s, String[] banned) {
        Map<String, Integer> countMap = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }

        int maxFreq = Integer.MIN_VALUE;
        String maxWord = "";
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
                if (i != chars.length - 1) continue;
            }
            if (sb.length() > 0) {
                String word = sb.toString();
                
                if (!bannedSet.contains(word)) {
                    int count = countMap.getOrDefault(word, 0) + 1;
                    countMap.put(word, count);
                    if (count > maxFreq) {
                        maxFreq = count;
                        maxWord = word;
                    }
                }
                
                sb = new StringBuilder();
            }
        }
        
        return maxWord;
    }

    // public static String mostCommonWord(String s, String[] banned) {
    //     Map<String, Integer> countMap = new HashMap<>();
    //     Set<String> bannedSet = new HashSet<>();
    //     for (String word : banned) {
    //         bannedSet.add(word);
    //     }

    //     String sanitizedS = s.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
    //     String[] words = sanitizedS.split(" ");
    //     for (String word : words) {
    //         if (!bannedSet.contains(word)) {
    //             countMap.put(word, countMap.getOrDefault(word, 0) + 1);
    //         }
    //     }

    //     return Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    // }
}