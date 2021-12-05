package info.sandroalmeida;

public class FlattenBinaryTreeLinkedList {

    public static void flatten(TreeNode root) {
        helper(root);
    }
    private static TreeNode helper(TreeNode node) {
        if(node == null) return null;
        if(node.left == null && node.right == null) return node;

        TreeNode leftTail = helper(node.left);
        TreeNode rightTail = helper(node.right);

        if(leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail != null ? rightTail : leftTail;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        flatten(root);
    }

}
