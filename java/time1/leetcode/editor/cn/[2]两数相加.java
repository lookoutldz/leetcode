package time1.leetcode.editor.cn;
//leetcode submit region begin(Prohibit modification and deletion)

import datastructure.ListNode;
import util.DisplayUtils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0, value = 0;
        while (l1 != null || l2 != null) {
            // 空则构建前导 0
            ListNode n1 = l1 == null ? new ListNode(0) : l1;
            ListNode n2 = l2 == null ? new ListNode(0) : l2;
            value = (n1.val + n2.val + carry) % 10;
            carry = (n1.val + n2.val + carry) / 10;
            if (head == null) {
                head = new ListNode(value);
                tail = head;
            } else {
                tail.next = new ListNode(value);
                tail = tail.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode ans = new Solution2().addTwoNumbers(l1, l2);
        DisplayUtils.println(ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
