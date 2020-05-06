package day7;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            char[] commonChars = common.toCharArray();
            char[] matchChars = strs[i].toCharArray();
            int j = 0, commonLength = commonChars.length > matchChars.length ? matchChars.length : commonChars.length;
            if (commonLength < 1) {
                return "";
            }
            while (j < commonLength) {
                if (commonChars[j] != matchChars[j]) {
                    break;
                }
                j++;
            }
            common = String.valueOf(commonChars).substring(0, j);
        }
        return common;
    }

    public void test() {
        String[] strs = new String[]{"float", "flat", "fll", ""};
        String common = longestCommonPrefix(strs);
        System.out.println(common);
    }
}
