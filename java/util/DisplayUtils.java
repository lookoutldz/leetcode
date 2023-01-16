package util;

import datastructure.ListNode;
import datastructure.TrieNode;

import java.util.List;

public class DisplayUtils {
    public static void println(ListNode listNode) {
        StringBuilder sb = new StringBuilder("[");
        while (listNode != null) {
            sb.append(listNode.val).append(",");
            listNode = listNode.next;
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        System.out.println(sb);
    }

    public static void println(char[][] css) {
        if (css == null || css.length == 0 || css[0].length == 0) {
            System.out.println("");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (char[] cs : css) {
            for (char c : cs) {
                sb.append(c).append("\t");
            }
            sb.deleteCharAt(sb.lastIndexOf("\t"));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void println(boolean[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (boolean b : arr) {
            sb.append(b).append(',');
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(']');
        System.out.println(sb);
    }

    public static void println(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (int b : arr) {
            sb.append(b).append(',');
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(']');
        System.out.println(sb);
    }

    public static void println(List<? extends Number> arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        if (arr.size() == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        for (Number b : arr) {
            sb.append(b).append(',');
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(']');
        System.out.println(sb);
    }

    public static void printlnMatrix(List<? extends List<? extends Number>> arrs) {
        if (arrs == null) {
            System.out.println("null");
            return;
        }
        if (arrs.size() == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (List<? extends Number> arr : arrs) {
            for (Number number : arr) {
                sb.append(number).append("\t");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void println(TrieNode node) {
        if (node.nextNode == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (node.nextNode[i].placed) {
                System.out.print((char)(i + 'a'));
                println(node.nextNode[i]);
            }
        }
    }

}
