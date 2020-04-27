package day3;

public class MaxStack {

    Node head;

    /** initialize your data structure here. */
    public MaxStack() {
    }

    void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head.prev = new Node(x, Math.max(x, head.max), null, head);
            head = head.prev;
        }
    }

    int pop() {
        int result = head.val;

        if (head.next != null) {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        } else {
            head = head.next;
        }

        return result;
    }

    int top() {
        return head.val;
    }

    int peekMax() {
        return head.max;
    }

    int popMax() {
        Node key = head;
        while (key.val < key.max && key.next != null) {
            key = key.next;
        }
        int result = key.val;
        if (key.prev == null) {
            return pop();
        }
        if (key.next == null) {
            Node drop = key;
            key = key.prev;
            key.max = key.val;
            drop.prev.next = null;
            drop.prev = null;
            while (key.prev != null) {
                key.prev.max = Math.max(key.prev.val, key.max);
                key = key.prev;
            }
            return result;
        }

        Node drop = key;
        key = key.prev;
        key.max = Math.max(drop.next.max, key.val);
        drop.prev.next = drop.next;
        drop.next.prev = drop.prev;
        drop.next = null;
        drop.prev = null;
        while (key.prev != null) {
            key.prev.max = Math.max(key.prev.val, key.max);
            key = key.prev;
        }
        return result;
    }

    private class Node {
        int val;
        int max;
        Node prev;
        Node next;
        private Node(int val, int max) {
            this.val = val;
            this.max = max;
        }
        private Node(int val, int max, Node prev, Node next) {
            this.val = val;
            this.max = max;
            this.prev = prev;
            this.next = next;
        }
    }

    public void test() {
        MaxStack stack = new MaxStack();
//        stack.push(-95);
//        stack.push(1);
//        System.out.println(stack.popMax()); // -95  -> 1
//        stack.push(-44);
//        stack.push(16);
//        System.out.println(stack.top()); // -95, -44, 16
//        stack.push(29);
//        stack.push(65);
//        stack.push(-18);
//        System.out.println(stack.pop()); // -95, -44, 16, 29, 65 -> -18
//        System.out.println(stack.popMax()); // -95, -44, 16, 29 -> 65
//        System.out.println(stack.pop()); // -95, -44, 16 -> 29
//        stack.push(78);
        stack.push(5);
        System.out.println(stack.peekMax());
        System.out.println(stack.popMax());
    }
}
/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack* obj = new MaxStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->peekMax();
 * int param_5 = obj->popMax();
 */