package day9;

import utils.PrintUtils;

import java.util.List;

public class CombineList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head, temp, key;
        if (l2.val < l1.val) {
            head = l2;
            temp = l2.next;
            l2.next = l1;
            l2 = temp;
            l1 = head;
        } else {
            head = l1;
        }
        key = head;
        while (l2 != null && l1 != null) {
            if (l2.val < l1.val) {
                temp = l2.next;
                l2.next = l1;
                key.next = l2;
                key = l2;
                l2 = temp;
            } else {
                key = l1;
                l1 = l1.next;
                if (l1 == null) {
                    key.next = l2;
                }
            }
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(0), temp = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public void test() {
        ListNode a = new ListNode(5);
        PrintUtils.print(a);

        ListNode b = new ListNode(1);
        ListNode b1 = new ListNode(2);
        b.next = b1;
        ListNode b2 = new ListNode(4);
        b1.next = b2;
        PrintUtils.print(b);

        ListNode result = mergeTwoLists2(a, b);
        PrintUtils.print(result);
    }
}
