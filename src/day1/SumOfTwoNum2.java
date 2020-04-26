package day1;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwoNum2 {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<>(4);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                index[0] = map.get(nums[i]) + 1;
                index[1] = i + 1;
            } else {
                map.put(target - nums[i], i);
            }
        }
        return index;
    }

    public int[] twoSum2(int[] nums, int target) {
        int border = nums.length - 1, key = border / 2;
        while (nums[key] > target) {
            border = key;
            key = border / 2;
        }
        key = 0;
        while (key < border) {
            if (nums[key] + nums[border] == target) {
                return new int[] {key + 1, border + 1};
            } else if (nums[key] + nums[border] < target) {
                key++;
            } else {
                border--;
            }
        }
        return null;
    }

    public void test() {
        int[] nums = {1, 2, 5, 6, 8, 9, 11, 13, 17};
        int[] result = twoSum2(nums, 6);
        for (int i : result) {
            System.out.print(i + "\t");
        }
    }
}
