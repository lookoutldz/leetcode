package day17;

import utils.PrintUtils;

public class ArrayPlusOne {
    public int[] plusOne(int[] digits) {
        int enter = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + enter < 10) {
                digits[i] = digits[i] + enter;
                return digits;
            } else {
                digits[i] = 0;
                if (i == 0) {
                    int [] after = new int[digits.length + 1];
                    after[0] = 1;
                    for (int j = 0; j < digits.length; j++) {
                        after[j + 1] = digits[j];
                        return after;
                    }
                }
            }
        }
        return digits;
    }

    public void test() {
        int[] digits = new int[]{9,8,9};
        PrintUtils.print(plusOne(digits));
    }
}
