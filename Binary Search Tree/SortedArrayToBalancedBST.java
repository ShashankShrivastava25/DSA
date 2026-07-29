public class SortedArrayToBalancedBST {
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

    public static Node buildBST(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node newNode = new Node(arr[mid]);
        newNode.left = buildBST(arr, start, mid - 1);
        newNode.right = buildBST(arr, mid + 1, end);
        return newNode;
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
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 }; // SORTED
        Node root = buildBST(arr, 0, arr.length - 1);
        preorder(root);
    }
}
