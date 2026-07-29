public class AVLtree {
    public static class Node {
        int data;
        Node left;
        Node right;
        int height;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    public static int getBalanceFactor(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perforn Rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // Return new root
        return y;
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perforn Rotation
        x.right = y;
        y.left = T2;

        // Update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // Return new root
        return x;
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));
        int bf = getBalanceFactor(root);

        // left-left case
        if (bf > 1 && root.left.data > key) {
            return rightRotate(root);
        }

        // right-right case
        if (bf < -1 && root.right.data < key) {
            return leftRotate(root);
        }

        // left-right case
        if (bf > 1 && root.left.data < key) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // right-left case
        if (bf < -1 && root.right.data > key) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {
        root = insert(root, 40);
        root = insert(root, 20);
        root = insert(root, 10);
        root = insert(root, 25);
        root = insert(root, 30);
        root = insert(root, 22);
        root = insert(root, 50);
        preorder(root);
    }
}
