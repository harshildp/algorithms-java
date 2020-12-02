import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

// Given a string find the substrings of length k that contain unique letters.
public class SubstringsOfKLength {
    public static void main(String[] args) {
        System.out.println(findSubstrings("abcabc", 3));
        System.out.println(findSubstrings("abacab", 3));
        System.out.println(findSubstrings("awaglknagawunagwkwagl", 4));
    }

    public static List<String> findSubstrings(String s, int k) {
        Set<String> set = new HashSet<>();
        int[] charCount = new int[26];
        int l = 0, r = 0;
        
        while (l <= r && r < s.length()) {
            charCount[s.charAt(r) - 'a']++;
            while (charCount[s.charAt(r) - 'a'] != 1) {
                charCount[s.charAt(l) - 'a']--;
                l++;
            }

            if (r - l + 1 == k) {
                set.add(s.substring(l, r + 1));
                charCount[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }

        return new ArrayList(set);
    }
}