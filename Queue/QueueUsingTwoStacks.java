package Queue;

import java.util.Stack;

public class QueueUsingTwoStacks {
    public static class Queue1 {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() { // O(1)
            return s1.isEmpty();
        }

        public void add(int data) { // O(n)
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int remove() { // O(1)
            if (s1.isEmpty()) {
                return -1;
            }
            return s1.pop();
        }

        public int peek() { // O(1)
            if (s1.isEmpty()) {
                return -1;
            }
            return s1.peek();
        }

    }

    public static class Queue2 {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() { // O(1)
            return s1.isEmpty();
        }

        public void add(int data) { // O(1)
            s1.push(data);
        }

        public int remove() { // O(n)
            if (s1.isEmpty()) {
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int val = s2.pop();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return val;
        }

        public int peek() { // O(n)
            if (s1.isEmpty()) {
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int val = s2.peek();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return val;
        }
    }

    public static void main(String args[]) {
        Queue1 q1 = new Queue1();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        while (!q1.isEmpty()) {
            System.out.println(q1.peek());
            q1.remove();
        }
        System.out.println();
        Queue2 q2 = new Queue2();
        q2.add(1);
        q2.add(2);
        q2.add(3);
        while (!q2.isEmpty()) {
            System.out.println(q2.peek());
            q2.remove();
        }
    }
}
