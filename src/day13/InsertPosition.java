package day13;

public class InsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] < target) {
                if (i == len - 1) {
                    return len;
                }
            } else {
                return i;
            }
        }
        return 0;
    }

    public void test() {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums, 1));
    }
}
