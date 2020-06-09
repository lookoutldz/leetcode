package day22;

public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetricRecursive(root.left, root.right);
    }

    public boolean symmetricRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return symmetricRecursive(p.left, q.right) && symmetricRecursive(p.right, q.left);
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }
}
