package Queue;

public class CircularQueueUsingArray {
    public static class CircularQueue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        public CircularQueue(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        public boolean isEmpty() { // O(1)
            return rear == -1 && front == -1;
        }

        public boolean isFull() { // O(1)
            return (rear + 1) % size == front;
        }

        public void add(int data) { // O(1)
            if (isFull()) {
                System.out.print("There is no space left in queue");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() { // O(1)
            if (isEmpty()) {
                System.out.print("There is no element in queue");
                return -1;
            }
            int val = arr[front];
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return val;
        }

        public int peek() { // O(1)
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]) {
        CircularQueue q = new CircularQueue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);
        q.remove();
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
