package day27;

import utils.PrintUtils;
import utils.TreeNode;

public class InvertBTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;

        return root;
    }

    public void test() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-3);
        root.left.left = new TreeNode(-10);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root = invertTree(root);
        return;
    }
}
