package day31;

import utils.TreeNode;

public class FindRouteInTree {

    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && recursive(root, 0, sum);
    }

    private boolean recursive(TreeNode node, int ancestorSum, int sum) {
        if (node.left != null && recursive(node.left, ancestorSum + node.val, sum)) {
            return true;
        }
        if (node.right != null && recursive(node.right, ancestorSum + node.val, sum)) {
            return true;
        }
        if (node.left == null && node.right == null && ancestorSum + node.val == sum) {
            return true;
        }
        return false;
    }
}
