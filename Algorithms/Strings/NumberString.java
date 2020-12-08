public class NumberString {
    public static void main (String[] args) {
        System.out.println(concat("123456789"));
        System.out.println(concat("246579"));
        System.out.println(concat("1"));
        System.out.println(concat("11"));
        System.out.println(concat("113849809020918960201838"));
        System.out.println(concat(""));
        System.out.println(concat(null));
    }

    public static String concat(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        boolean prev = Character.getNumericValue(chars[0]) % 2 == 0;
        sb.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            boolean cur = Character.getNumericValue(c) % 2 == 0;
            if (prev == true && cur == true) {
                sb.append('#');
            } else if(prev == false && cur == false) {
                sb.append('-');
            }
            sb.append(c);
            prev = cur;
        }

        return sb.toString();
    }
}