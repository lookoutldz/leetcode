package day8;

import java.util.ArrayList;
import java.util.List;

public class ValidateBrackets {

    public boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        if (s.length() < 2 || s.length() % 2 != 0|| toInt(s.charAt(0)) < 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        List<Character> cList = new ArrayList<>(s.length());
        for (int i = 0; i < chars.length; i++) {
            if (toInt(chars[i]) > 0) {
                cList.add(chars[i]);
            } else {
                if (cList.size() < 1) {
                    return false;
                }
                char c = cList.remove(cList.size() - 1);
                if (toInt(c) + toInt(chars[i]) != 0) {
                    return false;
                }
            }
        }
        return cList.size() == 0;
    }

    private int toInt(char c) {
        switch (c) {
            case '(': return 1;
            case '[': return 2;
            case '{': return 3;
            case ')': return -1;
            case ']': return -2;
            case '}': return -3;
            default: return 0;
        }
    }

    public void test() {
        System.out.println(isValid("{()[{[]}]({}){()}}"));
    }
}
