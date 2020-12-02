public class MaxPathSum {
    public static int max;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode temp = root;

        temp.setLeftChild(new TreeNode(9));
        temp.setRightChild(new TreeNode(20));
        temp.getRightChild().setLeftChild(new TreeNode(15));
        temp.getRightChild().setRightChild(new TreeNode(7));

        System.out.println(maxPathSum(root));

    }

    public static int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }

    public static int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.getLeftChild());
        int right = helper(root.getRightChild());

        max = Math.max(max, left + right + root.getData());

        return Math.max(0, Math.max(left, right) + root.getData());
    }
}