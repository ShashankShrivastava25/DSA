public class LLisPalindromeOrNot {
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

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public Node findMid(Node head) {
        Node slow = head; // turtle
        Node fast = head; // hare
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }
        return slow;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // find mid
        Node midNode = findMid(head);
        // reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // compare both sides
        Node left = head;
        Node right = prev;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String args[]) {
        LLisPalindromeOrNot list = new LLisPalindromeOrNot();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.print();
        System.out.println();
        if (list.isPalindrome()) {
            System.out.print("LL is Palindrome");
        } else {
            System.out.print("LL is not Palindrome");
        }
    }
}
