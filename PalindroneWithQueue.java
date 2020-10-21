import java.util.LinkedList;

public class PalindroneWithQueue {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ababa"));
        System.out.println(isPalindrome("I did, did I?"));
        System.out.println(isPalindrome("Hello"));
        System.out.println(isPalindrome("Don't nod"));
    }

    public static boolean isPalindrome(String s) {
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        String lowercase = s.toLowerCase();

        for (int i = 0; i < lowercase.length(); i++) {
            char c = lowercase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                queue.addLast(c);
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst())) {
                return false;
            }
        }

        return true;
    }
}