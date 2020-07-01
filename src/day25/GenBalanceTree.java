package day25;

import utils.PrintUtils;
import utils.TreeNode;

public class GenBalanceTree {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return recursive(nums, 0, nums.length - 1);
    }
    
    private TreeNode recursive(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        int mid = begin + (end - begin) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = recursive(nums, begin, mid-1);
        node.right = recursive(nums, mid+1, end);
        
        return node;
    }

    public void test() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-3);
        root.left.left = new TreeNode(-10);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(9);
        PrintUtils.bfsTreeNode(root);
    }
}
