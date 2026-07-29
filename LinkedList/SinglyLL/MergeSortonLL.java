public class MergeSortonLL {
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

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSort(Node head) { // TC O(nlogn)
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    private Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            temp = temp.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            temp.next = head2;
            temp = temp.next;
            head2 = head2.next;
        }
        mergeLL = mergeLL.next;
        return mergeLL;
    }

    public static void main(String args[]) {
        MergeSortonLL list = new MergeSortonLL();

        head = new Node(7);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(8);
        head.next.next.next.next.next = new Node(1);

        System.out.println("Before Sorting:");
        list.print();
        System.out.println();

        list.mergeSort(head);

        System.out.println("After Sorting:");
        list.print();
    }
}
