package day12;

public class StrStr {

    /**
     * 超时解法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (i+j >= haystack.length() || haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                } else {
                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Sunday算法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int offset = 0, lastIndex = haystack.length()-needle.length()+1;
        for (int i = 0; i < lastIndex; i+=offset) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j)!=needle.charAt(j)) {
                    if (i + needle.length() >= haystack.length()) {
                        return -1;
                    }
                    offset = calShift(haystack.charAt(i+needle.length()), needle);
                    break;
                }
                if (j == needle.length()-1) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int calShift(char c, String pattern) {
        if (!pattern.contains(String.valueOf(c))) {
            return pattern.length() + 1;
        } else {
            return pattern.length() - pattern.lastIndexOf(String.valueOf(c));
        }
    }

    public void test() {
        System.out.println(strStr2("a", "bba"));
    }
}
