public class AddatLastinLL {
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

    void addLast(int data) { // O(1)
        Node newNode = new Node(data);
        if (head == null) {
            tail = head = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    void print() { // O(n)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String args[]) {
        AddatLastinLL list = new AddatLastinLL();
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.print();
    }
}
