public class SearchKeyinLL {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public int iterativeSearch(int key) { // Tc O(n) SC O(1)
        Node curr = head;
        int idx = 0;
        while (curr.next != null) {
            if (curr.data == key) {
                return idx;
            }
            idx++;
            curr = curr.next;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recursiveSearch(int key) { // TC O(n) SC O(n)
        return helper(head, key);
    }

    public static void main(String args[]) {
        SearchKeyinLL list = new SearchKeyinLL();
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        System.out.println("Key is found at index : " + list.iterativeSearch(4));
        System.out.println("Key is found at index : " + list.recursiveSearch(4));
    }
}
