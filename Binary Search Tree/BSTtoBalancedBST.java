import java.util.ArrayList;

public class BSTtoBalancedBST {
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

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node convert(ArrayList<Integer> seq, int start, int end) { // ArrayList sequence to Balanced BST
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node newNode = new Node(seq.get(mid));
        newNode.left = convert(seq, start, mid - 1);
        newNode.right = convert(seq, mid + 1, end);
        return newNode;
    }

    public static Node balanceBST(Node root) { // TC O(n+n) -> O(n)
        ArrayList<Integer> inorderSeq = new ArrayList<>();
        getInorder(root, inorderSeq); // O(n)
        root = convert(inorderSeq, 0, inorderSeq.size() - 1); // O(n)
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
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        preorder(root);
        System.out.println();
        root = balanceBST(root);
        preorder(root);
    }
}
