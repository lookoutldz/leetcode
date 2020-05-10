package day11;

public class RemoveDuplicates {

    /**
     * O(1)空间
     * @param nums 排序数组
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;
    }

    public void test() {
        int[] a = new int[] {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(a);
    }
}
