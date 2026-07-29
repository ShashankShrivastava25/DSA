package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {
    public static class Stack1 {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() { // O(1)
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) { // O(1)
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public int pop() { // O(n)
            if (isEmpty()) {
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public int peek() { // O(n)
            if (isEmpty()) {
                return -1;
            }
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }

    public static class Stack2 {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public boolean isEmpty() { // O(1)
            return q1.isEmpty() && q2.isEmpty();
        }

        public void push(int data) { // O(n)
            if (q1.isEmpty()) {
                q1.add(data);
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            } else {
                q2.add(data);
                while (!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
            }
        }

        public int pop() { // O(1)
            if (isEmpty()) {
                return -1;
            }
            int top = -1;
            if (q1.isEmpty()) {
                top = q2.remove();
            } else {
                top = q1.remove();
            }
            return top;
        }

        public int peek() { // O(1)
            if (isEmpty()) {
                return -1;
            }
            int top = -1;
            if (q1.isEmpty()) {
                top = q2.peek();
            } else {
                top = q1.peek();
            }
            return top;
        }
    }

    public static void main(String args[]) {
        Stack1 s1 = new Stack1();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        while (!s1.isEmpty()) {
            System.out.println(s1.peek());
            s1.pop();
        }
        System.out.println();
        Stack2 s2 = new Stack2();
        s2.push(1);
        s2.push(2);
        s2.push(3);
        while (!s2.isEmpty()) {
            System.out.println(s2.peek());
            s2.pop();
        }
    }
}
