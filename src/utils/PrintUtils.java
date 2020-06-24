package utils;

import java.util.List;

public class PrintUtils {

    public static void print(short[] nums) {
        if (nums == null) {
            System.out.println((Object) null);
            return;
        }
        for (short num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }

    public static void print(int[] nums) {
        if (nums == null) {
            System.out.println((Object) null);
            return;
        }
        for (int num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }

    public static void print(long[] nums) {
        if (nums == null) {
            System.out.println((Object) null);
            return;
        }
        for (long num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }

    public static void print(float[] nums) {
        if (nums == null) {
            System.out.println((Object) null);
            return;
        }
        for (float num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }

    public static void print(double[] nums) {
        if (nums == null) {
            System.out.println((Object) null);
            return;
        }
        for (double num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }

    public static void print(char[] nums) {
        if (nums == null) {
            System.out.println((Object) null);
            return;
        }
        for (char num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }

    public static void print(byte[] nums) {
        if (nums == null) {
            System.out.println((Object) null);
            return;
        }
        for (byte num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }

    public static void print(boolean[] nums) {
        if (nums == null) {
            System.out.println((Object) null);
            return;
        }
        for (boolean num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }

    public static void print(List<? extends Number> nums) {
        if (nums == null) {
            System.out.println((Object) null);
            return;
        }
        for (Number num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }

    public static void print(ListNode listNode) {
        if (listNode == null) {
            System.out.println((Object) null);
            return;
        }
        while (listNode != null) {
            System.out.print(listNode.val + "\t");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
