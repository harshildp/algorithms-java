public class DistanceBetween {
    public static void main(String[] args) {
        int[] inputTree = {2,1,3,4};
        System.out.println(distanceBetween(inputTree, 1, 4));
    }

    public static int distanceBetween(int[] nodes, int node1, int node2) {
        TreeNode root = null;
        for (int node: nodes) {
            root = buildTree(root, node);
        }

        TreeNode lca = findCommonAncestor(root, node1, node2);
        int distance = getDistance(lca, node1) + getDistance(lca, node2);
        return distance;
    }

    public static TreeNode buildTree(TreeNode root, int node) {
        if (root == null) {
            root = new TreeNode(node);
        } else if (root.getData() < node) {
            if (root.getRightChild() == null) {
                root.setRightChild(new TreeNode(node));
            } else {
                buildTree(root.getRightChild(), node);
            }
        } else {
            if (root.getLeftChild() == null) {
                root.setLeftChild(new TreeNode(node));
            } else {
                buildTree(root.getLeftChild(), node);
            }
        }   
        return root;
    }

    public static TreeNode findCommonAncestor(TreeNode root, int node1, int node2) {
        if (root == null) return root;

        while (root != null) {
            if (root.getData() > node1 && root.getData() > node2) {
                root = root.getLeftChild();
            } else if (root.getData() < node1 && root.getData() < node2) {
                root = root.getRightChild();
            } else {
                return root;
            }
        }

        return root;
    }

    public static int getDistance(TreeNode root, int node) {
        int distance = 0;
        while (root != null) {
            if (root.getData() == node) {
                return distance;
            } else if (root.getData() > node) {
                distance++;
                root = root.getLeftChild();
            } else {
                distance++;
                root = root.getRightChild();
            }
        }

        return distance;
    }
 }