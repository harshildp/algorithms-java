import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class CloneTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.setLeftChild(new TreeNode(1));
        root.setRightChild(new TreeNode(3));
        TreeNode t = root;
        t = t.getRightChild();
        t.setRandom(root);

        TreeNode cloned = cloneTree(root);

        System.out.println(cloned);
        System.out.println(cloned.getLeftChild());
        System.out.println(cloned.getRightChild());
        System.out.println(cloned.getRightChild().getRandom());

    }

    public static TreeNode cloneTree(TreeNode root) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp != null) {
                TreeNode clone = new TreeNode(temp.getData());
                map.put(temp, clone);
                q.offer(temp.getLeftChild());
                q.offer(temp.getRightChild());
            }
        }

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp != null) {
                TreeNode clone = map.get(temp);

                q.offer(temp.getLeftChild());
                q.offer(temp.getRightChild());

                if (temp.getLeftChild() != null) clone.setLeftChild(map.get(temp.getLeftChild()));
                if (temp.getRightChild() != null) clone.setRightChild(map.get(temp.getRightChild()));
                if (temp.getRandom() != null) clone.setRandom(map.get(temp.getRandom()));
            }
        }

        return map.get(root);
    }
}