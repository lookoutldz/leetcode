package day31;

import utils.TreeNode;

public class FindRouteInTree {

    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && recursive(root, 0, sum);
    }

    private boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    private boolean recursive(TreeNode node, int ancestorSum, int sum) {
        if (node.left != null && recursive(node.left, ancestorSum + node.val, sum)) {
            return true;
        }
        if (node.right != null && recursive(node.right, ancestorSum + node.val, sum)) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return ancestorSum + node.val == sum;
        }
        return false;
    }
}
