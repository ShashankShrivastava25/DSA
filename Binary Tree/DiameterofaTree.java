public class DiameterofaTree {
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

    // Approach 1

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int height = 1 + Math.max(height(root.left), height(root.right));
        return height;
    }

    public static int findDiameter1(Node root) { // TC O(n^2)
        if (root == null) {
            return 0;
        }
        int leftDiameter = findDiameter1(root.left);
        int rightDiameter = findDiameter1(root.right);
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int selfDiameter = 1 + leftHeight + rightHeight;
        return Math.max(Math.max(leftDiameter, rightDiameter), selfDiameter);
    }

    // Approach 2

    static class Info {
        int diameter;
        int height;

        public Info(int d, int h) {
            this.diameter = d;
            this.height = h;
        }
    }

    public static Info findDiameter2(Node root) { // TC O(n)
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = findDiameter2(root.left);
        Info rightInfo = findDiameter2(root.right);
        int selfDiameter = Math.max(leftInfo.height + rightInfo.height + 1,
                Math.max(leftInfo.diameter, rightInfo.diameter));
        int ht = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(selfDiameter, ht);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(6);
        root.right.right = new Node(7);
        root.left.right.right = new Node(8);
        root.left.right.right.right = new Node(9);
        root.left.right.right.right.right = new Node(10);
        System.out.println(findDiameter1(root));
        System.out.println(findDiameter2(root).diameter);
    }
}
