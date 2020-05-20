package day16;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == (char)32) {
                return s.length() - 1 - i;
            } else if (i == 0) {
                return s.length() - i;
            }
        }
        return 0;
    }

    public void test() {
        System.out.println(lengthOfLastWord("  a"));
    }
}
