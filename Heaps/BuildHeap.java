package Heaps;

import java.util.ArrayList;

public class BuildHeap {
    public static class Heap1 { // build min heap
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int val) { // TC O(1 + logn) -> O(logn)
            arr.add(val); // O(1)
            int x = arr.size() - 1; // x -> idx of child node
            int y = (x - 1) / 2; // y -> idx of parent node
            while (arr.get(y) > arr.get(x)) { // O(logn)
                int temp;
                temp = arr.get(x);
                arr.set(x, arr.get(y));
                arr.set(y, temp);
                x = y;
                y = (x - 1) / 2;
            }
        }

        public int peek() { // TC O(1)
            return arr.get(0);
        }

        private void heapify(int i) { // O(logn)
            int minIdx = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }
            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }
            if (minIdx != i) {
                int temp;
                temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);
                heapify(minIdx);
            }
        }

        public int remove() { // TC O(1 + logn) -> O(logn)
            int data = arr.get(0);
            // swap 1st and last node
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            // delete last node
            arr.remove(arr.size() - 1); // O(1)
            // call heapify
            heapify(0); // O(logn)
            return data;
        }

        public boolean isEmpty() { // TC O(1)
            return arr.size() == 0;
        }
    }

    public static class Heap2 { // build max heap
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int val) { // TC O(1 + logn) -> O(logn)
            arr.add(val); // O(1)
            int x = arr.size() - 1; // x -> idx of child node
            int y = (x - 1) / 2; // y -> idx of parent node
            while (arr.get(y) < arr.get(x)) { // O(logn)
                int temp;
                temp = arr.get(x);
                arr.set(x, arr.get(y));
                arr.set(y, temp);
                x = y;
                y = (x - 1) / 2;
            }
        }

        public int peek() { // TC O(1)
            return arr.get(0);
        }

        private void heapify(int i) { // O(logn)
            int maxIdx = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < arr.size() && arr.get(maxIdx) < arr.get(left)) {
                maxIdx = left;
            }
            if (right < arr.size() && arr.get(maxIdx) < arr.get(right)) {
                maxIdx = right;
            }
            if (maxIdx != i) {
                int temp;
                temp = arr.get(i);
                arr.set(i, arr.get(maxIdx));
                arr.set(maxIdx, temp);
                heapify(maxIdx);
            }
        }

        public int remove() { // TC O(1 + logn) -> O(logn)
            int data = arr.get(0);
            // swap 1st and last node
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);
            // delete last node
            arr.remove(arr.size() - 1); // O(1)
            // call heapify
            heapify(0); // O(logn)
            return data;
        }

        public boolean isEmpty() { // TC O(1)
            return arr.size() == 0;
        }
    }

    public static void main(String args[]) {
        Heap1 h1 = new Heap1();
        h1.add(3);
        h1.add(4);
        h1.add(1);
        h1.add(5);
        while (!h1.isEmpty()) {
            System.out.println(h1.peek());
            h1.remove();
        }
        System.out.println();
        Heap2 h2 = new Heap2();
        h2.add(3);
        h2.add(4);
        h2.add(1);
        h2.add(5);
        while (!h2.isEmpty()) {
            System.out.println(h2.peek());
            h2.remove();
        }
    }
}
