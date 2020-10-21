import java.util.Iterator;
import java.util.LinkedList;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ababa"));
        System.out.println(isPalindrome("I did, did I?"));
        System.out.println(isPalindrome("Hello"));
        System.out.println(isPalindrome("Don't nod"));
    }

    public static boolean isPalindrome(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        StringBuilder stripedString = new StringBuilder(s.length());
        String lowercaseS = s.toLowerCase();

        for (char c : lowercaseS.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                stripedString.append(c);
                stack.push(c);
            }
        }

        StringBuilder reversedString = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        return reversedString.toString().equals(stripedString.toString());
    }
}