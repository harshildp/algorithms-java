import java.util.Map;
import java.util.HashMap;

/* Given the preorder and inorder traversals of a Binary Tree,
recreate the original tree */

public class MakeTreeFromOrder {
    public static int cur = 0;
    public static void main(String [] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode ans = buildTree(preorder, inorder);

        print(ans);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> in = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }

        return helper(in, preorder, 0, preorder.length - 1);
    }

    public static TreeNode helper(Map<Integer, Integer> in, int[] preorder, int l, int r) {
        if (l > r) return null;

        int pre = preorder[cur];
        int i = in.get(pre);

        TreeNode node = new TreeNode(pre);
        cur++;

        if (l == r) return node;

        node.setLeftChild(helper(in, preorder, l, i - 1));
        node.setRightChild(helper(in, preorder, i + 1, r));

        return node;
    }

    public static void print(TreeNode root) {
        if (root == null) return;
        print(root.getLeftChild());
        System.out.print(root.toString() + " ");
        print(root.getRightChild());
    }
}