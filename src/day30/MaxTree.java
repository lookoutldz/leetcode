package day30;

import utils.TreeNode;

public class MaxTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return nums == null ? null : recursive(nums, 0, nums.length - 1);
    }

    private TreeNode recursive(int[] nums, int start, int end) {
        if (end - start < 0) {
            return null;
        }
        if (end == start) {
            return new TreeNode(nums[start]);
        }
        int max = nums[start];
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = maxIndex == start ? null : recursive(nums, start, maxIndex - 1);
        node.right = maxIndex == end ? null : recursive(nums, maxIndex + 1, end);
        return node;
    }

    public void test() {
        int[] nums = {3,2,1,6,0,5};
        TreeNode node = constructMaximumBinaryTree(nums);
        return;
    }
}
