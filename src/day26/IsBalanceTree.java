package day26;

import utils.TreeNode;

public class IsBalanceTree {

    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ld = maxDepth(node.left);
        int rd = maxDepth(node.right);
        if (ld == -1 || rd == -1 || Math.abs(ld - rd) > 1) {
            return -1;
        }
        return Math.max(ld, rd) + 1;
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(isBalanced(root));
    }
}
