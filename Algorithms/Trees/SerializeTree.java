import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class SerializeTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode temp = root;

        temp.setLeftChild(new TreeNode(9));
        temp.setRightChild(new TreeNode(20));
        temp.getRightChild().setLeftChild(new TreeNode(15));
        temp.getRightChild().setRightChild(new TreeNode(7));

        String serializedTree = serialize(root);
        System.out.println("Serialized tree is: " + serializedTree);

        TreeNode rebuiltTree = deserialize(serializedTree);
        print(rebuiltTree);

    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);

        return sb.toString();
    }

    private static void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            sb.append(",");
            return;
        } else {
            sb.append(root.getData());
            sb.append(",");
        }

        buildString(root.getLeftChild(), sb);
        buildString(root.getRightChild(), sb);
    }

    public static TreeNode deserialize(String s) {
        Queue<String> q = new LinkedList<>(Arrays.asList(s.split(",")));
        return buildTree(q);
    }

    private static TreeNode buildTree(Queue<String> q) {
        String val = q.poll();

        if (val.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.setLeftChild(buildTree(q));
        node.setRightChild(buildTree(q));

        return node;
    }

    public static void print(TreeNode root) {
        if (root == null) return;
        print(root.getLeftChild());
        System.out.print(root.toString() + " ");
        print(root.getRightChild());
    }
}