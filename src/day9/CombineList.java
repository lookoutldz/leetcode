package day9;

import utils.PrintUtils;

import java.util.List;

public class CombineList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = l1.val > l2.val ? l2 : l1, cur1 = l1, cur2 = cur1, temp;
        while (l2 != null && cur1.next != null) {
            if (l2.val < cur1.val) {
                temp = l2.next;
                l2.next = cur1;
                cur1 = l2;
                l2 = temp;
            } else {
                cur2 = cur1;
                cur1 = cur1.next;
            }
        }
        return head;
    }

    public void test() {
        ListNode l1 = new ListNode(1), key;
        key = l1;
        for (int i = 2; i < 7; i+=2) {
            ListNode n = new ListNode(i);
            key.next = n;
            key = key.next;
        }
        PrintUtils.print(l1);
        ListNode l2 = new ListNode(1);
        key = l2;
        for (int i = 3; i < 7; i+=2) {
            ListNode n = new ListNode(i);
            key.next = n;
            key = key.next;
        }
        PrintUtils.print(l2);

        ListNode result = mergeTwoLists(l1, l2);
        PrintUtils.print(result);
    }
}
