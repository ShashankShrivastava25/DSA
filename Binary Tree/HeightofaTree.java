public class HeightofaTree {

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

    public static class BinaryTree {
        static int idx = -1;

        public Node buildBT(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildBT(nodes);
            newNode.right = buildBT(nodes);
            return newNode;
        }

        public int height(Node root) {
            Node currNode = root;
            if (currNode == null) {
                return 0;
            }
            int height = Math.max(height(root.left), height(root.right)) + 1;
            return height;
        }
    }

    public static void main(String args[]) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBT(nodes);
        System.out.println("height of the tree = " + tree.height(root));
        System.out.println("no. of nodes used = " + tree.height(root));
        System.out.print("no. of edges used = " + (tree.height(root) - 1));
    }
}
