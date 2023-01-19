package time1.leetcode.editor.cn;

import util.DisplayUtils;

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

    // Manachar 算法
    // 参考资料
    // https://blog.nowcoder.net/n/6f3084d9acf74111b37b6990262a2d15
    // https://www.cnblogs.com/yoke/p/6938193.html
    // https://segmentfault.com/a/1190000003914228
    public String longestPalindrome3(String s) {
        // 构造辅助串
        int len = s.length() * 2 + 1;
        char[] cs = new char[len];
        for (int i = 0; i < len; i++) {
            cs[i] = i % 2 == 0 ? '#' : s.charAt(i / 2);
        }
        // 构造 P 数组
        int[] p = new int[len];
        for (int i = 0; i < len; i++) {
            p[i] = 1;
        }

        // manachar
        int mx = 1, center = 1, size = -1, start = 0;
        for (int i = 1; i < len - 1; i++) {
            if (i < mx) {
                // 当前位置在回文范围内
                p[i] = Math.min(p[center * 2 - i], mx - i);
            }
            while (i - p[i] >= 0 && i + p[i] < len && cs[i - p[i]] == cs[i + p[i]]) {
                p[i]++;
            }
            if (mx < i + p[i]) {
                mx = i + p[i];
                center = i;
            }
            if (size < p[i] - 1) {
                size = p[i] - 1;
                start = (center - size) / 2;
            }
        }

        return s.substring(start, start + size);
    }

    public static void main(String[] args) {
        String s = "babaadab";
        System.out.println(new Solution5().longestPalindrome3(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
