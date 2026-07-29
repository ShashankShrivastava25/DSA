public class MinDistanceBwTwoNodes {
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

    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);
        if (leftLca == null) {
            return rightLca;
        }
        if (rightLca == null) {
            return leftLca;
        }
        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int left = lcaDist(root.left, n);
        int right = lcaDist(root.right, n);
        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right + 1;
        } else {
            return left + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        return lcaDist(lca, n1) + lcaDist(lca, n2);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        int n1 = 4;
        int n2 = 5;
        System.out.print(minDist(root, n1, n2));
    }
}
