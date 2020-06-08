package day21;

import utils.PrintUtils;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1, index = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            nums1[index--] = nums1[index1] > nums2[index2] ? nums1[index1--] : nums2[index2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, index2+1);
    }

    public void test() {
        int m = 4, n = 3;
        int[] num1 = new int[] {1,2,7,7,0,0,0};
        int[] num2 = new int[] {2,5,6};
        merge(num1, m, num2, n);
        PrintUtils.print(num1);
    }
}
