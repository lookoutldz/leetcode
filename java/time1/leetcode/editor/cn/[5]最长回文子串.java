package time1.leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {

    // 暴力算
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] cs = s.toCharArray();
        int maxLen = 1, left = 0, right = 0;
        for (int i = 0; i < cs.length; i++) {
            for (int j = i + 1; j < cs.length; j++) {
                if (isPalindrome(cs, i, j) && j - i + 1 > maxLen) {
                    left = i;
                    right = j;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(left, right + 1);
    }

    private boolean isPalindrome(char[] cs, int left, int right) {
        while (left < right) {
            if (cs[left] != cs[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 动态规划
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1, left = 0;
        // 1. dp[i][j]表示 S[i,j] 是否为回文
        // 2. 已知: 若 S[i,j]==true 则 S[i] == S[j] 且 (S[i+1,j-1]==true 或 (j-1)-(i+1) < 2)
        // 反乘法口诀式 dp 表， 左上到右下斜向遍历， L 是 ij 的差值
        for (int L = 1; L < len; L++) {
            for (int i = 0; i + L < len; i++) {
                int j = i + L; // 注意在数组dp[i][j]中 i 表示纵坐标！
                if (s.charAt(i) == s.charAt(j) && (L < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    maxLen = L+1;
                    left = i;
                }
            }
        }

        return s.substring(left, left + maxLen);
    }

    public static void main(String[] args) {
        String s = "ab";
        System.out.println(new Solution5().longestPalindrome2(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
