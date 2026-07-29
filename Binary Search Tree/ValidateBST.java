public class ValidateBST {
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

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean isValid(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && min.data >= root.data) {
            return false;
        }
        if (max != null && max.data <= root.data) {
            return false;
        }
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }

    public static void main(String args[]) {
        int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        Node min = null;
        Node max = null;
        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        inorder(root);
        System.out.println();
        if (isValid(root, min, max)) {
            System.out.print("Valid BST");
        } else {
            System.out.print("Invalid BST");
        }
    }
}
