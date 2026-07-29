package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueUsingJCF {

    public static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String args[]) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3); // O(logn)
        pq.add(4);
        pq.add(1);
        pq.add(7);
        while (!pq.isEmpty()) {
            System.out.println(pq.peek()); // O(1)
            pq.remove(); // O(logn)
        }

        System.out.println();

        // In Descending Order

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        pq1.add(3);
        pq1.add(4);
        pq1.add(1);
        pq1.add(7);
        while (!pq1.isEmpty()) {
            System.out.println(pq1.peek());
            pq1.remove();
        }

        System.out.println();

        // Priority Queue for Objects

        PriorityQueue<Student> pq2 = new PriorityQueue<>();
        pq2.add(new Student("aman", 23)); // O(logn)
        pq2.add(new Student("adam", 2));
        pq2.add(new Student("wxyz", 389));
        pq2.add(new Student("abcd", 245));
        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek().name + " -> " + pq2.peek().rank); // O(1)
            pq2.remove(); // O(logn)
        }

        System.out.println();

        // In Reverse Order

        PriorityQueue<Student> pq3 = new PriorityQueue<>(Comparator.reverseOrder());
        pq3.add(new Student("aman", 23));
        pq3.add(new Student("adam", 2));
        pq3.add(new Student("wxyz", 389));
        pq3.add(new Student("abcd", 245));
        while (!pq3.isEmpty()) {
            System.out.println(pq3.peek().name + " -> " + pq3.peek().rank);
            pq3.remove();
        }

        System.out.println();
    }
}
