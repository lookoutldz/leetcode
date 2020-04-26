package day1;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((target - nums[i]) == nums[j]) {
                    result[0] = nums[i];
                    result[1] = nums[j];
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<>(3,1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                index[0] = map.get(nums[i]);
                index[1] = i;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return index;
    }

    public void test() {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum2(nums, 9);
        for (int i : result) {
            System.out.print(i + "\t");
        }
    }
}
