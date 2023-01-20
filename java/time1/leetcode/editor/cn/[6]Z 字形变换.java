package time1.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution6 {

    // 可以考虑数学方式建立坐标系去映射，不过还是用朴素的堆叠字串更方便
    public String convert(String s, int numRows) {
        if (s.length() <= numRows) {
            return s;
        }
        List<StringBuilder> sbs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            sbs.add(new StringBuilder());
        }

        int flag = -1, row = 0;
        for (char c: s.toCharArray()) {
            sbs.get(row).append(c);
            if (row == 0 || row == numRows - 1) {
                flag = -flag;
            }
            row = row + flag;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ans.append(sbs.get(i).toString());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(new Solution6().convert(s, numRows));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
