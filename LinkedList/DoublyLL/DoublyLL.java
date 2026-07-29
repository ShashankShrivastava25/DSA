public class DoublyLL {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public int size;

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addFirst(int data) { // O(1)
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        size++;
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) { // O(1)
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    public int removeFirst() { // O(1)
        if (head == null) {
            System.out.println("LL is empty");
            size = 0;
            return Integer.MIN_VALUE;
        }
        if (head.next == null) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removeLast() { // O(1)
        if (head == null) {
            System.out.println("LL is empty");
            size = 0;
            return Integer.MIN_VALUE;
        }
        if (head.next == null) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node last = tail;
        int val = last.data;
        tail = tail.prev;
        tail.next = null;
        last.prev = null;
        size--;
        return val;
    }

    public static void main(String args[]) {
        DoublyLL ll = new DoublyLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.print();
        System.out.println("Size of LL is " + ll.size);
        ll.removeFirst();
        ll.print();
        ll.removeLast();
        ll.print();
        System.out.print("Size of LL is " + ll.size);
    }
}
