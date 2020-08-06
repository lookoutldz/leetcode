package day36;

import java.util.regex.Pattern;

public class Palindrome {

    public boolean isPalindrome(String s) {
        String ss = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        if ("".equals(ss.trim())) {
            return true;
        }
        char[] cs = ss.toCharArray();
        for (int i = 0; i < cs.length / 2; i++) {
            if (cs[i] != cs[cs.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
