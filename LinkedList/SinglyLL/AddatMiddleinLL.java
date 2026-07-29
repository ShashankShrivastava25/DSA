public class AddatMiddleinLL {
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
    public int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addMiddle(int index, int data) { // O(n)
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String args[]) {
        AddatMiddleinLL list = new AddatMiddleinLL();
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(6);
        list.addFirst(7);
        list.addFirst(8);
        list.addFirst(9);
        list.addMiddle(3, 0);
        list.print();
        System.out.println("");
        System.out.print("Size of LL : " + list.size); // O(1)
    }
}
