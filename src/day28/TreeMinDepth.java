package day28;

import utils.TreeNode;

public class TreeMinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return recursive(root);
    }

    private int recursive(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left != null && node.right != null) {
            return 1 +  Math.min(recursive(node.left), recursive(node.right));
        }
        if (node.left == null) {
            return 1 + recursive(node.right);
        } else {
            return 1 + recursive(node.left);
        }
    }
}
