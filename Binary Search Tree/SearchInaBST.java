public class SearchInaBST {
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

    public static boolean isFound(Node root, int key) { // TC O(h), h -> height of tree
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return isFound(root.left, key);
        } else {
            return isFound(root.right, key);
        }
    }

    public static void main(String args[]) {
        int nodes[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        for (int i = 0; i < nodes.length; i++) {
            root = insert(root, nodes[i]);
        }
        int key = 5;
        if (isFound(root, key)) {
            System.out.print("key is found");
        } else {
            System.out.print("not found");
        }
    }
}
