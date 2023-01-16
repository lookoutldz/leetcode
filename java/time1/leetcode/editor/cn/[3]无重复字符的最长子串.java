package time1.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int ans = 0;
        // map 记录每个字母的最大索引+1
        Map<Character, Integer> noRepeatIndexMap = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            if (noRepeatIndexMap.containsKey(c)) {
                // start 通过累积效应，记录了离当前坐标最近的前一个不重复字母的索引
                start = Math.max(noRepeatIndexMap.get(c), start);
            }
            ans = Math.max(end - start + 1, ans);
            noRepeatIndexMap.put(c, end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
