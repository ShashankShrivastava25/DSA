package Queue;

public class QueueUsingArray {

    public static class Queue {
        static int arr[];
        static int size;
        static int rear;

        public Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty() { // O(1)
            return rear == -1;
        }

        public void add(int data) { // O(1)
            if (rear == size - 1) {
                System.out.print("There is no empty space");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        public int remove() { // O(n)
            if (isEmpty()) {
                System.out.print("There is no element in queue");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public int peek() { // O(1)
            if (isEmpty()) {
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
