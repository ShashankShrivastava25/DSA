public class RemoveFirstinLL {
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

    public void removeFirst() {
        if (size == 0) {
            System.out.print("LL is empty");
            return;
        } else if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        } else {
            head = head.next;
            size--;
        }
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
        RemoveFirstinLL list = new RemoveFirstinLL();
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);
        list.print();
        System.out.println();
        System.out.print("Size of LL is " + list.size);
        System.out.println();
        list.removeFirst();
        list.print();
        System.out.println();
        System.out.print("Size of LL is " + list.size);
    }
}
