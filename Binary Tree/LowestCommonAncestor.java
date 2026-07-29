import java.util.ArrayList;

public class LowestCommonAncestor {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Aproach 1 - TC O(n), SC O(n)

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean left = getPath(root.left, n, path);
        boolean right = getPath(root.right, n, path);
        if (left || right) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static Node lowestCommonAncestor1(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i - 1);
        return lca;
    }

    // Aproach 2 - TC O(n), SC O(1)

    public static Node lowestCommonAncestor2(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLca = lowestCommonAncestor2(root.left, n1, n2);
        Node rightLca = lowestCommonAncestor2(root.right, n1, n2);
        if (leftLca == null) {
            return rightLca;
        }
        if (rightLca == null) {
            return leftLca;
        }
        return root;
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        int n1 = 4;
        int n2 = 6;
        System.out.println(lowestCommonAncestor1(root, n1, n2).data);
        System.out.println(lowestCommonAncestor2(root, n1, n2).data);
    }
}
